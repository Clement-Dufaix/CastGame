package pts3.castgame.fragments;


import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;

public class DifficultyChoiceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_difficulty_choice, container, false);
    }

    private void selectDifficultyEasy(View view) {
        // Voir dans l'activité.
    }

    private void selectDifficultyHard(View view) {
        // Voir dans l'activité.
    }

}