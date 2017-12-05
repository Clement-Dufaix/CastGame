package pts3.castgame.models.template;

/**
 * Opération d'affectation.
 */
public class OperationAssignment implements Operation {

    /**
     * Crée une opération d'affectation.
     */
    public OperationAssignment() {
        super();
    }

    @Override
    public String toString() {
        return " = ";
    }

}
