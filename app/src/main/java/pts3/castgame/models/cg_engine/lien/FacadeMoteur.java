package pts3.castgame.models.cg_engine.lien;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pts3.castgame.models.cg_engine.CastGameClass;
import pts3.castgame.models.cg_engine.CastGameInterface;
import pts3.castgame.models.cg_engine.CastGameTemplate;
import pts3.castgame.models.cg_engine.CastGameTypable;
import pts3.castgame.models.cg_engine.LignTemplate;

public class FacadeMoteur {

    public static final List<CastGameTemplate> CARTE_TEMPLATES = templatesDuProf();
    private static final List<CastGameTypable> CARTE_CLASSES_DIFFICILE = carteClasseDifficileDuProf();
    private static final List<CastGameTypable> CARTE_CLASSES_FACILE = carteClasseFacileDuProf();
    private static final List<String> CARTE_METHODE_DIFFICILE = carteMethodeDifficileDuProf();
    private static final List<String> CARTE_METHODE_FACILE = carteMethodeFacileDuProf();

    private CastGameTemplate templateChoisi;

    private List<CastGameTemplate> listTemplate;
    private Map<Integer, CastGameTypable> cartesClassesSelectionnee;
    private String methodeSelectionnee;
    private boolean difficile;

    public FacadeMoteur() {
        difficile = true;
    }

    public void setTemplateChoisi(CastGameTemplate template) {
        this.templateChoisi = template;
    }

    public List<CastGameTemplate> getListTemplate() {
        return /*Temp*/CARTE_TEMPLATES;
    }

    public List<CastGameTypable> getCarteClasse() {
        if (difficile)
            return CARTE_CLASSES_DIFFICILE;
        return CARTE_CLASSES_FACILE;
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

        //1
        List<LignTemplate> lignList = new ArrayList<LignTemplate>(3);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        lignList.add(new LignTemplate(2, 2, null, true, 2));
        lignList.add(new LignTemplate(null, 1, 1, false, 2));
        result.add(new CastGameTemplate(lignList, 1, false));

        //2
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        lignList.add(new LignTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));

        //3
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        lignList.add(new LignTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));

        //4
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        lignList.add(new LignTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));

        //5
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        lignList.add(new LignTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));

        //6
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        result.add(new CastGameTemplate(lignList, 1, false));

        //7
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        lignList.add(new LignTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));

        //8
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        result.add(new CastGameTemplate(lignList, 1, false));

        //9
        lignList = new ArrayList<LignTemplate>(3);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        lignList.add(new LignTemplate(2, 2, null, true, 2));
        lignList.add(new LignTemplate(null, 1, null, false, 1));
        result.add(new CastGameTemplate(lignList, 1, true));

        //10
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        lignList.add(new LignTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));

        //11
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        lignList.add(new LignTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));

        //12
        lignList = new ArrayList<LignTemplate>(3);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        lignList.add(new LignTemplate(2, 2, null, true, 2));
        lignList.add(new LignTemplate(null, 1, 1, false, 2));
        result.add(new CastGameTemplate(lignList, 1, true));

        //13
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        result.add(new CastGameTemplate(lignList, 1, true));

        //14
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        result.add(new CastGameTemplate(lignList, 1, true));

        //15
        lignList = new ArrayList<LignTemplate>(3);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        lignList.add(new LignTemplate(2, 2, null, true, 2));
        lignList.add(new LignTemplate(null, 1, null, false, 2));
        result.add(new CastGameTemplate(lignList, 1, false));

        //16
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        result.add(new CastGameTemplate(lignList, 1, false));

        //17
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        result.add(new CastGameTemplate(lignList, 1, true));

        //18
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        lignList.add(new LignTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));

        return result;
    }

    private static List<CastGameTypable> carteClasseDifficileDuProf() {
        //TODO Faire les liens entres les classes
        //TODO Ajouter des méthodes

        List<CastGameTypable> result = new ArrayList<CastGameTypable>(15);

        //Classe Mendiant
        result.add(new CastGameClass("Mendiant", "Je suis un mendiant"));

        //Interface Defenseur
        result.add(new CastGameInterface("Defenseur"));

        //Interface Attaquant
        result.add(new CastGameInterface("Attaquant"));

        //Interface Combattant
        result.add(new CastGameInterface("Combattant"));

        //Interface Guerisseur
        result.add(new CastGameInterface("Guerisseur"));

        //Interface LanceurSortProfane
        result.add(new CastGameInterface("LanceurSortProfane"));

        //Classe Guerrier
        result.add(new CastGameClass("Guerrier", "Je suis un guerrier"));

        //Interface LanceurSortDivin
        result.add(new CastGameInterface("LanceurSortDivin"));

        //Classe Magicien
        result.add(new CastGameClass("Magicien", "Je suis un magicien"));

        //Classe Sorceleur
        result.add(new CastGameClass("Sorceleur", "Je suis un sorceleur"));

        //Classe Clerc
        result.add(new CastGameClass("Clerc", "Je suis un clerc"));

        //Classe Pretre
        result.add(new CastGameClass("Pretre", "Je suis un pretre"));

        //Classe Sorcier
        result.add(new CastGameClass("Sorcier", "Je suis un sorcier"));

        //Interface LanceurSortMalefique
        result.add(new CastGameInterface("LanceurSortMalefique"));

        //Classe Necromancien
        result.add(new CastGameClass("Necromancien", "Je suis un necromancien"));

        return result;
    }

    private static List<CastGameTypable> carteClasseFacileDuProf() {
        //TODO Faire les liens entres les classes
        //TODO Ajouter des méthodes
        List<CastGameTypable> result = new ArrayList<CastGameTypable>();

        //Classe Guerisseur
        result.add(new CastGameClass("Guerisseur", "Je suis un guerisseur"));

        //Classe Guerrier
        result.add(new CastGameClass("Guerrier", "Je suis un guerrier"));

        //Classe Mendiant
        result.add(new CastGameClass("Mendiant", "Je suis un mendiant"));

        //Classe Sorcier
        result.add(new CastGameClass("Sorcier", "Je suis un sorcier"));

        //Classe Sorceleur
        result.add(new CastGameClass("Sorceleur", "Je suis un sorceleur"));

        //Classe Clerc
        result.add(new CastGameClass("Clerc", "Je suis un clerc"));

        //Classe Necromancien
        result.add(new CastGameClass("Necromancien", "Je suis un necromancien"));

        return result;
    }

    private static List<String> carteMethodeDifficileDuProf() {
        //TODO Reprendre toute les methodes des classes
        List<String> result = new ArrayList<String>();

        result.add("defendre()");
        result.add("attaquer()");
        result.add("guerir()");
        result.add("lancerSort()");
        result.add("reveillerMort()");

        return result;
    }

    private static List<String> carteMethodeFacileDuProf() {
        //TODO Reprendre toute les methodes des classes
        List<String> result = new ArrayList<String>();

        result.add("defendre()");
        result.add("attaquer()");
        result.add("guerir()");
        result.add("lancerSort()");
        result.add("reveillerMort()");

        return result;
    }

    public static List<CastGameTypable> carteClasseDuProf() {
        return null; //NFOIEIOHFSOIDGJFGIO
    }
}

/*
"Défenseur", "Attaquant", "Mendiant", "Combattant", "Guerrisseur", "LanceurDeSortProfane", "Guerrier", "LanceurDeSortDivin",
                "Magicien", "Sorceleur", "Clerc", "Pretre", "Sorcier", "LanceurDeSortMagique", "Necromancien"
 */