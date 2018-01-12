package pts3.castgame.models;

public class CastGameObject {

    // Certaines vérifications ne seront jamais utilisées car redondantes/substituables par d'autres.
    // Je les laisse en commentaires.

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


    // variableName = (castType) new [instanciatedClass.getName()]();
    public CastGameResult affectation(CastGameTypable castType, CastGameTypable instanciatedClass) {
        if (instanciatedClass instanceof CastGameInterface) {
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, instanciatedClass.getName() + " ne peut être instancié : c'est une interface", "");
        }
        return affectation(castType, new CastGameObject((CastGameClass) instanciatedClass));
    }


    // variableName = [object.getVariableName()];
    private CastGameResult affectation(CastGameObject object) { //Les differents cas sont separes, au cas ou on aurait besoin d'explication

        CastGameClass otherObjectRealType = object.getRealObjectType();

        // instanceof pas terrible :/
        if (objectType instanceof CastGameClass) {

            CastGameClass objectTypeClass = (CastGameClass) objectType;

            // Si le type est enfant du type réel
            if (objectTypeClass.isChild(otherObjectRealType))
                return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "Impossible de convertir " + otherObjectRealType.getName() + " vers " + objectTypeClass.getName() + " (autre sens possible)", "");

            // Si le type n'est pas lié ou égal au type réel
            if (!objectTypeClass.isRelatedOrEqual(otherObjectRealType))
                return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "Impossible de convertir " + otherObjectRealType.getName() + " vers " + objectTypeClass.getName(), "");

            realObjectType = otherObjectRealType;

            // Le type réel est celui du type déclaré.
            if (objectTypeClass.equals(otherObjectRealType))
                return new CastGameResult(InstructionResult.OK);

            // Le type réel est enfant du type déclaré.
            if (objectTypeClass.isParent(otherObjectRealType))
                return new CastGameResult(InstructionResult.OK);
        }

        // instanceof pas terrible :/
        if (objectType instanceof CastGameInterface) {

            // Si le type réel n'implémente pas l'interface (qui est dans ce cas le type déclaré).
            if (!otherObjectRealType.implementsThis((CastGameInterface) objectType))
                return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, otherObjectRealType.getName() + "n'implémente pas l'interface " + objectType.getName(), "");

            realObjectType = otherObjectRealType;

            return new CastGameResult(InstructionResult.OK);
        }
        return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "Une erreur non gérée est survenue", "");
    }

    // variableName = ([castType.getName()]) || [object.getVariableName()];
    public CastGameResult affectation(CastGameTypable castType, CastGameObject object) {

        if (castType == null)
            return affectation(object);

        CastGameClass otherObjectRealType = object.getRealObjectType();

        if (castType instanceof CastGameClass) {

            CastGameClass castTypeClass = (CastGameClass) castType;

            if (!castTypeClass.isRelatedOrEqual(otherObjectRealType))
                return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "Impossible de convertir "
                        + otherObjectRealType.getName() + " vers " + castTypeClass.getName(), "");

            if (castTypeClass.isChild(otherObjectRealType))
                return new CastGameAnswer(InstructionResult.EXECUTION_FAIL, "Impossible de convertir "
                        + otherObjectRealType.getName() + " vers " + castTypeClass.getName(), "");
        }

        if (castType instanceof CastGameInterface) {

            if (!otherObjectRealType.implementsThis((CastGameInterface) castType))
                return new CastGameAnswer(InstructionResult.EXECUTION_FAIL, "Interface " + objectType.getName()
                        + " non implementee par l'autre objet de type réel " + otherObjectRealType.getName(), "");
        }
        return affectation(object.castedTo(castType)); // un cast comme en vrai mais ca ne change rien dans les calculs
    }

    // variableName.methodName();
    public CastGameAnswer executeMethod(String methodName) { // Je ne sais pas si il faut faire plus de verification sachant que bcp ont ete faite avant

        if (!isInitialized())
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "La méthode n'a pas été initialisée", "");

        if (!objectType.getPrototypeList().contains(methodName))
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "La méthode " + methodName + "() est inconnue pour le type " + objectType, "");

        if (!realObjectType.getPrototypeList().contains(methodName))
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "La méthode " + methodName + "() est inconnue pour le type " + realObjectType, "");

        return new CastGameAnswer(InstructionResult.OK, "Ca marche", realObjectType.getMethodList().get(methodName));
    }

    // System.out.println(variableName);
    public CastGameAnswer sysOutDisplay() {

        if (!isInitialized())
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "", "");

        return new CastGameAnswer(InstructionResult.OK, "Ca marche", realObjectType.getResultToString());
    }

    private CastGameClass getRealObjectType() {
        return realObjectType;
    }

    private boolean isInitialized() {
        return realObjectType != null;
    }


    /*
    UNUSED.
     */

    public CastGameResult affectation(CastGameTypable instanciatedClass) {
        if (instanciatedClass instanceof CastGameInterface)
            return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, instanciatedClass.getName() + " ne peut être instancié : c'est une interface", "");

        return affectation(new CastGameObject((CastGameClass) instanciatedClass));
    }

    public CastGameTypable getObjectType() {
        return objectType;
    }

    public String getVariableName() {
        return variableName;
    }

}