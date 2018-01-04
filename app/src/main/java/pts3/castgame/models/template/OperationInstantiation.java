package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameCard;
import pts3.castgame.models.castgame.CastGameObject;

/**
 * L'opération d'instanciation
 */
public final class OperationInstantiation implements Operation {

    private CastGameObject target;
    private CastGameCard realType;

    /**
     * Instancie l'objet <b>target</b> avec pour type réel <b>realType</b>
     *
     * @param target   : L'objet cible à créer
     * @param realType : Le type réel à lui donner
     */
    public OperationInstantiation(CastGameObject target, CastGameCard realType) {
        super();
        this.target = target;
        this.realType = realType;
    }

    @Override
    public void compile() {
        if (realType.isInterface()) {
            System.out.print("ERREUR COMPILATION : ");
            System.out.print(realType.getClassName() + " ne peut être instancié : c'est une interface");
        } else if (!realType.hasParent(target.getType())) {
            System.out.print("ERREUR COMPILATION : ");
            System.out.print("Impossible de convertir " + realType.getClassName() + " vers " + target.getClassName());
        } else {
            System.out.print("COMPILE");
        }
    }

    @Override
    public void execute() {
        // On ne relève pas d'erreur d'exécution ici.
        System.out.print("EXECUTE ");
    }

    @Override
    public String toString() {
        return "new " + realType.getClassName() + "()";
    }

}

