package pts3.castgame.models;
/*
    idees :
	explication etape par etape pour chaque morceau de ligne
	donne la ligne de code qui correspond � l'instruction
*/

public class CastGameResult {

    protected InstructionResult instructionResult;

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
