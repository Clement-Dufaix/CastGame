package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_answer_solo, container, false);

        buttonNokCompile = v.findViewById(R.id.buttonNokCompile);
        buttonOkCompile = v.findViewById(R.id.buttonOkCompile);
        buttonNokExecute = v.findViewById(R.id.buttonNokExecute);
        buttonOkExecute = v.findViewById(R.id.buttonOkExecute);

        facade = ((MainActivity) getActivity()).getFacade();

        facade.reset();

        facade.setTemplateChoisi(facade.getListTemplate().get((int) Math.random() * (facade.getListTemplate().size() - 1)));    //on choisit un template aléatoire


        while (facade.getEtat() > 0) { //on choisit aléatoirement les cartes classe
            facade.ajouterCarte((int) (Math.random() * (facade.getCarteClasseListString().size()) - 1), facade.getEtat());
        }

        if (facade.getEtat() == 0) {    //si il faut ajouter une carte méthode, on en ajoute une aléatoire
            facade.ajouterCarte((int) (Math.random() * (facade.getCarteMethode().size()) - 1), facade.getEtat());
        }


        templateTextView = v.findViewById(R.id.template_selected_Solo);
        templateTextView.setText(facade.getTemplateString());

        spinner = v.findViewById(R.id.spinnerSolo);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, facade.getCarteMethode());
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        buttonNokCompile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonNokCompile.setImageResource(R.drawable.nok);
                buttonNokCompile.setTag("white");
                if(buttonOkCompile.getTag().equals("white")){
                    buttonOkCompile.setImageResource(R.drawable.ok_black_white);
                    buttonOkCompile.setTag("black");
                }
            }
        });

        buttonOkCompile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonOkCompile.setImageResource(R.drawable.ok);
                buttonOkCompile.setTag("white");
                if(buttonNokCompile.getTag().equals("white")){
                    buttonNokCompile.setImageResource(R.drawable.nok_black_white);
                    buttonNokCompile.setTag("black");
                }
            }
        });

        buttonNokExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonNokExecute.setTag("white");
                buttonNokExecute.setImageResource(R.drawable.nok);
                if(buttonOkExecute.getTag().equals("white")){
                    buttonOkExecute.setImageResource(R.drawable.ok_black_white);
                    buttonOkExecute.setTag("black");
                }
            }
        });

        buttonOkExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonOkExecute.setTag("white");
                buttonOkExecute.setImageResource(R.drawable.ok);
                if(buttonNokExecute.getTag().equals("white")){
                    buttonNokExecute.setImageResource(R.drawable.nok_black_white);
                    buttonNokExecute.setTag("black");
                }
            }
        });

        return v;
    }
}
