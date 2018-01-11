package pts3.castgame.models;

import java.util.Hashtable;
import java.util.Map;

public class LignTemplate {

    private Integer declarationTypeNumber;
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
            result += "(";
            if (cardMap.containsKey(explicitCastNumber))
                result += cardMap.get(explicitCastNumber).getName();
            else
                result += "[Carte" + explicitCastNumber + "]";
            result += ") ";
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
