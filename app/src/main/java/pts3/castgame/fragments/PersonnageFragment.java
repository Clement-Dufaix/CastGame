package pts3.castgame.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pts3.castgame.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonnageFragment extends Fragment {


    public PersonnageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personnage, container, false);
    }

}
