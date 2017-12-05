package pts3.castgame;

import pts3.castgame.models.castgame.CastGameCard;
import pts3.castgame.models.castgame.CastGameObject;
import pts3.castgame.models.template.Line;
import pts3.castgame.models.template.OperationAssignment;
import pts3.castgame.models.template.OperationDeclaration;
import pts3.castgame.models.template.OperationDisplay;
import pts3.castgame.models.template.OperationInstantiation;
import pts3.castgame.models.template.OperationObject;
import pts3.castgame.models.template.Template;

public class TestTemplate {

    public static CastGameObject perso1 = new CastGameObject("perso1");
    public static CastGameObject perso2 = new CastGameObject("perso2");
    public static CastGameCard card1 = new CastGameCard("Carte1", false);
    public static CastGameCard card2 = new CastGameCard("Carte2", false);

    private static void template01() {
        // Création d'un template.
        Template template = new Template();

        // Création des éléments de la ligne.
        Line ligne01 = new Line();
        ligne01.add(new OperationDeclaration(card1, perso1));
        ligne01.add(new OperationAssignment());
        ligne01.add(new OperationInstantiation(card1));

        Line ligne02 = new Line();
        ligne02.add(new OperationDeclaration(card2, perso2));
        ligne02.add(new OperationAssignment());
        ligne02.add(new OperationObject(perso1));

        Line ligne03 = new Line();
        ligne03.add(new OperationDisplay(perso2));

        template.add(ligne01);
        template.add(ligne02);
        template.add(ligne03);

        System.out.println(template.display());
    }

}
