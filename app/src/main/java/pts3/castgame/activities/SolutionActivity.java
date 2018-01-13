package pts3.castgame.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pts3.castgame.R;

public class SolutionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);
    }

    @Override
    public void onBackPressed() {
        // Bloquera le bouton de retour, on ne veut pas que le joueur puisse revenir sur ses choix.
        super.onBackPressed();
    }
}
