package pts3.castgame.models;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CastGameTemplate {
    private List<LignTemplate> lignList;
    private int finalObjectNumber;
    private boolean useMethod;

    public CastGameTemplate(List<LignTemplate> lignList, int finalObjectNumber, boolean useMethod) {
        super();
        this.lignList = new ArrayList<>(lignList);
        this.finalObjectNumber = finalObjectNumber;
        this.useMethod = useMethod;
    }

    public String toString() {
        return getCorrectString(null);
    }

    public String getCorrectString(Map<Integer, CastGameTypable> cardMap) {
        return getCorrectString(cardMap, null);
    }

    public String getCorrectString(Map<Integer, CastGameTypable> cardMap, String methodName) {
        StringBuilder result = new StringBuilder();
        for (LignTemplate lt : lignList)
            result.append(lt.getString(cardMap)).append("\n");
        if (useMethod) {
            if (methodName == null)
                methodName = "[CarteM]";
            result.append("perso").append(finalObjectNumber).append(".").append(methodName).append("();");
        } else
            result.append("System.out.println(perso").append(finalObjectNumber).append(");");
        return result.toString();
    }

    public boolean getUseMethod() {
        return useMethod;
    }

    public FinalAnswer getAnswer(Map<Integer, CastGameTypable> cardMap, String methodName) {
        Map<Integer, CastGameObject> objectMap = new Hashtable<Integer, CastGameObject>();
        CastGameResult result;
        int i = 1;
        for (LignTemplate lt : lignList) {
            if (lt.getDeclarationTypeNumber() != null) {
                if (objectMap.containsKey(lt.getDeclarationTypeNumber()))
                    return new FinalAnswer(InstructionResult.COMPILATION_FAIL, "Type déjà déclaré", "", i);
                objectMap.put(
                        lt.getObjectNumber(),
                        new CastGameObject(cardMap.get(lt.getDeclarationTypeNumber()), "perso" + lt.getObjectNumber())
                );
            }
            CastGameTypable cast;
            if (cardMap.get(lt.getExplicitCastNumber()) == null)
                cast = null;
            else
                cast = cardMap.get(lt.getExplicitCastNumber());
            if (lt.useNew()) {
                result = objectMap.get(lt.getObjectNumber()).affectation(cast, cardMap.get(lt.getOtherItemNumber()));
            } else {
                result = objectMap.get(lt.getObjectNumber()).affectation(cast, objectMap.get(lt.getOtherItemNumber()));
            }
            if (result instanceof CastGameAnswer)
                return new FinalAnswer((CastGameAnswer) result, i);
            i++;
        }

        if (useMethod)
            return new FinalAnswer(objectMap.get(finalObjectNumber).executeMethod(methodName), i);

        return new FinalAnswer(objectMap.get(finalObjectNumber).sysOutDisplay(), i);
    }

    public Set<Integer> getNumberClassCard() {
        Set<Integer> result = new TreeSet<Integer>();

        for (LignTemplate lt : lignList) {
            if (lt.getDeclarationTypeNumber() != null)
                result.add(lt.getDeclarationTypeNumber());
            if (lt.getExplicitCastNumber() != null)
                result.add(lt.getExplicitCastNumber());
            if (lt.useNew())
                result.add(lt.getOtherItemNumber());
        }

        return result;
    }
}