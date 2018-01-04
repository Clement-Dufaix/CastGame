package pts3.castgame.models.template;

import java.util.ArrayList;
import java.util.List;

/**
 * Les lignes autres que l'affichage, composées d'opérations.
 */
public class LineOther implements Line {

    public List<Operation> operations;

    public LineOther() {
        super();
        this.operations = new ArrayList<>();
    }

    public void add(Operation operation) {
        operations.add(operation);
    }

    @Override
    public String display() {
        String line = "";
        for (Operation operation : operations) {
            line += operation.toString();
        }
        return line + ";";
    }

    @Override
    public void compile() {
        for (Operation operation : operations) {
            operation.compile();
        }
    }

    @Override
    public void execute() {
        for (Operation operation : operations) {
            operation.execute();
        }
    }

}

