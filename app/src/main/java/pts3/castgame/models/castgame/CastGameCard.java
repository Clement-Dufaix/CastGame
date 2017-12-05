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

    public void addParent(CastGameCard parent) {
        parents.add(parent);
    }

}
