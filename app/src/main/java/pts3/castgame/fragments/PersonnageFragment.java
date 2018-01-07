package pts3.castgame.fragments;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;

        import pts3.castgame.R;
        import pts3.castgame.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonnageFragment extends Fragment {

    String[] carte;
    TextView templateTextView;
    ListView mListView;
    TextView choixActuelleTextView;
    int etat;
    String templateText;
    String changeCarte1;
    String changeCarte2;
    String changeCarte3;
    String changeCarteM;

    public PersonnageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_personnage, container, false);

        choixActuelleTextView = v.findViewById(R.id.ChoixActuelleCartePersonnage);

        templateText = ((MainActivity) getActivity()).getIntent().getStringExtra("template").replaceAll("[1-9]+\\) ", "");

        carte = new String[]{"Défenseur", "Attaquant", "Mendiant", "Combattant", "Guerrisseur", "LanceurDeSortProfane", "Guerrier", "LanceurDeSortDivin",
                "Magicien", "Sorceleur", "Clerc", "Pretre", "Sorcier", "LanceurDeSortMagique", "Necromancien"};
        etat = 0; // 1 : on remplace Carte 1, 2 : on remplace Carte 2, 3: on remplace Carte 3, 4 : On remplace Carte M

        if (templateText.indexOf("[Carte1]") != -1) {  //est ce que il reste écrit [carte 1]
            Log.e("etat : ", "1");
            etat = 1;
            choixActuelleTextView.setText("Carte 1 :");
        } else {
            if (templateText.indexOf("[Carte2]") != -1) {  //est ce que il reste écrit [carte 2]
                Log.e("etat : ", "2");
                etat = 2;
                choixActuelleTextView.setText("Carte 2 :");
            } else {
                if (templateText.indexOf("[Carte3]") != -1) {  //est ce que il reste écrit [carte 3]
                    Log.e("etat : ", "3");
                    etat = 3;
                    choixActuelleTextView.setText("Carte 3 :");
                } else {
                    if (templateText.indexOf("[CarteM]") != -1) {  //est ce que il reste écrit [carte M]
                        Log.e("etat : ", "M");
                        etat = 4;
                        choixActuelleTextView.setText("Carte Méthode :");
                        carte = new String[]{"defendre()", "attaquer()", "guerir()", "lancerSort()", "reveillerMort()", "toString()"};
                    } else {  //il n'y a plus de carte à changer
                        Log.e("etat : ", "fini");
                    }
                }
            }
        }

        mListView = (ListView) v.findViewById(R.id.listPersonnage);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(    //on associe les valeurs des cartes à la liste
                getActivity(),
                android.R.layout.simple_list_item_1,
                carte
        );
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {    //quand on clique sur un choix
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  //on va se servir de la position de l'élément cliqué dans la liste
                Log.e("etat actuelle : ",""+etat);
                if (etat == 1) {
                    changeCarte1=templateText;
                    templateText = templateText.replaceAll("\\[Carte1\\]",carte[position]);
                    Log.e("clique etat 1 : ",templateText);

                } else {
                    if (etat == 2) {
                        changeCarte2=templateText;
                        templateText = templateText.replaceAll("\\[Carte2\\]",carte[position]);
                        Log.e("clique etat 2 : ",templateText);
                    } else {
                        if (etat == 3) {
                            changeCarte3=templateText;
                            templateText = templateText.replaceAll("\\[Carte3\\]",carte[position]);
                        } else {
                            if (etat == 4) {
                                changeCarteM=templateText;
                                templateText = templateText.replaceAll("\\[CarteM\\]",carte[position]);
                            }
                            Log.e("on quitte la page : ", "vers la réponse" );
                        }
                    }
                }
                ((MainActivity)getActivity()).getIntent().putExtra("template",templateText);
                if(templateText.indexOf("[Carte1]") != -1 || templateText.indexOf("[Carte2]") != -1 || templateText.indexOf("[Carte3]") != -1 || templateText.indexOf("[CarteM]") != -1)
                    ((MainActivity)getActivity()).choisirTemplate();
                else((MainActivity)getActivity()).choisirReponsePapier();
            }
        });

        templateTextView = v.findViewById(R.id.templateChoixPersonnage);
        templateTextView.setText(templateText);
        //  Log.e("debug texte: ", (String) templateTextView.getText());

        return v;
    }



}
