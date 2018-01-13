package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;
import pts3.castgame.models.lien.FacadeAnswer;
import pts3.castgame.models.lien.FacadeMoteur;

public class AnswerSoloVerificationFragment extends Fragment {

    private MainActivity context;
    private FacadeMoteur facadeMoteur;
    private FacadeAnswer facadeAnswer;

    private TextView templateContainer;
    private ImageView supposedCompilation;
    private ImageView supposedExecution;
    private TextView supposedDisplay;
    private ImageView solutionCompilation;
    private ImageView solutionExecution;
    private TextView solutionDisplay;
    private TextView errorDisplay;

    private Button bReturn;
    private Button bNewRandomTemplate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer_verification_solo, container, false);
        context = (MainActivity) getActivity();

        initializeContainers(view);
        getPlayerSupposition();
        getSolution();

        bReturn = view.findViewById(R.id.b_return);
        bReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.canBackAgain();
                context.loadHome();
            }
        });

        bNewRandomTemplate = view.findViewById(R.id.b_new_random_template);
        bNewRandomTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.canBackAgain();
                context.startNewGameSolo();
            }
        });

        return view;
    }

    private void initializeContainers(View view) {

        facadeMoteur = context.getFacade();
        facadeAnswer = facadeMoteur.getAnswer();

        templateContainer = view.findViewById(R.id.template_selected);
        templateContainer.setText(facadeMoteur.getTemplateString());
        supposedCompilation = view.findViewById(R.id.supposed_compilation);
        supposedExecution = view.findViewById(R.id.supposed_execution);
        supposedDisplay = view.findViewById(R.id.supposed_display);

        solutionCompilation = view.findViewById(R.id.solution_compilation);
        solutionExecution = view.findViewById(R.id.solution_execution);
        solutionDisplay = view.findViewById(R.id.solution_display);
        errorDisplay = view.findViewById(R.id.error_display);
    }

    /**
     * Affiche les réponses proposées par le joueur.
     */
    private void getPlayerSupposition() {
        // Si le joueur pense que le code compile
        if (context.getSupposedCompilation()) {
            supposedCompilation.setBackgroundResource(R.drawable.ok);
        }
        // Si le joueur pense que le code s'exécute
        if (context.getSupposedExecution()) {
            supposedExecution.setBackgroundResource(R.drawable.ok);
        }
        supposedDisplay.setText(context.getSupposedDisplay());
    }

    // Code dupliqué par rapport à la récupération de solution de mode compagnon
    private void getSolution() {
        // Changement des images si la compilation et/ou l'exécution passent.
        if (!facadeAnswer.compilationError()) {
            solutionCompilation.setBackgroundResource(R.drawable.ok);
        }
        if (!facadeAnswer.executionError()) {
            solutionExecution.setBackgroundResource(R.drawable.ok);
        }
        // Si on fait un appel à une méthode.
        if (facadeMoteur.useMethod()) {
            if (facadeAnswer.codeIsWorking()) {
                solutionDisplay.setText("Aucun");
                errorDisplay.setText("Pas d'affichage,\n appel à une méthode");
            } else {
                solutionDisplay.setText("Aucun");
                errorDisplay.setText("Raison :\nErreur ligne n°" + facadeAnswer.getLineNumber() + " : " + facadeAnswer.getExplanation());
            }
        } else {
            if (facadeAnswer.getOutputDisplay().equals("")) {
                solutionDisplay.setText("Aucun");
                errorDisplay.setText("Raison :\nErreur ligne n°" + facadeAnswer.getLineNumber() + " : " + facadeAnswer.getExplanation());
            } else {
                solutionDisplay.setText("Affiche :\n" + facadeAnswer.getOutputDisplay());
                errorDisplay.setText("Affiche :\n" + facadeAnswer.getOutputDisplay());
            }
        }
    }

}
