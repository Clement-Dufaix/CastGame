package pts3.castgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import pts3.castgame.R;
import pts3.castgame.fragments.MethodeFragment;
import pts3.castgame.fragments.PersonnageFragment;
import pts3.castgame.fragments.ReponseFragment;
import pts3.castgame.fragments.ResultatPapierFragment;
import pts3.castgame.fragments.TemplateFragment;
import pts3.castgame.fragments.TypeJeuFragment;

public class MainActivity extends AppCompatActivity {

    protected boolean isDifficile;      //false : le jeu est en mode facile, true le jeu est en mode difficile
    MapActivity map;
    Intent intentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentMap = new Intent(this, MapActivity.class);
    }

    // J'ai crée une fonction générique pour ajouter nos Fragments plutôt que de dupliquer pour chaque possibilité.
    // Le booléen sert à savoir si on permet le retour sur la page précédente ou pas.
    private void setFragment(Fragment fragment, boolean backStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // On remplace l'ancien fragment par le nouveau.
        transaction.replace(R.id.fragment, fragment);

        // ATTENTION : Les boutons parents ne sont pas désactivés.
        // (Essayez de cliquer sur une zone vide qui contenait un bouton vous verrez)

        //Si on souhaite pouvoir revenir en arrière.
        if (backStack) {
            transaction.addToBackStack(null);
        }
        // On commit la transaction.
        transaction.commit();
    }

    public void choisirDifficulteFacile(View view) {
        // On va vers le type de jeu.
        TypeJeuFragment newFragment = new TypeJeuFragment();
        setFragment(newFragment, true);
        isDifficile = false;   //le jeu est mit en mode difficile
        intentMap.putExtra("isDifficile", "" + isDifficile);
    }

    public void choisirDifficulteDifficile(View view) {
        // On va vers le type de jeu.
        TypeJeuFragment newFragment = new TypeJeuFragment();
        setFragment(newFragment, true);
        isDifficile = true;  //le jeu est mit en mode facile
        intentMap.putExtra("isDifficile", "" + isDifficile);
    }

    public void choisirTypeJeu(View view) {
        // On va vers le choix de template.
        TemplateFragment newFragment = new TemplateFragment();
        setFragment(newFragment, true);
    }

    public void choisirReponsePapier() {
        // On va vers la réponse du jeu papier (après avoir choisi le template et les cartes).
        ResultatPapierFragment newFragment = new ResultatPapierFragment();
        setFragment(newFragment, true);
    }

    public void choisirTemplate() {
        // On va vers le choix de carte personnage.
        PersonnageFragment newFragment = new PersonnageFragment();
        setFragment(newFragment, true);
    }

    // Attention le nombre d'appels varie en fonction du template (1, 2 ou 3 personnages).
    public void choisirPersonnage() {
        // On va vers le choix de carte methode.
        MethodeFragment newFragment = new MethodeFragment();
        setFragment(newFragment, true);
    }

    public void choisirMethode(View view) {
        // On va vers le choix de la réponse.
        ReponseFragment newFragment = new ReponseFragment();
        setFragment(newFragment, true);
    }

    public void choisirReponse(View view) {
        // On va vers le choix d'un nouveau template.
        // Il faudrait refaire une IHM entre les deux nn ?
        TemplateFragment newFragment = new TemplateFragment();
        setFragment(newFragment, true);
    }

    // On laisse pour le moment le fait de changer d'activité car la carte ne reprend rien du reste.
    public void voirMap(View view) {
        // map = new MapActivity(this);
        startActivity(intentMap);
    }



}
