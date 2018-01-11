package pts3.castgame.models.lien;

import pts3.castgame.models.FinalAnswer;
import pts3.castgame.models.InstructionResult;

public class FacadeAnswer {

    private FinalAnswer fa;

    public FacadeAnswer(FinalAnswer fa) {
        this.fa = fa;
    }

    public InstructionResult getInstructionResult() {
        return fa.getInstructionResult();
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
