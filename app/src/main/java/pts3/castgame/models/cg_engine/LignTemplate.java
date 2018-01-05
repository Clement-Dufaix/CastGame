package pts3.castgame.models.cg_engine;

import java.util.Hashtable;
import java.util.Map;

public class LignTemplate {

    // C'est pas trop objet tout ça ^^
    private Integer declarationTypeNumber; // C'est juste pour nommer le nom de la carte ? Comment Clément modifie-t-il alors pour qu'au lieu de "Carte 1" on est "Guerrier" par exemple ?
    private int objectNumber;
    private Integer explicitCastNumber;
    private boolean useNew;
    private int otherItemNumber;

    public LignTemplate(Integer declarationTypeNumber, int objectNumber, Integer explicitCastNumber, boolean useNew,
                        int otherItemNumber) {
        super();
        this.declarationTypeNumber = declarationTypeNumber;
        this.objectNumber = objectNumber;
        this.explicitCastNumber = explicitCastNumber;
        this.useNew = useNew;
        this.otherItemNumber = otherItemNumber;
    }


    public Integer getDeclarationTypeNumber() {
        return declarationTypeNumber;
    }


    public int getObjectNumber() {
        return objectNumber;
    }


    public Integer getExplicitCastNumber() {
        return explicitCastNumber;
    }


    public boolean useNew() {
        return useNew;
    }


    public int getOtherItemNumber() {
        return otherItemNumber;
    }


    // Du coup, à faire des conditions plutôt que prendre des objets pour remplir (juste mon avis) ce qui fait que
    // la fonction de récupération sous forme de chaîne est pas top :/
    public String getString(Map<Integer, CastGameTypable> cardMap) {
        if (cardMap == null)
            cardMap = new Hashtable<Integer, CastGameTypable>();
        String result = "";
        if (declarationTypeNumber != null) {
            if (cardMap.containsKey(declarationTypeNumber))
                result += cardMap.get(declarationTypeNumber).getName() + " ";
            else
                result += "[Carte" + declarationTypeNumber + "] ";
        }
        result += "perso" + objectNumber + " = ";
        if (explicitCastNumber != null) {
            if (cardMap.containsKey(explicitCastNumber))
                result += "(" + cardMap.get(explicitCastNumber).getName() + ") ";
            else
                result += "([Carte" + explicitCastNumber + "]) ";
        }
        if (useNew) {
            result += "new ";
            if (cardMap.containsKey(otherItemNumber))
                result += cardMap.get(otherItemNumber).getName() + "()";
            else
                result += "[Carte" + otherItemNumber + "]()";
        } else
            result += "perso" + otherItemNumber;
        result += ";";
        return result;
    }

    public String getString() {
        return getString(null);
    }
}
