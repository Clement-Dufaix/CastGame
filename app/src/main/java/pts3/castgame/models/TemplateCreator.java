package pts3.castgame.models;

import pts3.castgame.models.castgame.CastGameCard;
import pts3.castgame.models.castgame.CastGameObject;
import pts3.castgame.models.template.Line;
import pts3.castgame.models.template.OperationAssignment;
import pts3.castgame.models.template.OperationCast;
import pts3.castgame.models.template.OperationDeclaration;
import pts3.castgame.models.template.OperationDisplay;
import pts3.castgame.models.template.OperationInstantiation;
import pts3.castgame.models.template.Template;

public class TemplateCreator {

    private static CastGameCard card1 = new CastGameCard("Carte1", false);
    private static CastGameCard card2 = new CastGameCard("Carte2", false);

    private static CastGameObject perso1 = new CastGameObject("perso1");
    private static CastGameObject perso2 = new CastGameObject("perso2");


    //Carte1 perso1 = new Carte2;
    // System.out.println(perso);
    public Template creerTemplate1() {
        Template template = new Template();
        Line ligne01 = new Line();
        ligne01.add(new OperationDeclaration(card1, perso1));
        ligne01.add(new OperationAssignment());
        ligne01.add(new OperationInstantiation(card2));

        Line ligne02 = new Line();
        ligne02.add(new OperationDisplay(perso1));

        template.add(ligne01);
        template.add(ligne02);

        return template;
    }

    //Carte1 perso1 = (Carte1) new Carte2;
    // System.out.println(perso);
    public Template template02() {
        Template template = new Template();

        Line ligne01 = new Line();
        ligne01.add(new OperationDeclaration(card1, perso1));
        ligne01.add(new OperationAssignment());
        ligne01.add(new OperationCast(card1));
        ligne01.add(new OperationInstantiation(card2));

        Line ligne02 = new Line();
        ligne02.add(new OperationDisplay(perso1));

        template.add(ligne01);
        template.add(ligne02);

        return template;

    }

}
