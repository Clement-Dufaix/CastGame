package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameMethod;
import pts3.castgame.models.castgame.CastGameObject;

/**
 * Opération d'appel à une méthode.
 */
public class OperationCall {

    private CastGameObject perso;
    private CastGameMethod method;

    /**
     * Crée une opération qui appelle la <b>{@code CastGameMethod}</b> method sur le
     * <b>{@code CastGameObject}</b> perso, tous deux passés en paramètres.
     *
     * @param perso  : Le personnage sur lequel on appelle la méthode.
     * @param method : La méthode que l'on souhaite utiliser.
     */
    public OperationCall(CastGameObject perso, CastGameMethod method) {
        super();
        this.perso = perso;
        this.method = method;
    }

    public CastGameMethod getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return perso.getName() + "." + method.getName();
    }

}