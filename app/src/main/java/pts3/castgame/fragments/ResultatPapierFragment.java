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
import pts3.castgame.models.lien.FacadeMoteur;

public class ResultatPapierFragment extends Fragment {

    TextView template;
    ImageView compilationImageView;
    ImageView executionImageView;
    ImageView displayImageView;
    TextView displayTextView;
    FacadeMoteur facade;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_answer_companion, container, false);

        MainActivity mainActivity = (MainActivity) getActivity();
        facade = mainActivity.getFacade();
        template = v.findViewById(R.id.templateReponseTextView);
        compilationImageView = v.findViewById(R.id.icon_compilation);
        executionImageView = v.findViewById(R.id.icon_execution);
        displayImageView = v.findViewById(R.id.icon_display);
        displayTextView = v.findViewById(R.id.text_display);
        template.setText((getActivity()).getIntent().getStringExtra("template"));

        // Pas pour les templates utilisant des méthodes...
        displayTextView.setText("Affichage\nen sortie");

        return v;
    }

    // Juste pour éviter les erreurs dans le preview du fragment
    public void loadNewTemplate(View view) {

    }
}
