package pts3.castgame.models;

public class CastGameResult {

    private InstructionResult instructionResult;

    public CastGameResult(InstructionResult instructionResult) {
        this.instructionResult = instructionResult;
    }

    public InstructionResult getInstructionResult() {
        return instructionResult;
    }

    @Override
    public String toString() {
        switch (instructionResult) {
            case COMPILATION_FAIL:
                return "Compilation error";
            case EXECUTION_FAIL:
                return "Execution error";
            default:
                return "Ok";
        }
    }
}
