package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;
import pts3.castgame.models.lien.FacadeMoteur;

public class CardFragment extends Fragment {

    private FacadeMoteur facade;
    private int state;
    private TextView templateTextView;
    private ListView listCards;
    private TextView actualCardTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_card, container, false);

        facade = ((MainActivity) getActivity()).getFacade();
        actualCardTextView = v.findViewById(R.id.actual_card);
        listCards = v.findViewById(R.id.list_cards);
        ArrayAdapter<String> adapter;

        // Pour 1, 2, 3 on remplace respectivement la carte 1, 2, 3
        // Pour 0 on remplace la carte méthode.
        state = facade.getEtat();

        // Si on doit sélectionner une carte personnage.
        if (state > 0) {
            actualCardTextView.setText("Carte " + state + " :");
            adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, facade.getCarteClasseListString());
        }
        // Sinon, on sélectionne la carte méthode.
        else {
            actualCardTextView.setText("Carte Méthode :");
            adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, facade.getCarteMethode());
        }

        listCards.setAdapter(adapter);
        listCards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                facade.ajouterCarte(position, state);
                // S'il reste des cartes à sélectionner
                if (facade.getEtat() != -1) {
                    ((MainActivity) getActivity()).setFragmentCardSelection();
                }
                // TODO : Regarder quel mode de jeu et afficher la bonne page de réponse.
                else {
                    ((MainActivity) getActivity()).loadFragmentCompanionAnswer();
                }
            }
        });

        templateTextView = v.findViewById(R.id.slected_template);
        templateTextView.setText(facade.getTemplateString());
        return v;
    }

}
