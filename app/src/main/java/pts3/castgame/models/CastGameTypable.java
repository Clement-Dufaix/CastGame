package pts3.castgame.models;

import java.util.HashSet;
import java.util.Set;

public abstract class CastGameTypable {

    public static final Set<CastGameInterface> NO_INTERFACE = new HashSet<CastGameInterface>();

    private String name;

    public CastGameTypable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Set<String> getPrototypeList();

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof CastGameTypable))
            return false;
        CastGameTypable other = (CastGameTypable) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}
