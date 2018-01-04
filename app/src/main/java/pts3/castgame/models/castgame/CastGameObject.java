package pts3.castgame.models.castgame;

/**
 * Les objets du CastGame
 */
public class CastGameObject {

    private String name;
    private CastGameCard type;

    /**
     * Définit l'objet <b>this</b> et lui donne son nom <b>name</b>
     *
     * @param name : Le nom de l'objet
     */
    public CastGameObject(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CastGameCard getType() {
        return type;
    }

    public void setType(CastGameCard type) {
        this.type = type;
    }


    /**
     * Retourne le nom du <b>type</b> par lequel on voit l'objet
     *
     * @return La chaîne de caractères correspondante
     */
    public String getClassName() {
        return type.getClassName();
    }

    /**
     * L'objet étant vu en tant que <b>type</b>, possède-t-il le
     * <b>searchedParent</b>
     *
     * @param searchedParent : Le parent que l'on cherche
     * @return Appel à la méthode hasParent() du <b>type</b>
     * qui se charge de la recherche
     */
    public boolean hasParent(CastGameCard searchedParent) {
        return type.hasParent(searchedParent);
    }

    /**
     * L'objet étant vu en tant que <b>type</b>, peut-il utiliser <b>method</b> ?
     *
     * @param searchedMethod : La méthode que l'on cherche
     * @return Appel à la méthode hasMethod() du <b>type</b> qui se charge de la
     * recherche
     */
    public boolean hasMethod(CastGameMethod searchedMethod) {
        return type.hasMethod(searchedMethod);
    }

}

