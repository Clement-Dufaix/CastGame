package pts3.castgame.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import pts3.castgame.R;
import pts3.castgame.fragments.AnswerCompanionFragment;
import pts3.castgame.fragments.CardFragment;
import pts3.castgame.fragments.GameStartFragment;
import pts3.castgame.fragments.GameTypeFragment;
import pts3.castgame.fragments.TemplateFragment;
import pts3.castgame.models.lien.FacadeMoteur;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent intentMap;
    FacadeMoteur facadeMoteur;

    private ImageButton bMap;

    private static final String FRAGMENT_TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        intentMap = new Intent(this, MapActivity.class);
        facadeMoteur = new FacadeMoteur();

        bMap = (ImageButton) findViewById(R.id.b_map);
        bMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentMap);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public FacadeMoteur getFacade() {
        return facadeMoteur;
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // On remplace l'ancien fragment par le nouveau.
        transaction.add(R.id.fragment_container, fragment);
        // On ajoute le fragment à la pile.
        transaction.addToBackStack(FRAGMENT_TAG);
        // On commit la transaction.
        transaction.commit();
    }

    /**
     * Applique la <b>difficulty</b> à la carte pour afficher le bon plateau,
     * et envoie vers le fragment suivant.
     *
     * @param difficulty La difficulté voulue
     */
    public void setDifficulty(String difficulty) {
        intentMap.putExtra("difficulty", difficulty);
        GameTypeFragment newFragment = new GameTypeFragment();
        setFragment(newFragment);
    }

    public void startNewGame() {
        GameStartFragment newFragment = new GameStartFragment();
        setFragment(newFragment);
    }

    public void loadNewTemplate() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Destruction de la pile.
        // Attention cela détruit tous les parents, dont le fragment de sélection de type de jeu.
        // On revient sur la sélection de difficulté en tant que fragment parent.
        // TODO Faire un vrai menu d'accueil, et voir si celui-ci deviendra le parent.
        fragmentManager.popBackStack(FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        TemplateFragment newFragment = new TemplateFragment();
        setFragment(newFragment);
    }

    /**
     * Charge le fragment de réponse pour le jeu compagnon.
     */
    public void loadFragmentCompanionAnswer() {
        AnswerCompanionFragment newFragment = new AnswerCompanionFragment();
        setFragment(newFragment);
    }

    /**
     * Sélectionne une carte, tant qu'il reste des cartes à sélectionner (voir dans le fragment associé).
     */
    public void setFragmentCardSelection() {
        CardFragment newFragment = new CardFragment();
        setFragment(newFragment);
    }


    // fonctions pour le menu deroulant
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_accueil) {
            // Handle the camera action
        } else if (id == R.id.nav_aide) {

        } else if (id == R.id.nav_giveup) {

        } else if (id == R.id.nav_exit) {

        } else if (id == R.id.nav_about) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
