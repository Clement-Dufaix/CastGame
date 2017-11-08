package pts3.castgame.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.common.api.GoogleApiClient;

import pts3.castgame.R;

public class MapActivity extends AppCompatActivity {

    boolean zoom=false;
    ImageView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getIntent();
        map = (ImageView) findViewById(R.id.imageMap);
        map.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector = new GestureDetector(MapActivity.this, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    Log.e("TEST", "x : "+e.getX()+", y : "+e.getY()+"");

                    if(zoom) {
                        map.setScaleX((float) (map.getScaleX() * 0.5));
                        map.setScaleY((float) (map.getScaleY() * 0.5));
                        map.setX(30);
                        map.setY(150);
                        // ...fdf
                        zoom=false;
                    }else{
                        map.setScaleX((float) (map.getScaleX() * 2));
                        map.setScaleY((float) (map.getScaleY() * 2));
                        map.setX(e.getX());
                        map.setY(e.getY());
                        zoom=true;
                    }

                    return super.onDoubleTap(e);
                }


            });

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("TEST", "Raw event: " + event.getAction() + ", (" + event.getRawX() + ", " + event.getRawY() + ")");
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }


    public void quitterCarte(View view) {
        //
    }
}
