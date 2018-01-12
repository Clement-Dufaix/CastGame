package pts3.castgame.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;

public class GameTypeFragment extends Fragment {

    private Button bCompanion;
    private Button bSolo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_type, container, false);

        bCompanion = view.findViewById(R.id.b_mode_companion);
        bCompanion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).startNewCompanionGame();
            }
        });
        bSolo = view.findViewById(R.id.b_mode_solo);
        bSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Impossible pour le moment !", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
