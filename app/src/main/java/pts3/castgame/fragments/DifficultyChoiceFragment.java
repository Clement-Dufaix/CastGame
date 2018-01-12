package pts3.castgame.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;

public class DifficultyChoiceFragment extends Fragment {

    private Button bEasy;
    private Button bHard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_difficulty_choice, container, false);

        bEasy = view.findViewById(R.id.b_diff_easy);
        bEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setDifficulty("easy");
                ((MainActivity) getActivity()).getFacade().setDifficile(false);
            }
        });

        bHard = view.findViewById(R.id.b_diff_hard);
        bHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).setDifficulty("hard");
                ((MainActivity) getActivity()).getFacade().setDifficile(true);
            }
        });
        return view;
    }

}
