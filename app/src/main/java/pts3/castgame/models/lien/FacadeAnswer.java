package pts3.castgame.models.lien;

import pts3.castgame.models.FinalAnswer;
import pts3.castgame.models.InstructionResult;

public class FacadeAnswer {

    private FinalAnswer fa;

    public FacadeAnswer(FinalAnswer fa) {
        this.fa = fa;
    }

    public boolean codeIsWorking() {
        return fa.getInstructionResult() == InstructionResult.OK;
    }

    public boolean compilationError() {
        return fa.getInstructionResult() == InstructionResult.COMPILATION_FAIL;
    }

    public boolean executionError() {
        return fa.getInstructionResult() == InstructionResult.EXECUTION_FAIL || fa.getInstructionResult() == InstructionResult.COMPILATION_FAIL;
    }

    public String getExplanation() {
        return fa.getExplanation();
    }

    public String getOutputDisplay() {
        return fa.getOutputDisplay();
    }

    public int getLineNumber() {
        return fa.getLineNumber();
    }

}
