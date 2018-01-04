package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameCard;
import pts3.castgame.models.castgame.CastGameObject;

/**
 * Opération de cast.
 */
public class OperationCast implements Operation {

    private CastGameObject target;
    private CastGameCard castType;

    /**
     * Convertit l'objet <b>target</b> en <b>castType</b>
     *
     * @param target   : L'objet cible pour le cast
     * @param castType : Le type vers lequel caster
     */
    public OperationCast(CastGameObject target, CastGameCard castType) {
        super();
        this.target = target;
        this.castType = castType;
    }

    @Override
    public void compile() {
        // Si les deux cartes sont différentes, et qu'il est impossible d'upcaster
        // (surclasser) et de downcaster (transtyper).
        if (target.getType() != castType && (!target.hasParent(castType) && !castType.hasParent(target.getType()))) {
            System.out.print("ERREUR COMPILATION : ");
            System.out.print("Impossible de convertir " + castType.getClassName() + " vers " + target.getClassName());
        }
    }

    @Override
    public void execute() {
        if (!target.hasParent(castType) && castType.hasParent(target.getType())) {
            System.out.print("ERREUR EXECUTION : ");
            System.out.print("Impossible de convertir " + castType.getClassName() + " vers " + target.getClassName());
        }
    }

    @Override
    public String toString() {
        return "(" + castType.getClassName() + ") ";
    }

}
