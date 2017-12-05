package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameCard;

/**
 * Opération de cast.
 */
public class OperationCast implements Operation {

    private CastGameCard type;

    /**
     * Crée une opération de cast vers le type <b>{@code CastGameCard}</b> passée en
     * paramètre.
     *
     * @param type : La carte en laquelle on va caster.
     */
    public OperationCast(CastGameCard type) {
        super();
        this.type = type;
    }

    @Override
    public String toString() {
        return "(" + type.getClassName() + ") ";
    }

}
