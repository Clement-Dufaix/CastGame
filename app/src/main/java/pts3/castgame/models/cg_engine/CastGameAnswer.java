package pts3.castgame.models.cg_engine;

public class CastGameAnswer extends CastGameResult {
	private String explanation;
	private String outputDisplay;

	public CastGameAnswer(InstructionResult instructionResult, String explanation, String outputDisplay) {
		super(instructionResult);
		this.explanation = explanation;
		this.outputDisplay = outputDisplay;
	}

	public String getExplanation() {
		return explanation;
	}

	public String getOutputDisplay() {
		return outputDisplay;
	}

	@Override
	public String toString() {
		switch (instructionResult) {
		case OK:
			return super.toString() + " : output display = " + outputDisplay;
		default:
			return super.toString();
		}
	}
}
