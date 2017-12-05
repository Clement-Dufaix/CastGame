package pts3.castgame.models.template;

import java.util.ArrayList;
import java.util.List;

/**
 * La ligne, composée d'opérations.
 */
public class Line {

    public List<Operation> operations;

    public Line() {
        super();
        this.operations = new ArrayList<Operation>();
    }

    public void add(Operation operation) {
        operations.add(operation);
    }

    public String display() {
        String line = "";
        for (Operation operation : operations) {
            line += operation.toString();
        }
        return line + ";";
    }

}
