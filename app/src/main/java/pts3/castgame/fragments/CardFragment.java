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

    TextView templateTextView;
    ListView mListView;
    TextView choixActuelleTextView;
    int etat;
    FacadeMoteur facade;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_card, container, false);
        facade = ((MainActivity) getActivity()).getFacade();
        choixActuelleTextView = v.findViewById(R.id.ChoixActuelleCartePersonnage);
        mListView = v.findViewById(R.id.listPersonnage);
        ArrayAdapter<String> adapter;

        etat = facade.getEtat(); // 1 : on remplace Carte 1, 2 : on remplace Carte 2, 3: on remplace Carte 3, 0 : On remplace Carte M

        if (etat > 0) {
            choixActuelleTextView.setText("Carte " + etat + " :");
            adapter = new ArrayAdapter<>(    //on associe les valeurs des cartes à la liste
                    getActivity(),
                    android.R.layout.simple_list_item_1,
                    facade.getCarteClasseListString()
            );
        } else {
            choixActuelleTextView.setText("Carte Méthode :");
            adapter = new ArrayAdapter<>(    //on associe les valeurs des cartes à la liste
                    getActivity(),
                    android.R.layout.simple_list_item_1,
                    facade.getCarteMethode()
            );
        }

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {    //quand on clique sur un choix
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  //on va se servir de la position de l'élément cliqué dans la liste
                facade.ajouterCarte(position, etat);
                if (facade.getEtat() != -1)
                    ((MainActivity) getActivity()).setFragmentCardSelection();
                else ((MainActivity) getActivity()).loadFragmentCompanionAnswer();
                //TODO coder methode choisirReponsePapier()
            }
        });


        templateTextView = v.findViewById(R.id.templateChoixPersonnage);
        templateTextView.setText(facade.getTemplateString());
        //  Log.e("debug texte: ", (String) templateTextView.getText());

        return v;
    }


}
