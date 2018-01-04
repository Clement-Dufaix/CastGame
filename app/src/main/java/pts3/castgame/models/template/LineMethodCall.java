package pts3.castgame.models.template;


import pts3.castgame.models.castgame.CastGameMethod;
import pts3.castgame.models.castgame.CastGameObject;

/**
 * Opération d'appel à une méthode.
 */
public class LineMethodCall implements Line {

    private CastGameObject target;
    private CastGameMethod method;

    /**
     * Crée une opération qui appelle la <b>{@code CastGameMethod}</b> method sur le
     * <b>{@code CastGameObject}</b> perso, tous deux passés en paramètres.
     *
     * @param target : L'objet cible qui appelle la méthode.
     * @param method : La méthode que l'on souhaite utiliser.
     */
    public LineMethodCall(CastGameObject target, CastGameMethod method) {
        super();
        this.target = target;
        this.method = method;
    }

    public CastGameMethod getMethod() {
        return method;
    }

    @Override
    public String display() {
        return target.getName() + "." + method.getName() + "();";
    }

    @Override
    public void compile() {
        if (!target.hasMethod(method)) {
            System.out.print("ERREUR COMPILATION : ");
            System.out.print("La méthode " + method.getName() + " est inconnue pour le type " + target.getClassName());
        }
    }

    @Override
    public void execute() {
        System.out.println("Le " + target.getName() + " utilise " + method.getName() + " !");
    }

}

