package pts3.castgame.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;

import pts3.castgame.R;

public class MapActivity extends AppCompatActivity {

    ImageView map;
    boolean isHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        isHard = getIntent().getBooleanExtra("isHard", false);
        map = (ImageView) findViewById(R.id.imageMap);
        PhotoView photoView = (PhotoView) map;
        if (!isHard)
            photoView.setImageResource(R.drawable.plateau_mode_facile);       //modifier le plateau est mode facile si
        else photoView.setImageResource(R.drawable.plateau_mode_difficile);

    }

    public void quitterCarte(View view) {
        onBackPressed();
    }

}