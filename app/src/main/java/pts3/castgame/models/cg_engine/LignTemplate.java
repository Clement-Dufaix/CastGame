package pts3.castgame.models.cg_engine;

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

	@Override
	public String toString() {
		String result = "";
		if (declarationTypeNumber != null)
			result += "[Carte" + declarationTypeNumber + "] ";
		result += "perso" + objectNumber + " = ";
		if (explicitCastNumber != null)
			result += "([Carte" + explicitCastNumber + "]) ";
		if (useNew)
			result += "new [Carte";
		else
			result += "perso";
		result += otherItemNumber;
		if (useNew)
			result += "]()";
		result += ";";
		return result;
	}
}
