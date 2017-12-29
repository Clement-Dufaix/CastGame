package pts3.castgame.models.castgame;

import java.util.ArrayList;

/**
 * CastGameTypable (Interface / Classe).
 */
public class CastGameCard {

    private String name;
    private boolean isInterface;
    private ArrayList<CastGameCard> parents;

    public CastGameCard(String name, boolean isInterface) {
        super();
        this.name = name;
        this.isInterface = isInterface;
    }

    public String getClassName() {
        return name;
    }

    public boolean isInterface() {
        return isInterface;
    }

    public boolean emptyParents() {
        return parents.isEmpty();
    }

    public void addParent(CastGameCard parent) {
        parents.add(parent);
    }

    /**
     * Retourne vrai si la carte passée en paramètre est parente de la classe courante.
     *
     * @param implementedInterface
     * @return
     */
    public boolean isChild(CastGameCard implementedInterface) {

        for (CastGameCard card : parents) {
            if (card == implementedInterface) {
                return true;
            } else if (!card.emptyParents()) {
                return isChild(card);
            }
        }
        return false;
    }

}
