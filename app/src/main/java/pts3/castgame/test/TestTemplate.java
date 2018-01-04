package pts3.castgame.test;

import pts3.castgame.models.castgame.CastGameCard;
import pts3.castgame.models.castgame.CastGameMethod;
import pts3.castgame.models.castgame.CastGameObject;
import pts3.castgame.models.template.LineMethodCall;
import pts3.castgame.models.template.LineOther;
import pts3.castgame.models.template.OperationAssignment;
import pts3.castgame.models.template.OperationDeclaration;
import pts3.castgame.models.template.OperationInstantiation;
import pts3.castgame.models.template.OperationObjectUse;
import pts3.castgame.models.template.Template;


public class TestTemplate {

    public static void main(String[] args) {

        // Cette classe possède toute la hiérarchie du jeu difficile.
        // Vous avez juste à tester des cas tordus, vérifier que vous obtenez le même
        // type d'erreur que ceux obtenus en dur.

        // Au niveau des méthodes, on sait juste s'il la possède ou non alors elles sont
        // dans les plus anciens parents u niquement.
        // Si le prof veut qu'on sache quelle méthode exacte est appelée, on aura juste
        // à reprendre celle du type réel.

        //
        // Méthodes
        //

        CastGameMethod attaquer = new CastGameMethod("attaquer");
        CastGameMethod defendre = new CastGameMethod("defendre");
        CastGameMethod lancerSort = new CastGameMethod("lancerSort");
        CastGameMethod reveillerMort = new CastGameMethod("reveillerMort");
        CastGameMethod guerir = new CastGameMethod("guerir");
        //
        // Interfaces :
        //

        // Attaquant
        CastGameCard attaquant = new CastGameCard("Attaquant", true);
        attaquant.addMethod(attaquer);

        // Defenseur
        CastGameCard defenseur = new CastGameCard("Defenseur", true);
        defenseur.addMethod(defendre);

        // Combattant
        CastGameCard combattant = new CastGameCard("Combattant", true);
        combattant.addParent(attaquant);
        combattant.addParent(defenseur);

        // LanceurSortDivin
        CastGameCard lanceurSortDivin = new CastGameCard("LanceurSortDivin", true);
        lanceurSortDivin.addMethod(lancerSort);

        // LanceurSortProfane
        CastGameCard lanceurSortProfane = new CastGameCard("LanceurSortProfane", true);
        lanceurSortProfane.addMethod(lancerSort);

        // LanceurSortMalefique
        CastGameCard lanceurSortMalefique = new CastGameCard("LanceurSortMalefique", true);
        lanceurSortMalefique.addMethod(reveillerMort);

        // Guerisseur
        CastGameCard guerisseur = new CastGameCard("Guerisseur", true);
        guerisseur.addMethod(guerir);

        //
        // Classes :
        //

        // Mendiant
        CastGameCard mendiant = new CastGameCard("Mendiant", false);

        // Guerrier
        CastGameCard guerrier = new CastGameCard("Guerrier", false);
        guerrier.addParent(combattant);

        // Pretre
        CastGameCard pretre = new CastGameCard("Pretre", false);
        pretre.addParent(lanceurSortDivin);

        // Clerc
        CastGameCard clerc = new CastGameCard("Clerc", false);
        clerc.addParent(guerrier);
        clerc.addParent(lanceurSortDivin);

        // Sorceleur
        CastGameCard sorceleur = new CastGameCard("Sorceleur", false);
        sorceleur.addParent(guerrier);
        sorceleur.addParent(lanceurSortProfane);
        sorceleur.addParent(guerisseur);

        // Magicien
        CastGameCard magicien = new CastGameCard("Magicien", false);
        magicien.addParent(lanceurSortProfane);
        magicien.addParent(guerisseur);

        // Sorcier
        CastGameCard sorcier = new CastGameCard("Sorcier", false);
        sorcier.addParent(magicien);

        // Nécromancien
        CastGameCard necromancien = new CastGameCard("Nécromancien", false);
        necromancien.addParent(sorcier);
        necromancien.addParent(lanceurSortMalefique);

        //
        // Objets
        //

        CastGameObject perso1 = new CastGameObject("perso1");
        CastGameObject perso2 = new CastGameObject("perso2");

        //
        // Template
        //

        Template template = new Template();

        LineOther line01 = new LineOther();
        line01.add(new OperationDeclaration(combattant, perso1));
        line01.add(new OperationAssignment());
        line01.add(new OperationInstantiation(perso1, clerc));

        LineOther line02 = new LineOther();
        line02.add(new OperationObjectUse(perso1));
        line02.add(new OperationAssignment());
        line02.add(new OperationInstantiation(perso1, guerrier));

        template.add(line01);
        template.add(line02);
        template.add(new LineMethodCall(perso1, lancerSort));

        System.out.println(template.display());
        template.compile();
        System.out.println();
        template.execute();
        System.out.println();
    }

}
