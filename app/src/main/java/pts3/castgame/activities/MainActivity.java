package pts3.castgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import pts3.castgame.R;
import pts3.castgame.fragments.TemplateFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void choisirDifficulte(View view) {

        TemplateFragment carteFragment = (TemplateFragment) getSupportFragmentManager().findFragmentById(R.id.frame_choix_template);

        TemplateFragment newFragment = new TemplateFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // On remplace l'ancien fragment par le nouveau.
        transaction.replace(R.id.fragment, newFragment);
        // transaction.addToBackStack();

        // On commit la transaction.
        transaction.commit();
    }

    /**
     * On laisse pour le moment le fait de changer d'activité car la carte ne reprend rien du reste.
     * (A voir)
     *
     * @param view
     */
    public void voirMap(View view) {
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }
}
