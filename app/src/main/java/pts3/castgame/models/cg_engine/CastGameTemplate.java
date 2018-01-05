package pts3.castgame.models.cg_engine;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class CastGameTemplate {
	private List<LignTemplate> lignList;
	private int finalObjectNumber;
	private boolean useMethod;
	
	private Map<Integer, CastGameTypable> cardMap;
	private String methodName;
	
	public CastGameTemplate(List<LignTemplate> lignList, int finalObjectNumber, boolean useMethod) {
		super();
		this.lignList = new ArrayList<LignTemplate>(lignList);
		this.finalObjectNumber = finalObjectNumber;
		this.useMethod = useMethod;
		cardMap = new Hashtable<Integer, CastGameTypable>();
		methodName = null;
	}

	public void addCard(Integer number, CastGameTypable card) {
		cardMap.put(number, card);
	}
	
	public void reset() {
		cardMap.clear();
		methodName = null;
	}
	
	public String toString() {
		String result = "";
		for (LignTemplate lt : lignList)
			result += lt.getString(cardMap) + "\n";
		if (useMethod)
			result +="perso" + finalObjectNumber + "." + methodName == null ? "[CarteM]" : methodName + "();";
		else
			result += "System.out.println(perso" + finalObjectNumber + ");";
		return result;
	}

	public CastGameAnswer getAnswer(Map<Integer, CastGameTypable> cardMap, String methodName) {
		Map<Integer, CastGameObject> objectMap = new Hashtable<Integer, CastGameObject>();
		CastGameResult result;
		for (LignTemplate lt : lignList) {
			if (lt.getDeclarationTypeNumber() != null) {
				// On a vraiment besoin de vérifier que l'objet est pas déclaré ?
                // En principe les templates étant donnés par le prof, on a pas besoin de vérifier, c'est par contrat ^^
                // (si j'ai bien compris ce que tu voulais faire par là)
				if (objectMap.containsKey(lt.getDeclarationTypeNumber()))
					return new CastGameAnswer(InstructionResult.COMPILATION_FAIL, "Type deja declare", "");
				objectMap.put(
					lt.getObjectNumber(),
					new CastGameObject(cardMap.get(lt.getDeclarationTypeNumber()), "perso" + lt.getObjectNumber())
				);
			}
			if (lt.useNew()) {
				result = objectMap.get(lt.getObjectNumber()).affectation(cardMap.get(lt.getExplicitCastNumber()), cardMap.get(lt.getOtherItemNumber()));
			} else {
				result = objectMap.get(lt.getObjectNumber()).affectation(cardMap.get(lt.getExplicitCastNumber()), objectMap.get(lt.getOtherItemNumber()));
			}
			if (result instanceof CastGameAnswer)
				return (CastGameAnswer) result;
		}
		
		if (useMethod)
			return objectMap.get(finalObjectNumber).executeMethod(methodName);
		
		return objectMap.get(finalObjectNumber).sysOutDisplay();
	}
}