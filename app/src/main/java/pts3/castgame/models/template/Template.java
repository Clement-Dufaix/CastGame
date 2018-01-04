package pts3.castgame.models.template;

import java.util.ArrayList;
import java.util.List;

/**
 * Les templates du CastGame
 */
public class Template {

    // Les lignes du template
    private List<Line> lines;

    public Template() {
        super();
        this.lines = new ArrayList<>();
    }

    public void add(Line line) {
        lines.add(line);
    }

    /**
     * Affiche le template
     *
     * @return Le résultat sous forme de chaîne de caractères
     */
    public String display() {
        String template = "";
        for (Line line : lines) {
            template += line.display() + "\n";
        }
        return template;
    }

    /**
     * Compile le template et donne les erreurs de compilation si existantes
     */
    public void compile() {
        int nLine = 0;
        for (Line line : lines) {
            nLine++;
            System.out.print("Ligne " + nLine + " ");
            line.compile();
            System.out.println();
        }
    }

    /**
     * Exécute le template et donne les erreurs d'exécution si existantes
     */
    public void execute() {
        int nLine = 0;
        for (Line line : lines) {
            nLine++;
            System.out.print("Ligne " + nLine + " ");
            line.execute();
            System.out.println();
        }
    }

}
