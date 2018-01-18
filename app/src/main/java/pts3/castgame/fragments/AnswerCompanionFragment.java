package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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

public class AnswerCompanionFragment extends Fragment {

    private MainActivity context;
    private FacadeMoteur facadeMoteur;
    private FacadeAnswer facadeAnswer;

    private TextView templateContainer;
    private ImageView compilationImageView;
    private ImageView executionImageView;
    private TextView displayTextView;

    private Button bNewTemplate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_answer_companion, container, false);
        context = (MainActivity) getActivity();

        initializeContainers(view);

        bNewTemplate = view.findViewById(R.id.b_new_template);
        bNewTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).loadNewTemplate();
            }
        });

        // Changement des images si la compilation et/ou l'exécution passent.
        if (!facadeAnswer.compilationError()) {
            compilationImageView.setBackgroundResource(R.drawable.ok);
        }
        if (!facadeAnswer.executionError()) {
            executionImageView.setBackgroundResource(R.drawable.ok);
        }

        if (!facadeAnswer.codeIsWorking()) {
                displayTextView.setText("Erreur ligne n°" + facadeAnswer.getLineNumber() + " : " + facadeAnswer.getExplanation());
        } else {
                displayTextView.setText("Affiche :\n" + facadeAnswer.getOutputDisplay());
        }
        return view;
    }

    private void initializeContainers(View view) {
        facadeMoteur = context.getFacade();
        facadeAnswer = facadeMoteur.getAnswer();

        templateContainer = view.findViewById(R.id.template_container);
        templateContainer.setText(facadeMoteur.getTemplateString());

        compilationImageView = view.findViewById(R.id.icon_compilation);
        executionImageView = view.findViewById(R.id.icon_execution);
        displayTextView = view.findViewById(R.id.text_display);
    }

}
