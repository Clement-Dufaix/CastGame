package pts3.castgame.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import pts3.castgame.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    private void showMenu() {
        long l = 1000;
        Timer timer = new Timer();
        timer.schedule(timerTask, l);
    }

    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {

        }
    };

    private void setActivity() {
        Transaction transaction = getSupportFragmentManager().beginTransaction();
        // On remplace l'ancien fragment par le nouveau.
}
