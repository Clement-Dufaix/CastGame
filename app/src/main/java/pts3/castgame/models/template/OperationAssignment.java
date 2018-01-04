package pts3.castgame.models.template;

/**
 * Opération d'affectation.
 */
public class OperationAssignment implements Operation {

    /**
     * Permet juste d'afficher le ' = ' pour plus de simplicité, et parce qu'il
     * s'agit d'une réelle opération.
     */
    public OperationAssignment() {
        super();
    }

    @Override
    public void compile() {
        // On ne relève pas d'erreur de compilation ici.
    }

    @Override
    public void execute() {
        // On ne relève pas d'erreur d'exécution ici.
    }

    @Override
    public String toString() {
        return " = ";
    }

}