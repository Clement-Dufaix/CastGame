package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;


public class ResultatPapierFragment extends Fragment {

    TextView template;
    TextView compilePasTextView;
    TextView executePasTextView;
    TextView afficheTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_answer, container, false);
        template = v.findViewById(R.id.templateReponseTextView);
        template.setText(((MainActivity) getActivity()).getIntent().getStringExtra("template"));
        compilePasTextView = v.findViewById(R.id.compilePasTextView);
        compilePasTextView.setVisibility(View.VISIBLE);
        executePasTextView = v.findViewById(R.id.executePasTextView);
        compilePasTextView.setVisibility(View.VISIBLE);
        executePasTextView = v.findViewById(R.id.executePasTextView);
        executePasTextView.setVisibility(View.VISIBLE);
        executePasTextView.setText("Affiche :\n'La carte'");

        return v;
    }
}
