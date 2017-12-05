package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameCard;

/**
 * Opération d'instanciation de la classe : 'new Class()'
 */
public class OperationInstantiation implements Operation {

    private CastGameCard type;

    /**
     * Crée une opération d'instanciation vers le type <b>{@code CastGameCard}</b>.
     *
     * @param type : Le type de l'instance.
     */
    public OperationInstantiation(CastGameCard type) {
        super();
        this.type = type;
    }

    public CastGameCard getCard() {
        return type;
    }

    @Override
    public String toString() {
        return "new [" + type.getClassName() + "]()";
    }

}
