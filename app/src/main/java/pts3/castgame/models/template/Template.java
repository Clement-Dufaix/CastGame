package pts3.castgame.models.template;

import java.util.ArrayList;
import java.util.List;

/**
 * Le template, composé de lignes.
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

    public String display() {
        String template = "";
        for (Line line : lines) {
            template += line.display() + "\n";
        }
        return template;
    }

}
