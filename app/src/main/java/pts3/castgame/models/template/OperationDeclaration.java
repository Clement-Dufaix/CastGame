package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameCard;
import pts3.castgame.models.castgame.CastGameObject;

/**
 * Opération de déclaration du type de l'objet.
 */
public class OperationDeclaration implements Operation {

    private CastGameCard type;
    private CastGameObject perso;

    /**
     * Crée une opération de déclaration d'un type <b>{@code CastGameCard}</b> pour
     * le <b>{@code CastGameObject}</b> personnage, tous deux passés en paramètres.
     *
     * @param type  : Le type de la classe.
     * @param perso : L'objet que l'on définit.
     */
    public OperationDeclaration(CastGameCard type, CastGameObject perso) {
        super();
        this.type = type;
        this.perso = perso;
    }

    public CastGameCard getType() {
        return type;
    }

    public CastGameObject getPerso() {
        return perso;
    }

    @Override
    public String toString() {
        return "[" + type.getClassName() + "] " + perso.getName();
    }

}
