package pts3.castgame.models;

import java.util.HashSet;
import java.util.Set;

public class CastGameInterface extends CastGameTypable {
    public static final Set<String> NO_PROTOTYPE = new HashSet<String>();

    private Set<String> prototypeListWithinInterface;
    private Set<CastGameInterface> extendsInterfaces;

    public CastGameInterface(String name) {
        this(name, NO_PROTOTYPE, NO_INTERFACE);
    }

    public CastGameInterface(String name, Set<String> prototypeListWithinInterface) {
        this(name, prototypeListWithinInterface, NO_INTERFACE);
    }

    public CastGameInterface(String name, Set<String> prototypeListWithinInterface, Set<CastGameInterface> extendsInterfaces) {
        super(name);
        if (prototypeListWithinInterface == null)
            prototypeListWithinInterface = NO_PROTOTYPE;
        if (extendsInterfaces == null)
            extendsInterfaces = NO_INTERFACE;
        this.prototypeListWithinInterface = new HashSet<>(prototypeListWithinInterface);
        this.extendsInterfaces = new HashSet<>(extendsInterfaces);
    }

    public Set<CastGameInterface> getExtendsInterfaces() {
        Set<CastGameInterface> result = new HashSet<>(extendsInterfaces);

        for (CastGameInterface i : extendsInterfaces) // Pas de cycle, pas de probleme
            result.addAll(i.getExtendsInterfaces());

        return result;
    }

    @Override
    public Set<String> getPrototypeList() {
        Set<String> result = new HashSet<String>(prototypeListWithinInterface);

        for (CastGameInterface i : extendsInterfaces) // Pas de cycle, pas de probleme
            result.addAll(i.getPrototypeList());

        return result;
    }

}
