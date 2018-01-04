package pts3.castgame.models.template;

import pts3.castgame.models.castgame.CastGameCard;
import pts3.castgame.models.castgame.CastGameObject;

/**
 * Opération d'affichage toString de l'objet.
 */
public class LineToString implements Line {

    private CastGameObject target;
    private CastGameCard realType;

    /**
     * Ligne d'affichage du toString() pour l'objet <b>target</b> de type réel
     * <b>realType</b>
     *
     * @param target   : L'objet cible sur lequel on appelle le toString()
     * @param realType : Le type réel de l'objet
     */
    public LineToString(CastGameObject target, CastGameCard realType) {
        super();
        this.target = target;
        this.realType = realType;
    }

    public CastGameObject getTarget() {
        return target;
    }

    @Override
    public String display() {
        return "System.out.println(" + target.getName() + ");";
    }

    @Override
    public void compile() {
        // On ne relève pas d'erreur de compilation ici.
        System.out.print("COMPILE");
    }

    @Override
    public void execute() {
        System.out.println("Je suis un " + realType.getClassName() + " !");
    }

}

