package pts3.castgame.activities;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.google.android.gms.common.api.GoogleApiClient;

import pts3.castgame.R;

public class MapActivity extends AppCompatActivity {

    MainActivity context;
    boolean zoom = false;
    ImageView map;
    boolean isHardMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // On récupère la difficulté depuis l'activité.
        isHardMode = getIntent().getBooleanExtra("isHardMode", false);
        map = (ImageView) findViewById(R.id.imageMap);
        PhotoView photoView = (PhotoView) map;
        if (!isHardMode)
            photoView.setImageResource(R.drawable.plateau_mode_facile);
        else photoView.setImageResource(R.drawable.plateau_mode_difficile);
    }

    public void quitterCarte(View view) {
        onBackPressed();
    }

}
