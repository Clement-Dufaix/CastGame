package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameCard;
import pts3.castgame.models.castgame.CastGameObject;

/**
 * Opération de déclaration du type de l'objet.
 */
public class OperationDeclaration implements Operation {

    private CastGameObject target;

    /**
     * Déclare l'objet <b>target</b> en lui donnant pour type déclaré <b>type</b>
     *
     * @param type   : Le type déclaré de l'objet
     * @param target : L'objet que l'on déclare
     */
    public OperationDeclaration(CastGameCard type, CastGameObject target) {
        super();
        this.target = target;
        target.setType(type);
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
        return target.getClassName() + " " + target.getName();
    }

}