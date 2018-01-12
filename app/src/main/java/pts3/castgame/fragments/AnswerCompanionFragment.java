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

    Button bNewTemplate;

    FacadeMoteur facadeMoteur;
    FacadeAnswer facadeAnswer;

    TextView templateContainer;
    ImageView compilationImageView;
    ImageView executionImageView;
    ImageView displayImageView;
    TextView displayTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer_companion, container, false);

        initializeContainers(view);

        bNewTemplate = view.findViewById(R.id.b_new_template);
        bNewTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).loadNewTemplate();
            }
        });

        if (!facadeAnswer.compilationError()) {
            compilationImageView.setBackgroundResource(R.drawable.ok);
        }
        if (!facadeAnswer.executionError()) {
            executionImageView.setBackgroundResource(R.drawable.ok);
        }
        if (facadeAnswer.codeIsWorking()) {
            displayImageView.setBackgroundResource(R.drawable.ok);
        }

        if (facadeMoteur.useMethod()) {
            if (facadeAnswer.codeIsWorking()) {
                displayTextView.setText("Pas d'affichage,\n appel à une méthode");

            } else {
                displayTextView.setText("Erreur ligne n°" + facadeAnswer.getLineNumber() + " : " + facadeAnswer.getExplanation());
                // On n'affiche pas d'icône puisqu'on se sert du layout pour afficher l'erreur.
                displayImageView.setVisibility(View.INVISIBLE);
            }
        } else {
            if (facadeAnswer.getOutputDisplay().equals("")) {
                displayTextView.setText("Erreur ligne n°" + facadeAnswer.getLineNumber() + " : " + facadeAnswer.getExplanation());
                // On n'affiche pas d'icône puisqu'on se sert du layout pour afficher l'erreur.
                displayImageView.setVisibility(View.INVISIBLE);
            } else {
                displayTextView.setText("Affiche :\n" + facadeAnswer.getOutputDisplay());
            }
        }
        return view;
    }

    private void initializeContainers(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        facadeMoteur = mainActivity.getFacade();
        facadeAnswer = facadeMoteur.getAnswer();

        templateContainer = view.findViewById(R.id.template_container);
        templateContainer.setText(facadeMoteur.getTemplateString());

        compilationImageView = view.findViewById(R.id.icon_compilation);
        executionImageView = view.findViewById(R.id.icon_execution);
        displayImageView = view.findViewById(R.id.icon_display);
        displayTextView = view.findViewById(R.id.text_display);
    }

    public void loadNewTemplate() {

    }

}
