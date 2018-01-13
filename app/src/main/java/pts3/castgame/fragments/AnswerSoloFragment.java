package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;
import pts3.castgame.models.lien.FacadeMoteur;

public class AnswerSoloFragment extends Fragment {

    private TextView templateTextView;
    private Spinner spinner;
    private FacadeMoteur facade;
    private ImageButton buttonNokCompile;
    private ImageButton buttonOkCompile;
    private ImageButton buttonNokExecute;
    private ImageButton buttonOkExecute;
    private Button bValidate;

    private int compilationOpinion = -1;
    private int executionOpinion = -1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer_solo, container, false);

        facade = ((MainActivity) getActivity()).getFacade();
        createTemplate(view);

        buttonNokCompile = view.findViewById(R.id.buttonNokCompile);
        buttonNokCompile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compilationOpinion = 0;
                buttonNokCompile.setImageResource(R.drawable.nok);
                buttonOkCompile.setImageResource(R.drawable.ok_black_white);
            }
        });

        buttonOkCompile = view.findViewById(R.id.buttonOkCompile);
        buttonOkCompile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Utile une seule fois mais bon ça mettra à jour à chaque clic.
                compilationOpinion = 1;
                buttonOkCompile.setImageResource(R.drawable.ok);
                buttonNokCompile.setImageResource(R.drawable.nok_black_white);
            }
        });

        buttonNokExecute = view.findViewById(R.id.buttonNokExecute);
        buttonNokExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executionOpinion = 0;
                buttonNokExecute.setImageResource(R.drawable.nok);
                buttonOkExecute.setImageResource(R.drawable.ok_black_white);
            }
        });

        buttonOkExecute = view.findViewById(R.id.buttonOkExecute);
        buttonOkExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executionOpinion = 1;
                buttonOkExecute.setImageResource(R.drawable.ok);
                buttonNokExecute.setImageResource(R.drawable.nok_black_white);
            }
        });

        bValidate = view.findViewById(R.id.b_validate);
        bValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Si le joueur n'a rien sélectionné pour la compilation ou l'exécutnio
                if (compilationOpinion == -1 || executionOpinion == -1) {
                    Toast t = Toast.makeText(getActivity(), "Vous devez faire un choix de compilation/exécution", Toast.LENGTH_LONG);
                    t.setGravity(Gravity.BOTTOM, 0, 200);
                    t.show();
                } else {
                    validate();
                }
            }
        });

        spinner = view.findViewById(R.id.spinnerSolo);  //spinner pour la sélection de l'affichage en sortie
        List<String> temp = new ArrayList<String>();
        temp.add("aucun");  //l'utilisateur peut choisir entre aucun et les différentes classes présentes dans le code
        temp.addAll(facade.getPossibleAnswer());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,temp );
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    private void createTemplate(View view) {

        // Nettoyage de la facade.
        facade.reset();

        //on choisit un template aléatoire
        facade.setTemplateChoisi(facade.getListTemplate().get((int) Math.random() * (facade.getListTemplate().size() - 1)));

        //on choisit aléatoirement les cartes classe
        while (facade.getEtat() > 0) {
            facade.ajouterCarte((int) (Math.random() * (facade.getCarteClasseListString().size()) - 1), facade.getEtat());
        }

        //S'il faut ajouter une carte méthode, on en ajoute une aléatoire
        if (facade.getEtat() == 0) {
            facade.ajouterCarte((int) (Math.random() * (facade.getCarteMethode().size()) - 1), facade.getEtat());
        }

        templateTextView = view.findViewById(R.id.template_selected);
        templateTextView.setText(facade.getTemplateString());
    }

    public void validate() {

    }

}
