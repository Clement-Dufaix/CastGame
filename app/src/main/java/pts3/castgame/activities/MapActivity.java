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
    String isDifficile="false";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        isDifficile = getIntent().getStringExtra("isDifficile");    //on récupère dans le main si le mode est en difficile
        Log.e("test ", isDifficile + "");
        map = (ImageView) findViewById(R.id.imageMap);
        PhotoView photoView = (PhotoView) findViewById(R.id.imageMap);  //photoview vient d'une librairie qui permet le zoom
        if (isDifficile!=null&&isDifficile.equals("false"))
            photoView.setImageResource(R.drawable.plateau_mode_facile);       //modifier le plateau est mode facile si
       else photoView.setImageResource(R.drawable.plateau_mode_difficile);

    }

    public void quitterCarte(View view) {
        onBackPressed();

    }
}
