package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;
import pts3.castgame.models.CastGameAnswer;
import pts3.castgame.models.lien.FacadeMoteur;

public class ResultatPapierFragment extends Fragment {

    FacadeMoteur facade;

    TextView templateContainer;
    ImageView compilationImageView;
    ImageView executionImageView;
    ImageView displayImageView;
    TextView displayTextView;

    CastGameAnswer answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_answer_companion, container, false);

        MainActivity mainActivity = (MainActivity) getActivity();
        facade = mainActivity.getFacade();
        // answer = facade.getTemplateAnswer();

        // Remplissage du template.
        templateContainer = v.findViewById(R.id.template_container);
        templateContainer.setText(facade.getTemplateString());

        compilationImageView = v.findViewById(R.id.icon_compilation);
        executionImageView = v.findViewById(R.id.icon_execution);
        displayImageView = v.findViewById(R.id.icon_display);
        displayTextView = v.findViewById(R.id.text_display);

        // On n'affiche rien en sortie si on utilise une méthode.
        if (facade.useMethod()) {
            v.findViewById(R.id.display_container).setVisibility(View.INVISIBLE);
        } else {
           // displayTextView.setText("Affiche :\n" + answer.getOutputDisplay());
        }
        return v;
    }

    // Juste pour éviter les erreurs dans le preview du fragment
    public void loadNewTemplate(View view) {

    }

}
