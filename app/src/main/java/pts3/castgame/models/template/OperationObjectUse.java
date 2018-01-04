package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameObject;

/**
 * Opération d'utilisation d'un objet existant
 */
public class OperationObjectUse implements Operation {

    private CastGameObject target;

    /**
     * Utilisation de l'objet <b>target</b>
     *
     * @param target : L'objet utilisé
     */
    public OperationObjectUse(CastGameObject target) {
        super();
        this.target = target;
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
        return target.getName();
    }

}
