package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameObject;

/**
 * Opération .
 */
public class OperationObject implements Operation {

    private CastGameObject perso;

    /**
     * Crée une opération de modification pour le {@code CastGameObject} personnage
     * passé en paramètre.
     *
     * @param perso
     */
    public OperationObject(CastGameObject perso) {
        super();
        this.perso = perso;
    }

    public CastGameObject getPersonnage() {
        return perso;
    }

    @Override
    public String toString() {
        return perso.getName();
    }
}
