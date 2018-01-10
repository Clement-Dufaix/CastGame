package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pts3.castgame.R;

public class MethodFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_method, container, false);
    }

    // Juste pour éviter les erreurs dans le preview du fragment
    public void selectMethod(View view) {

    }

}
