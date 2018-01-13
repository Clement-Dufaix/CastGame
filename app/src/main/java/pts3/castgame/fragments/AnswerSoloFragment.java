package pts3.castgame.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;
import pts3.castgame.models.lien.FacadeMoteur;

public class AnswerSoloFragment extends Fragment {

    private FacadeMoteur facadeMoteur;

    private TextView templateTextView;
    private Button bValidate;
    private ImageButton buttonNokCompile;
    private ImageButton buttonOkCompile;
    private ImageButton buttonNokExecute;
    private ImageButton buttonOkExecute;
    private Spinner spinner;

    private boolean compilationSelected = false;
    private boolean executionSelected = false;

    private boolean compilationSupposed;
    private boolean executionSupposed;
    private String displaySupposed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer_solo, container, false);

        facadeMoteur = ((MainActivity) getActivity()).getFacade();
        createTemplate(view);

        buttonNokCompile = view.findViewById(R.id.buttonNokCompile);
        buttonNokCompile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compilationSelected = true;
                compilationSupposed = false;
                buttonNokCompile.setImageResource(R.drawable.nok);
                buttonOkCompile.setImageResource(R.drawable.ok_black_white);
            }
        });

        buttonOkCompile = view.findViewById(R.id.buttonOkCompile);
        buttonOkCompile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compilationSelected = true;
                compilationSupposed = true;
                buttonOkCompile.setImageResource(R.drawable.ok);
                buttonNokCompile.setImageResource(R.drawable.nok_black_white);
            }
        });

        buttonNokExecute = view.findViewById(R.id.buttonNokExecute);
        buttonNokExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executionSelected = true;
                executionSupposed = false;
                buttonNokExecute.setImageResource(R.drawable.nok);
                buttonOkExecute.setImageResource(R.drawable.ok_black_white);
            }
        });

        buttonOkExecute = view.findViewById(R.id.buttonOkExecute);
        buttonOkExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executionSelected = true;
                executionSupposed = true;
                buttonOkExecute.setImageResource(R.drawable.ok);
                buttonNokExecute.setImageResource(R.drawable.nok_black_white);
            }
        });

        bValidate = view.findViewById(R.id.b_validate);
        bValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Si le joueur n'a rien sélectionné pour la compilation ou l'exécution
                if (!compilationSelected || !executionSelected) {
                    // Regarder comment envoyer un toast depuis un fragment MAKE ne marche pas.
                    // Toast t = Toast.makeText(getActivity(), "Vous devez faire un choix de compilation/exécution", Toast.LENGTH_LONG);
                    // t.setGravity(Gravity.BOTTOM, 0, 200);
                    // t.show();
                } else {
                    validate(compilationSupposed, executionSupposed, displaySupposed);
                }
            }
        });

        //Menu déroulant pour sélectionner une réponse parmi celles proposées pour l'affichage en sortie
        spinner = view.findViewById(R.id.spinnerSolo);
        List<String> temp = new ArrayList<>();
        //l'utilisateur peut choisir entre aucun et les différentes classes présentes dans le code
        temp.add("aucun");
        temp.addAll(facadeMoteur.getPossibleAnswers());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, temp);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                displaySupposed = spinner.getAdapter().getItem(position).toString();
                Log.e("CONTENT", "a : " + spinner.getAdapter().getItem(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    private void createTemplate(View view) {
        // Nettoyage de la facade.
        facadeMoteur.reset();
        //on choisit un template aléatoire
        facadeMoteur.setTemplateChoisi(facadeMoteur.getListTemplate().get((int) Math.random() * (facadeMoteur.getListTemplate().size() - 1)));
        //on choisit aléatoirement les cartes classe
        while (facadeMoteur.getEtat() > 0) {
            facadeMoteur.ajouterCarte((int) (Math.random() * (facadeMoteur.getCarteClasseListString().size()) - 1), facadeMoteur.getEtat());
        }
        //S'il faut ajouter une carte méthode, on en ajoute une aléatoire
        if (facadeMoteur.getEtat() == 0) {
            facadeMoteur.ajouterCarte((int) (Math.random() * (facadeMoteur.getCarteMethode().size()) - 1), facadeMoteur.getEtat());
        }
        templateTextView = view.findViewById(R.id.template_selected);
        templateTextView.setText(facadeMoteur.getTemplateString());
    }

    /**
     * On envoie dans l'activité d'affichage de réponse les choix du joueur.
     *
     * @param compilationSupposed : Le booleen donnant l'avis du joueur pour la compilation du template
     * @param executionSupposed   : Le booleen donnant l'avis du joueur pour l'exécution du template
     * @param displaySupposed     : La chaîne de caractèrtes donnant l'avis du joueur sur l'affichage en sortie
     */
    public void validate(boolean compilationSupposed, boolean executionSupposed, String displaySupposed) {
        ((MainActivity) getActivity()).showAnswerComparaison(compilationSupposed, executionSupposed, displaySupposed);
    }

}
