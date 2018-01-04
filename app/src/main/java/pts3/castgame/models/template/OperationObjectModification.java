package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameObject;

/**
 * Opération de modification d'un objet existant
 */
public class OperationObjectModification implements Operation {

    private CastGameObject target;
    private CastGameObject other;

    /**
     * Opération qui veut modifier le type de l'objet <b>target</b> avec celui de
     * l'objet <b>other</b>
     *
     * @param target : L'objet cible que l'on veut typer
     * @param other  : L'objet avec lequel on veut typer notre cible
     */
    public OperationObjectModification(CastGameObject target, CastGameObject other) {
        super();
        this.target = target;
        this.other = other;
    }

    @Override
    public void compile() {
        if (!other.hasParent(target.getType()) && target.getType() != other.getType()) {
            System.out.print("ERREUR COMPILATION : ");
            System.out.print("Impossible de convertir " + other.getClassName() + " vers " + target.getClassName());
        }
    }

    @Override
    public void execute() {
        // On ne relève pas d'erreur d'exécution ici.
    }

    @Override
    public String toString() {
        return other.getName();
    }

}
