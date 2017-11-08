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
import pts3.castgame.fragments.TemplateFragment;
import pts3.castgame.fragments.TypeJeuFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // J'ai crée une fonction générique pour ajouter nos Fragments plutôt que de dupliquer pour chaque possibilité.
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

    protected void choisirDifficulte(View view) {
        // On va vers le type de jeu.
        TypeJeuFragment newFragment = new TypeJeuFragment();
        setFragment(newFragment, true);
    }

    protected void choisirTypeJeu(View view) {
        // On va vers le choix de template.
        TemplateFragment newFragment = new TemplateFragment();
        setFragment(newFragment, true);
    }

    protected void choisirTemplate(View view) {
        // On va vers le choix de carte personnage.
        PersonnageFragment newFragment = new PersonnageFragment();
        setFragment(newFragment, true);
    }

    // Attention le nombre d'appels varie en fonction du template (1, 2 ou 3 personnages).
    protected void choisirPersonnage(View view) {
        // On va vers le choix de carte methode.
        MethodeFragment newFragment = new MethodeFragment();
        setFragment(newFragment, true);
    }

    protected void choisirMethode(View view) {
        // On va vers le choix de la réponse.
        ReponseFragment newFragment = new ReponseFragment();
        setFragment(newFragment, true);
    }

    protected void choisirReponse(View view) {
        // On va vers le choix d'un nouveau template.
        // Il faudrait refaire une IHM entre les deux nn ?
        TemplateFragment newFragment = new TemplateFragment();
        setFragment(newFragment, false);
    }

    // On laisse pour le moment le fait de changer d'activité car la carte ne reprend rien du reste.
    protected void voirMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

}
