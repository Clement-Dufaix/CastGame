package pts3.castgame.models.lien;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import pts3.castgame.models.CastGameClass;
import pts3.castgame.models.CastGameInterface;
import pts3.castgame.models.CastGameTemplate;
import pts3.castgame.models.CastGameTypable;
import pts3.castgame.models.LineTemplate;

public class FacadeMoteur {

    public static final List<CastGameTemplate> CARTE_TEMPLATES = templatesDuProf();
    private static final List<CastGameTypable> CARTE_CLASSES_DIFFICILE = carteClasseDifficileDuProf();
    private static final List<CastGameTypable> CARTE_CLASSES_FACILE = carteClasseFacileDuProf();
    private static final List<String> CARTE_METHODE_DIFFICILE = carteMethodeDifficileDuProf();
    private static final List<String> CARTE_METHODE_FACILE = carteMethodeFacileDuProf();

    private CastGameTemplate templateChoisi;

    // private List<CastGameTemplate> listTemplate;
    private Map<Integer, CastGameTypable> cartesClassesSelectionnee;
    private String methodeSelectionnee;
    private boolean difficile;
    private int etape = 0; //etape de du programme 0 : accueil (sélection difficulté et plateau) 1 : sélection template,

    public FacadeMoteur() {
        templateChoisi = null;
        cartesClassesSelectionnee = new Hashtable<Integer, CastGameTypable>();
        methodeSelectionnee = null;
        difficile = true;
    }

    /**
     * @return false : doit aller au fragment template
     * true : doit rester sur le fragment carte
     */
    public boolean back() {
        if (methodeSelectionnee != null) {
            methodeSelectionnee = null;
            return true;
        }
        if (cartesClassesSelectionnee.isEmpty())
            return false;

        int imax = cartesClassesSelectionnee.keySet().iterator().next();
        for (Integer integer : cartesClassesSelectionnee.keySet())
            if (imax < integer)
                imax = integer;
        cartesClassesSelectionnee.remove(imax);
        return true;
    }

    public FacadeAnswer getAnswer() {
        return new FacadeAnswer(templateChoisi.getAnswer(cartesClassesSelectionnee, methodeSelectionnee));
    }

    public void reset() {
        templateChoisi = null;
        cartesClassesSelectionnee.clear();
        methodeSelectionnee = null;
    }

    public void setTemplateChoisi(CastGameTemplate template) {
        reset();
        this.templateChoisi = template;
    }

    public List<CastGameTemplate> getListTemplate() {
        return CARTE_TEMPLATES;
    }

    public void ajouterCarte(int position, int etatActuel) {
        //Log.e("etat facade :", getEtat()+", etat fragment : "+etatActuel);
        methodeSelectionnee = null;
        List<Integer> i = new ArrayList<>();
        for (Map.Entry<Integer, CastGameTypable> entry : cartesClassesSelectionnee.entrySet()) { //si l'utilisateur est revenu en arriere on supprime les cartes qu'il avait déjà sélectionné
            //Log.e("clé : ",entry.getKey()+"");
            if (entry.getKey() >= etatActuel && etatActuel != 0) {
                i.add(entry.getKey());
            }
        }
        for (int y : i) {    //après avoir enregistrer les id des cartes a supprimer.... ba on les supprimer...
            cartesClassesSelectionnee.remove(y);
        }

        int etat = getEtat();   //l'état de la facade se met a jour
        if (etat == 0)
            methodeSelectionnee = getCarteMethode().get(position);
        else if (etat > 0)
            cartesClassesSelectionnee.put(etat, getCarteClasse().get(position));
    }

    public List<String> getPossibleAnswer() {
        List<String> result = new LinkedList<String>();
        if (templateChoisi.getUseMethod()) {
            for (CastGameTypable t : getCarteClasse())
                if (t instanceof CastGameClass)
                    if (((CastGameClass) t).getMethodList().containsKey(methodeSelectionnee))
                        result.add(((CastGameClass) t).getMethodList().get(methodeSelectionnee));
        } else {
            for (CastGameTypable t : cartesClassesSelectionnee.values())
                if (t instanceof CastGameClass)
                    result.add(((CastGameClass) t).getResultToString());
        }
        return result;
    }
    //inutilisee
    public int getNombreCarteClasse() {
        return templateChoisi.getNumberClassCard().size();
    }

    //inutilisee
    public boolean useMethod() {
        return templateChoisi.getUseMethod();
    }

    /**
     * Carte a traiter
     *
     * @return -1 : fini
     * 0  : carte methode
     * 1 - +infini : numero carte classe
     */
    public int getEtat() {
        Set<Integer> classeManquantes = templateChoisi.getNumberClassCard();
        classeManquantes.removeAll(cartesClassesSelectionnee.keySet());
        if (!classeManquantes.isEmpty())
            return classeManquantes.iterator().next();
        if (templateChoisi.getUseMethod() && methodeSelectionnee == null)
            return 0;
        return -1;
    }

    public List<CastGameTypable> getCarteClasse() {
        if (difficile)
            return CARTE_CLASSES_DIFFICILE;
        return CARTE_CLASSES_FACILE;
    }

    /**
     * Retourne le template sous format texte.
     *
     * @return La chaîne de caractères
     */
    public String getTemplateString() {
        return templateChoisi.getCorrectString(cartesClassesSelectionnee, methodeSelectionnee);
    }

    /*
    public CastGameAnswer getTemplateAnswer() {
        return templateChoisi.getAnswer(cartesClassesSelectionnee, methodeSelectionnee);
    }
    */

    public List<String> getCarteClasseListString() {
        List<String> result = new LinkedList<String>();

        for (CastGameTypable t : getCarteClasse())
            result.add(t.toString());

        return result;
    }

    public List<String> getCarteMethode() {
        if (difficile)
            return CARTE_METHODE_DIFFICILE;
        return CARTE_METHODE_FACILE;
    }

    public CastGameTemplate getTemplateChoisi() {
        return templateChoisi;
    }

    public boolean IsDifficile() {
        return difficile;
    }

    public void setDifficile(boolean difficile) {
        this.difficile = difficile;
    }

    public static List<CastGameTemplate> templatesDuProf() {
        List<CastGameTemplate> result = new ArrayList<CastGameTemplate>(18);
        List<LineTemplate> lignList = new ArrayList<LineTemplate>(3);

        //1
        lignList.add(new LineTemplate(1, 1, null, true, 1));
        lignList.add(new LineTemplate(2, 2, null, true, 2));
        lignList.add(new LineTemplate(null, 1, 1, false, 2));
        result.add(new CastGameTemplate(lignList, 1, false));
        lignList.clear();

        //2
        lignList.add(new LineTemplate(1, 1, null, true, 2));
        lignList.add(new LineTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));
        lignList.clear();

        //3
        lignList.add(new LineTemplate(1, 1, 1, true, 2));
        lignList.add(new LineTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));
        lignList.clear();

        //4
        lignList.add(new LineTemplate(1, 1, 1, true, 2));
        lignList.add(new LineTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));
        lignList.clear();

        //5
        lignList.add(new LineTemplate(1, 1, null, true, 2));
        lignList.add(new LineTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));
        lignList.clear();

        //6
        lignList.add(new LineTemplate(1, 1, null, true, 2));
        result.add(new CastGameTemplate(lignList, 1, false));
        lignList.clear();

        //7
        lignList.add(new LineTemplate(1, 1, 1, true, 2));
        lignList.add(new LineTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));
        lignList.clear();

        //8
        lignList.add(new LineTemplate(1, 1, null, true, 1));
        result.add(new CastGameTemplate(lignList, 1, false));
        lignList.clear();

        //9
        lignList.add(new LineTemplate(1, 1, null, true, 1));
        lignList.add(new LineTemplate(2, 2, null, true, 2));
        lignList.add(new LineTemplate(null, 1, null, false, 2));
        result.add(new CastGameTemplate(lignList, 1, true));
        lignList.clear();

        //10
        lignList.add(new LineTemplate(1, 1, null, true, 2));
        lignList.add(new LineTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));
        lignList.clear();

        //11
        lignList.add(new LineTemplate(1, 1, 1, true, 2));
        lignList.add(new LineTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));
        lignList.clear();

        //12
        lignList.add(new LineTemplate(1, 1, null, true, 1));
        lignList.add(new LineTemplate(2, 2, null, true, 2));
        lignList.add(new LineTemplate(null, 1, 1, false, 2));
        result.add(new CastGameTemplate(lignList, 1, true));
        lignList.clear();

        //13
        lignList.add(new LineTemplate(1, 1, 1, true, 2));
        result.add(new CastGameTemplate(lignList, 1, true));
        lignList.clear();

        //14
        lignList.add(new LineTemplate(1, 1, null, true, 2));
        result.add(new CastGameTemplate(lignList, 1, true));
        lignList.clear();

        //15
        lignList.add(new LineTemplate(1, 1, null, true, 1));
        lignList.add(new LineTemplate(2, 2, null, true, 2));
        lignList.add(new LineTemplate(null, 1, null, false, 2));
        result.add(new CastGameTemplate(lignList, 1, false));
        lignList.clear();

        //16
        lignList.add(new LineTemplate(1, 1, 1, true, 2));
        result.add(new CastGameTemplate(lignList, 1, false));
        lignList.clear();

        //17
        lignList.add(new LineTemplate(1, 1, null, true, 1));
        result.add(new CastGameTemplate(lignList, 1, true));
        lignList.clear();

        //18
        lignList.add(new LineTemplate(1, 1, null, true, 2));
        lignList.add(new LineTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));

        return result;
    }

    private static List<CastGameTypable> carteClasseDifficileDuProf() {
        List<CastGameTypable> result = new ArrayList<CastGameTypable>(15);
        Map<String, String> methodList = new Hashtable<String, String>();
        Set<String> prototypeList = new HashSet<String>();
        Set<CastGameInterface> interfaces = new HashSet<CastGameInterface>();

        //Classe Mendiant
        CastGameClass mendiant = new CastGameClass("Mendiant", "Je suis un mendiant");
        result.add(mendiant);

        //Interface Defenseur
        prototypeList.add("defendre");
        CastGameInterface defenseur = new CastGameInterface("Defenseur", prototypeList);
        result.add(defenseur);

        //Interface Attaquant
        prototypeList.clear();
        prototypeList.add("attaquer");
        CastGameInterface attaquant = new CastGameInterface("Attaquant", prototypeList);
        result.add(attaquant);

        //Interface Combattant
        interfaces.add(defenseur);
        interfaces.add(attaquant);
        CastGameInterface combattant = new CastGameInterface("Combattant", null, interfaces);
        result.add(combattant);

        //Interface Guerisseur
        prototypeList.clear();
        prototypeList.add("guerir");
        CastGameInterface guerisseur = new CastGameInterface("Guerisseur", prototypeList);
        result.add(guerisseur);

        //Interface LanceurSortProfane
        prototypeList.clear();
        prototypeList.add("lancerSort");
        CastGameInterface lanceurSortProfane = new CastGameInterface("LanceurSortProfane", prototypeList);
        result.add(lanceurSortProfane);

        //Classe Guerrier
        interfaces.clear();
        methodList.put("attaquer", "J'attaque");
        methodList.put("defendre", "Je défends");
        interfaces.add(combattant);
        CastGameClass guerrier = new CastGameClass("Guerrier", "Je suis un guerrier", methodList, interfaces);
        result.add(guerrier);

        //Interface LanceurSortDivin
        CastGameInterface lanceurSortDivin = new CastGameInterface("LanceurSortDivin", prototypeList);
        result.add(lanceurSortDivin);

        //Classe Magicien
        methodList.clear();
        interfaces.clear();
        methodList.put("lancerSort", "Je lance un sort");
        methodList.put("guerir", "Je guéris");
        interfaces.add(guerisseur);
        interfaces.add(lanceurSortProfane);
        CastGameClass magicien = new CastGameClass("Magicien", "Je suis un magicien", methodList, interfaces);
        result.add(magicien);

        //Classe Sorceleur
        methodList.clear();
        methodList.put("defendre", "Défense magique");
        methodList.put("lancerSort", "Je lance un sort d'attaque");
        methodList.put("guerir", "Guérison");
        CastGameClass sorceleur = new CastGameClass("Sorceleur", "Je suis un sorceleur", methodList, guerrier, interfaces);
        result.add(sorceleur);

        //Classe Clerc
        methodList.clear();
        interfaces.clear();
        methodList.put("attaquer", "Au nom de dieu, J'attaque");
        methodList.put("lancerSort", "Au nom de dieu, je lance un sort");
        interfaces.add(lanceurSortDivin);
        CastGameClass clerc = new CastGameClass("Clerc", "Je suis un clerc", methodList, guerrier, interfaces);
        result.add(clerc);

        //Classe Pretre
        methodList.clear();
        methodList.put("lancerSort", "Je prie pour lancer un sort");
        CastGameClass pretre = new CastGameClass("Pretre", "Je suis un pretre", methodList, interfaces);
        result.add(pretre);

        //Classe Sorcier
        methodList.clear();
        methodList.put("lancerSort", "Je lance un sort puissant");
        CastGameClass sorcier = new CastGameClass("Sorcier", "Je suis un sorcier", methodList, magicien);
        result.add(sorcier);

        //Interface LanceurSortMalefique
        prototypeList.clear();
        prototypeList.add("reveillerMort");
        CastGameInterface lanceurSortMalefique = new CastGameInterface("LanceurSortMalefique", prototypeList, interfaces);
        result.add(lanceurSortMalefique);

        //Classe Necromancien
        methodList.clear();
        interfaces.clear();
        methodList.put("lancerSort", "Je lance un sort mortel");
        methodList.put("reveillerMort", "Je réveille les morts");
        interfaces.add(lanceurSortMalefique);
        CastGameClass necromancien = new CastGameClass("Necromancien", "Je suis un necromancien", methodList, sorcier, interfaces);
        result.add(necromancien);

        return result;
    }

    private static List<CastGameTypable> carteClasseFacileDuProf() {
        List<CastGameTypable> result = new ArrayList<CastGameTypable>(15);
        Map<String, String> methodList = new Hashtable<String, String>();

        //Classe Mendiant
        CastGameClass mendiant = new CastGameClass("Mendiant", "Je suis un mendiant");
        result.add(mendiant);

        //Classe Guerisseur
        methodList.put("guerir", "Je guéris");
        CastGameClass guerisseur = new CastGameClass("Guerisseur", "Je suis un guérisseur", methodList);
        result.add(guerisseur);

        //Classe Guerrier
        methodList.clear();
        methodList.put("attaquer", "J'attaque");
        methodList.put("defendre", "Je défends");
        CastGameClass guerrier = new CastGameClass("Guerrier", "Je suis un guerrier", methodList);
        result.add(guerrier);

        //Classe Sorceleur
        methodList.clear();
        methodList.put("attaquer", "Attaque de sorceleur");
        CastGameClass sorceleur = new CastGameClass("Sorceleur", "Je suis un sorceleur", methodList, guerrier);
        result.add(sorceleur);

        //Classe Clerc
        methodList.clear();
        methodList.put("defendre", "Au nom de dieu, je défends");
        CastGameClass clerc = new CastGameClass("Clerc", "Je suis un clerc", methodList, guerrier);
        result.add(clerc);

        //Classe Sorcier
        methodList.clear();
        methodList.put("attaquer", "J'attaque grâce à mon baton magique");
        methodList.put("defendre", "Je défends grâce à mon baton magique");
        CastGameClass sorcier = new CastGameClass("Sorcier", "Je suis un sorcier", methodList, guerisseur);
        result.add(sorcier);

        //Classe Necromancien
        methodList.clear();
        methodList.put("reveillerMort", "Debout, c'est l'heure de se réveiller.");
        CastGameClass necromancien = new CastGameClass("Necromancien", "Je suis un necromancien", methodList, sorcier);
        result.add(necromancien);

        return result;
    }

    private static List<String> carteMethodeDifficileDuProf() {
        List<String> result = new ArrayList<String>();
        Set<String> set = new TreeSet<String>();

        for (CastGameTypable t : CARTE_CLASSES_DIFFICILE)
            set.addAll(t.getPrototypeList());

        result.addAll(set);

        return result;
    }

    private static List<String> carteMethodeFacileDuProf() {
        List<String> result = new ArrayList<String>();
        Set<String> set = new TreeSet<String>();

        for (CastGameTypable t : CARTE_CLASSES_FACILE)
            set.addAll(t.getPrototypeList());

        result.addAll(set);

        return result;
    }
}