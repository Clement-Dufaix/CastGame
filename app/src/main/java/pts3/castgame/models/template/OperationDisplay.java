package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameObject;

/**
 * Opération d'affichage toString de l'objet.
 */
public class OperationDisplay implements Operation {

    private CastGameObject perso;

    /**
     * Crée une opération d'appel au toString du <b>{@code CastGameObject}</b> personnage
     * passé en paramètre.
     *
     * @param perso : Le personnage sur lequel on veut utiliser le toString().
     */
    public OperationDisplay(CastGameObject perso) {
        super();
        this.perso = perso;
    }

    public CastGameObject getPerso() {
        return perso;
    }

    @Override
    public String toString() {
        return "System.out.println(" + perso.getName() + ")";
    }

}
