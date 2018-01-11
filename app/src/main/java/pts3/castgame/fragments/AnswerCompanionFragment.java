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

public class AnswerCompanionFragment extends Fragment {

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

        // On n'affiche rien en sortie si on utilise une méthode.
        if (facadeMoteur.useMethod()) {
            displayTextView.setText("Pas d'affichage,\n appel à une méthode");
        } else {
            // displayTextView.setText("Affiche :\n" + facadeAnswer.getOutputDisplay());
        }
        return view;
    }

    private void initializeContainers(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        facadeMoteur = mainActivity.getFacade();
        facadeAnswer = mainActivity.getFacadeAnswer();

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
