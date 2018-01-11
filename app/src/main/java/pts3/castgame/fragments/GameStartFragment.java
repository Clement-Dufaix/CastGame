package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pts3.castgame.R;

public class GameStartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_start, container, false);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(800);
                    TemplateFragment fragment = new TemplateFragment();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    // On remplace l'ancien fragment par le nouveau.
                    transaction.add(R.id.fragment_container, fragment);
                    // On ajoute le fragment à la pile.
                    transaction.addToBackStack("TAG");
                    // On commit la transaction.
                    transaction.commit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return view;
    }

}
