package pts3.castgame.models;

public class FinalAnswer extends CastGameAnswer {

    private int lineNumber;

    public FinalAnswer(InstructionResult instructionResult, String explanation, String outputDisplay, int lineNumber) {
        super(instructionResult, explanation, outputDisplay);
        this.lineNumber = lineNumber;
    }

    public FinalAnswer(CastGameAnswer cga, int lineNumber) {
        this(cga.getInstructionResult(), cga.getExplanation(), cga.getOutputDisplay(), lineNumber);
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
