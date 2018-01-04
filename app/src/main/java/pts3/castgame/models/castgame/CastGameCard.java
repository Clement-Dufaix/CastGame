package pts3.castgame.models.castgame;

import java.util.ArrayList;

/**
 * Les cartes du CastGame
 */
public class CastGameCard {

    private String className;
    private boolean isInterface;
    private ArrayList<CastGameCard> parents;
    private ArrayList<CastGameMethod> methods;

    /**
     * Génère une carte du CastGame
     *
     * @param className   : Le nom de la carte
     * @param isInterface : Cette carte est une interface ?
     */
    public CastGameCard(String className, boolean isInterface) {
        super();
        this.className = className;
        this.isInterface = isInterface;
        parents = new ArrayList<>();
        methods = new ArrayList<>();
    }

    public String getClassName() {
        return className;
    }

    public boolean isInterface() {
        return isInterface;
    }

    private boolean noParents() {
        return parents.isEmpty();
    }

    /**
     * Attention, aucune gestion des doublons dans l'ajout des méthodes du parent
     *
     * @param parent : Le parent à ajouter
     */
    public void addParent(CastGameCard parent) {
        parents.add(parent);
        methods.addAll(parent.getMethods());
    }

    public ArrayList<CastGameCard> getParents() {
        return parents;
    }

    /**
     * Cherche si cette carte possède le <b>searchedParent</b>
     *
     * @param searchedParent : Le parent que l'on cherche
     * @return Le résultat booléen
     */
    public boolean hasParent(CastGameCard searchedParent) {
        for (CastGameCard card : parents) {
            if (card == searchedParent) {
                return true;
            } else if (!card.noParents()) {
                return card.hasParent(searchedParent);
            }
        }
        return false;
    }

    public void addMethod(CastGameMethod method) {
        methods.add(method);
    }

    private ArrayList<CastGameMethod> getMethods() {
        return methods;
    }

    /**
     * Cherche si cette carte possède la <b>searchedMethod</b>
     *
     * @param searchedMethod : La méthode que l'on cherche
     * @return Le résultat booléen
     */
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
