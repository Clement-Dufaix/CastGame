package pts3.castgame.models;

public class CastGameObject {

    //TODO ecrires des bons textes pour les resultats

    private CastGameTypable objectType;
    private CastGameClass realObjectType;
    private String variableName;

    // [objectType.getName()] variableName;
    public CastGameObject(CastGameTypable objectType, String variableName) throws IllegalArgumentException {

        if (objectType == null) // Programmation defensive. A voir si je dois faire ca ailleurs
            throw new IllegalArgumentException();
        this.objectType = objectType;

        if (variableName == null)
            throw new IllegalArgumentException();
        this.variableName = variableName;

        realObjectType = null;

    }


    // new [realObjectType.getName()]();
    private CastGameObject(CastGameClass realObjectType) { //private car aucun interet de faire un new dans le vide

        this.objectType = null;
        variableName = null;
        this.realObjectType = realObjectType;

    }


    // (cast) [object.variableName];
    private CastGameObject castedTo(CastGameTypable castType) { //private car la fonction ne contient aucune securitee
        CastGameObject o = new CastGameObject(realObjectType);
        o.objectType = castType;

        return o;
    }

    // variableName = new [instanciatedClass.getName()]();
    public CastGameResult affectation(CastGameTypable instanciatedClass) {
        if (instanciatedClass instanceof CastGameInterface)
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, instanciatedClass.getName() + " est une interface, donc non instanciable.", "");

        return affectation(new CastGameObject((CastGameClass) instanciatedClass));
    }


    // variableName = (castType) new [instanciatedClass.getName()]();
    public CastGameResult affectation(CastGameTypable castType, CastGameTypable instanciatedClass) {
        if (instanciatedClass instanceof CastGameInterface)
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, instanciatedClass.getName() + " est une interface, donc non instanciable.", "");

        return affectation(castType, new CastGameObject((CastGameClass) instanciatedClass));

    }


    // variableName = [object.getVariableName()];
    public CastGameResult affectation(CastGameObject object) { //Les differents cas sont separes, au cas ou on aurait besoin d'explication

        CastGameClass otherObjectRealType = object.getRealObjectType();

        if (objectType instanceof CastGameClass) {

            CastGameClass objectTypeClass = (CastGameClass) objectType;

            // cas general d'erreur : !isParentOrEqual()

            if (objectTypeClass.isChild(otherObjectRealType)) //verif suplementaire pour une explication plus detaille
                return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "Dans l'autre sens", "");

            if (!objectTypeClass.isRelatedOrEqual(otherObjectRealType))
                return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, objectTypeClass.getName() + " et "  + otherObjectRealType.getName() + " ne sont pas liées", "");

            //cas general de reussite : isParentOrEqual()

            realObjectType = otherObjectRealType; //affectation concrete

            if (objectTypeClass.equals(otherObjectRealType))
                return new CastGameResult(InstructionResult.OK);

            if (objectTypeClass.isParent(otherObjectRealType))
                return new CastGameResult(InstructionResult.OK);

        }

        if (objectType instanceof CastGameInterface) {

            if (!otherObjectRealType.implementsThis((CastGameInterface) objectType))
                return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "Interface " + objectType.getName() + " non implementee par l'autre objet de type réel " + otherObjectRealType.getName(), "");

            realObjectType = otherObjectRealType; // affectation concrete

            return new CastGameResult(InstructionResult.OK);

        }

        return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, ":(", ":(");
    }


    // variableName = ([castType.getName()]) [object.getVariableName()];
    public CastGameResult affectation(CastGameTypable castType, CastGameObject object) {

        if (castType == null)
            return affectation(object);

        CastGameClass otherObjectRealType = object.getRealObjectType();

        if (castType instanceof CastGameClass) {

            CastGameClass castTypeClass = (CastGameClass) castType;

            if (!castTypeClass.isRelatedOrEqual(otherObjectRealType))
                return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, castTypeClass.getName() + " et "  + otherObjectRealType.getName() + " ne sont pas liées", "");

            if (castTypeClass.isChild(otherObjectRealType))
                return new CastGameAnswer(InstructionResult.EXECUTION_FAIL, "Dans l'autre sens", "");

            // cas general de reussite : isParentOrEqual()
        }

        if (castType instanceof CastGameInterface) {

            if (!otherObjectRealType.implementsThis((CastGameInterface) castType))
                return new CastGameAnswer(InstructionResult.EXECUTION_FAIL, "Interface " + objectType.getName() + " non implementee par l'autre objet de type réel " + otherObjectRealType.getName(), "");

        }

        return affectation(object.castedTo(castType)); // un cast comme en vrai mais ca ne change rien dans les calculs
    }


    // variableName.methodName();
    public CastGameAnswer executeMethod(String methodName) { // Je ne sais pas si il faut faire plus de verification sachant que bcp ont ete faite avant

        if (!isInitialized())
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "executeMethod : !isInitialized()", "");

        if (!objectType.getPrototypeList().contains(methodName))
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "executeMethod : !objectType.getPrototypeList().contains(methodName)", "");

        if (!realObjectType.getPrototypeList().contains(methodName))
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "executeMethod : !realObjectType.getPrototypeList().contains(methodName)", "");

        return new CastGameAnswer(InstructionResult.OK, "Ca marche", realObjectType.getMethodList().get(methodName));
    }


    // System.out.println(variableName);
    public CastGameAnswer sysOutDisplay() {

        if (!isInitialized())
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "", "");

        return new CastGameAnswer(InstructionResult.OK, "Ca marche", realObjectType.getResultToString());
    }

    public CastGameTypable getObjectType() {
        return objectType;
    }

    public CastGameClass getRealObjectType() {
        return realObjectType;
    }

    public String getVariableName() {
        return variableName;
    }

    public boolean isInitialized() {
        return realObjectType != null;
    }

}