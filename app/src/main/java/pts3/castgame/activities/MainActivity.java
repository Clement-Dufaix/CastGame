package pts3.castgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import pts3.castgame.R;
import pts3.castgame.fragments.CardFragment;
import pts3.castgame.fragments.DifficultyChoiceFragment;
import pts3.castgame.fragments.GameTypeFragment;
import pts3.castgame.fragments.MethodFragment;
import pts3.castgame.fragments.TemplateFragment;
import pts3.castgame.models.lien.FacadeMoteur;

public class MainActivity extends AppCompatActivity {

    Intent intentMap;

    //Fragments
    Fragment fragmentDifficultyChoice;
    Fragment fragmentGameType;
    Fragment fragmentTemplate;
    Fragment fragmentCard;
    Fragment fragmentMethod;

    FacadeMoteur facade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeFragments();
        intentMap = new Intent(this, MapActivity.class);

        // Destruction de la pile : justement à voir avec notre modulo du tableau.
        // getIntent().setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        // FragmentManager holder = this.getSupportFragmentManager();
        // holder.popBackStack();

        facade = new FacadeMoteur();
    }

    // Voir si c'est pas mieux un tableau pour utiliser des modulos pour revenir en arrière (au premier donc).
    private void initializeFragments() {
        fragmentDifficultyChoice = new DifficultyChoiceFragment();
        fragmentGameType = new GameTypeFragment();
        fragmentTemplate = new TemplateFragment();
        fragmentCard = new CardFragment();
        fragmentMethod = new MethodFragment();
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // On remplace l'ancien fragment par le nouveau.
        transaction.replace(R.id.fragment, fragment);
        // On n'ajoute pas le fragment dans la pile.
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void selectDifficultyEasy(View view) {
        setFragment(fragmentGameType);
        intentMap.putExtra("isHardMode", false);
    }

    public void selectDifficultyHard(View view) {
        setFragment(fragmentGameType);
        intentMap.putExtra("isHardMode", true);
    }

    public void selectCompanionMode(View view) {
        setFragment(fragmentTemplate);
    }

    public void selectTemplate(View view) {
        setFragment(fragmentCard);
    }

    public void selectMethod(View view) {
        setFragment(fragmentMethod);
    }

    public void showMap(View view) {
        startActivity(intentMap);
    }

    public void selectTemplate() {
        setFragment(fragmentCard);
    }

    public FacadeMoteur getFacade() {
        return facade;
    }

}
