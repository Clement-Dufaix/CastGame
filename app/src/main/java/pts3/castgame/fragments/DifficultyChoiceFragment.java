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

    private MainActivity context;
    private Button bEasy;
    private Button bHard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_difficulty_choice, container, false);
        context = (MainActivity) getActivity();

        bEasy = view.findViewById(R.id.b_diff_easy);
        bEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.setDifficulty("easy", false);
            }
        });

        bHard = view.findViewById(R.id.b_diff_hard);
        bHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.setDifficulty("hard", true);
            }
        });
        return view;
    }

}
