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
        isDifficile = getIntent().getStringExtra("isDifficile");
        Log.e("test ", isDifficile + "");
        map = (ImageView) findViewById(R.id.imageMap);
        PhotoView photoView = (PhotoView) findViewById(R.id.imageMap);
        if (isDifficile!=null&&isDifficile.equals("false"))
            photoView.setImageResource(R.drawable.plateau_mode_facile);       //modifier le plateau est mode facile
       else photoView.setImageResource(R.drawable.plateau_mode_difficile);



//        if (isDifficile!=null&&isDifficile.equals("false"))
//            map.setBackgroundResource(R.drawable.plateau_mode_facile);       //modifier le plateau est mode facile
//        map.setOnTouchListener(new View.OnTouchListener() {
//            private GestureDetector gestureDetector = new GestureDetector(MapActivity.this, new GestureDetector.SimpleOnGestureListener() {
//                @Override
//                public boolean onDoubleTap(MotionEvent e) {
//
//                    if (zoom) {
//                        map.setScaleX((float) (map.getScaleX() * 0.5));
//                        map.setScaleY((float) (map.getScaleY() * 0.5));
//                        map.setX(30);
//                        map.setY(150);
//                        zoom = false;
//                    } else {
//                        map.setX(map.getX() + map.getWidth() - e.getX() * 2);
//                        map.setY(map.getY() + map.getHeight() - e.getY() * 2);
//                        map.setScaleX((float) (map.getScaleX() * 2));
//                        map.setScaleY((float) (map.getScaleY() * 2));
//
//                        zoom = true;
//                    }
//                    Log.e("Coordonnée image", "x : " + map.getX() + ", y : " + map.getY() + "");
//                    return super.onDoubleTap(e);
//                }
//
//
//            });
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e("TEST", "Raw event: " + event.getAction() + ", (" + event.getRawX() + ", " + event.getRawY() + ")");
//                gestureDetector.onTouchEvent(event);
//                return true;
//            }
//        });
    }

    public void quitterCarte(View view) {
        onBackPressed();

    }
}
