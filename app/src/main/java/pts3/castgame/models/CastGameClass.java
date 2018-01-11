package pts3.castgame.models;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class CastGameClass extends CastGameTypable {
    public static final Map<String, String> NO_METHOD = new Hashtable<String, String>();

    private CastGameClass parentClass;
    private Set<CastGameInterface> implementedInterfaces;
    private Map<String, String> methodList;
    private String resultToString;

    public CastGameClass(String name, String resultToString) { //laisser null comme parametre valide
        this(name, resultToString, NO_METHOD, null, NO_INTERFACE);
    }

    public CastGameClass(String name, String resultToString, Map<String, String> methodList) {
        this(name, resultToString, methodList, null, NO_INTERFACE);
    }

    public CastGameClass(String name, String resultToString, Map<String, String> methodList, CastGameClass parentClass) {
        this(name, resultToString, methodList, parentClass, NO_INTERFACE);
    }

    public CastGameClass(String name, String resultToString, Map<String, String> methodList, Set<CastGameInterface> implementedInterfaces) {
        this(name, resultToString, methodList, null, implementedInterfaces);
    }

    public CastGameClass(String name, String resultToString, Map<String, String> methodList, CastGameClass parentClass, Set<CastGameInterface> implementedInterfaces) {
        super(name);
        //Vérification
        //for (CastGameInterface i : implementedInterfaces)
        //    if (!methodList.keySet().containsAll(i.getPrototypeList()))
        //        throw new Exception();
        this.resultToString = resultToString;
        this.methodList = new Hashtable<String, String>(methodList);
        this.parentClass = parentClass;
        this.implementedInterfaces = new HashSet<CastGameInterface>(implementedInterfaces);
    }

    @Override
    public Set<String> getPrototypeList() {
        return getMethodList().keySet();
    }

    public Map<String, String> getMethodList() {
        if (parentClass == null)
            return new Hashtable<String, String>(methodList); //shallow cloning sinon on modifie l'attribut

        Map<String, String> result = parentClass.getMethodList();
        for (Map.Entry<String, String> entry : methodList.entrySet())
            result.put(entry.getKey(), entry.getValue()); //si la cle (le prototype) existe deja, redefinition

        return result;
    }

    public Set<CastGameInterface> getImplementedInterfaces() {
        Set<CastGameInterface> result = new HashSet<CastGameInterface>(implementedInterfaces);

        for (CastGameInterface i : implementedInterfaces)
            result.addAll(i.getExtendsInterfaces());

        return result;
    }

    public boolean implementsThis(CastGameInterface theInterface) {
        return getImplementedInterfaces().contains(theInterface);
    }

    public boolean isChild(CastGameClass supposedParent) {
        if (parentClass == null)
            return false;
        if (parentClass.equals(supposedParent))
            return true;
        return parentClass.isChild(supposedParent);
    }

    public boolean isChildOrEqual(CastGameClass supposedParent) {
        if (parentClass == null)
            return equals(supposedParent);
        if (equals(supposedParent))
            return true;
        return parentClass.isChildOrEqual(supposedParent);
    }

    public boolean isParent(CastGameClass supposedChild) {
        return supposedChild.isChild(this);
    }

    public boolean isParentOrEqual(CastGameClass supposedChild) {
        return supposedChild.isChildOrEqual(this);
    }

    public boolean isRelated(CastGameClass supposedRelated) {
        return isChild(supposedRelated) || isParent(supposedRelated);
    }

    public boolean isRelatedOrEqual(CastGameClass supposedRelated) {
        return isChildOrEqual(supposedRelated) || isParent(supposedRelated);
    }

    public String getResultToString() {
        return resultToString;
    }
}
