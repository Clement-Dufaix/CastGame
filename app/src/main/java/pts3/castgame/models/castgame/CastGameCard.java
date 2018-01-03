package pts3.castgame.models.castgame;

import java.util.ArrayList;

/**
 * CastGameTypable (Interface / Classe).
 */
public class CastGameCard {

    private String className;
    private boolean isInterface;
    private ArrayList<CastGameCard> parents;
    private ArrayList<CastGameMethod> methods;

    public CastGameCard(String className, boolean isInterface) {
        super();
        this.className = className;
        this.isInterface = isInterface;
        parents = new ArrayList<CastGameCard>();
        methods = new ArrayList<CastGameMethod>();
    }

    public String getClassName() {
        return className;
    }

    public boolean isInterface() {
        return isInterface;
    }

	/**/
    // Parents.
    /**/

    public boolean noParents() {
        return parents.isEmpty();
    }

    public void addParent(CastGameCard parent) {
        parents.add(parent);
        // Aucune gestion des doublons pour le moment ;)
        methods.addAll(parent.getMethods());
    }

    public ArrayList<CastGameCard> getParents() {
        return parents;
    }

    public boolean hasParent(CastGameCard parent) {
        for (CastGameCard card : parents) {
            if (card == parent) {
                return true;
            } else if (!card.noParents()) {
                return hasParent(card);
            }
        }
        return false;
    }

	/**/
    // Méthodes.
    /**/

    public void addMethod(CastGameMethod method) {
        methods.add(method);
    }

    public ArrayList<CastGameMethod> getMethods() {
        return methods;
    }

    public boolean hasMethod(CastGameMethod searchedMethod) {

        if (methods.isEmpty()) {
            return false;
        }

        for (CastGameMethod method : methods) {
            if (method == searchedMethod) {
                return true;
            }
        }
        return false;
    }

}
