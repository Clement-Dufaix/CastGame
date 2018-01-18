package pts3.castgame.fragments;

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
import android.widget.LinearLayout;
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
    private ImageButton buttonOkCompile;
    private ImageButton buttonOkExecute;
    private Spinner spinner;

    private View compilationLine;
    private LinearLayout layoutExecute;
    private View executionLine;
    private LinearLayout layoutDisplay;

    private boolean compilationSupposed = false;
    private boolean executionSupposed = false;
    private String displaySupposed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer_solo, container, false);

        facadeMoteur = ((MainActivity) getActivity()).getFacade();
        createTemplate(view);

        compilationLine = view.findViewById(R.id.line_compilation);
        executionLine = view.findViewById(R.id.line_execution);
        layoutExecute = view.findViewById(R.id.executeLayout);
        layoutDisplay = view.findViewById(R.id.display_container);

        buttonOkCompile = view.findViewById(R.id.buttonOkCompile);
        buttonOkCompile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (compilationSupposed) {  //quand on décoche compilation, tout redevient par défaut
                    compilationSupposed = false;
                    executionSupposed = false;
                    buttonOkExecute.setBackgroundResource(R.drawable.nok);
                    buttonOkCompile.setBackgroundResource(R.drawable.nok);

                    compilationLine.setVisibility(View.INVISIBLE);
                    executionLine.setVisibility(View.INVISIBLE);
                    layoutExecute.setVisibility(View.INVISIBLE);
                    layoutDisplay.setVisibility(View.INVISIBLE);
                } else {         //quand on coche compilation cela fait apparaitre la demande d'exécution
                    compilationSupposed = true;
                    buttonOkCompile.setBackgroundResource(R.drawable.ok);
                    compilationLine.setVisibility(View.VISIBLE);
                    layoutExecute.setVisibility(View.VISIBLE);
                    executionLine.setVisibility(View.VISIBLE);
                }
            }
        });


        buttonOkExecute = view.findViewById(R.id.buttonOkExecute);
        buttonOkExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (executionSupposed) {         //quand on décoche compilation, on enlève la sélection d'affichage
                    executionSupposed = false;
                    buttonOkExecute.setBackgroundResource(R.drawable.nok);
                    executionLine.setVisibility(View.INVISIBLE);
                    layoutDisplay.setVisibility(View.INVISIBLE);
                } else {    //quand on coche compilation, on rajoute la sélection d'affichage
                    executionSupposed = true;
                    buttonOkExecute.setBackgroundResource(R.drawable.ok);
                    executionLine.setVisibility(View.VISIBLE);
                    layoutDisplay.setVisibility(View.VISIBLE);
                }
            }
        });

        bValidate = view.findViewById(R.id.b_validate);
        bValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(compilationSupposed, executionSupposed, displaySupposed);

            }
        });

        //Menu déroulant pour sélectionner une réponse parmi celles proposées pour l'affichage en sortie
        spinner = view.findViewById(R.id.spinner_solo);
        List<String> temp = new ArrayList<>();
        //l'utilisateur peut choisir entre aucun et les différentes classes présentes dans le code
        temp.add("Aucun");
        temp.addAll(facadeMoteur.getPossibleAnswers());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, temp);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                displaySupposed = spinner.getAdapter().getItem(position).toString();
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
