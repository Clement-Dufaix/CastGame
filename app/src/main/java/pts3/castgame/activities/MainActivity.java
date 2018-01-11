package pts3.castgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import pts3.castgame.R;
import pts3.castgame.fragments.CardFragment;
import pts3.castgame.fragments.GameTypeFragment;
import pts3.castgame.fragments.AnswerCompanionFragment;
import pts3.castgame.fragments.TemplateFragment;
import pts3.castgame.models.lien.FacadeAnswer;
import pts3.castgame.models.lien.FacadeMoteur;

public class MainActivity extends AppCompatActivity {

    Intent intentMap;
    FacadeMoteur facade;
    FacadeAnswer facadeAnswer;

    private static final String fragTag = "FRAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentMap = new Intent(this, MapActivity.class);
        facade = new FacadeMoteur();
    }

    public FacadeMoteur getFacade() {
        return facade;
    }

    public FacadeAnswer getFacadeAnswer() {
        return facadeAnswer;
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // On remplace l'ancien fragment par le nouveau.
        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(fragTag);
        // On commit la transaction.
        transaction.commit();
    }

    public void selectEasyMode(View view) {
        GameTypeFragment newFragment = new GameTypeFragment();
        setFragment(newFragment);
        intentMap.putExtra("isHard", false);
    }

    public void selectHardMode(View view) {
        GameTypeFragment newFragment = new GameTypeFragment();
        setFragment(newFragment);
        intentMap.putExtra("isHard", true);
    }

    public void selectCompanionMode(View view) {
        TemplateFragment newFragment = new TemplateFragment();
        setFragment(newFragment);
    }

    public void loadNewTemplate(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(fragTag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        TemplateFragment newFragment = new TemplateFragment();
        setFragment(newFragment);
    }

    public void loadCompanionAnswer() {
        AnswerCompanionFragment newFragment = new AnswerCompanionFragment();
        setFragment(newFragment);
    }

    /**
     * Sélectionne une carte, tant qu'il reste des cartes à sélectionner (voir dans le fragment associé).
     */
    public void selectCard() {
        CardFragment newFragment = new CardFragment();
        setFragment(newFragment);
    }

    public void selectMethod(View view) {
        AnswerCompanionFragment newFragment = new AnswerCompanionFragment();
        setFragment(newFragment);
    }

    public void showMap(View view) {
        startActivity(intentMap);
    }

}
