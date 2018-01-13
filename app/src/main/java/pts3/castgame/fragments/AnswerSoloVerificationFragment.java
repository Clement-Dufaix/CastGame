package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    private ImageView supposedCompilation;
    private ImageView supposedExecution;
    private TextView supposedDisplay;
    private ImageView solutionCompilation;
    private ImageView solutionExecution;
    private TextView solutionDisplay;
    private TextView errorDisplay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer_verification_solo, container, false);
        context = (MainActivity) getActivity();

        initializeContainers(view);
        getSolution();

        return view;
    }

    private void initializeContainers(View view) {

        facadeMoteur = context.getFacade();
        facadeAnswer = facadeMoteur.getAnswer();

        supposedCompilation = view.findViewById(R.id.supposed_compilation);
        supposedExecution = view.findViewById(R.id.supposed_execution);
        supposedDisplay = view.findViewById(R.id.supposed_display);

        solutionCompilation = view.findViewById(R.id.solution_compilation);
        solutionExecution = view.findViewById(R.id.solution_execution);
        solutionDisplay = view.findViewById(R.id.solution_display);
        errorDisplay = view.findViewById(R.id.error_display);
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
