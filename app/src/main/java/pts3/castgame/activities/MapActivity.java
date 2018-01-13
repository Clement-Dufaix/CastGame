package pts3.castgame.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

import pts3.castgame.R;

public class MapActivity extends AppCompatActivity {

    private ImageView map;
    private ImageButton bBack;
    private TextView tMapSelection;
    String difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        tMapSelection = findViewById(R.id.t_map_selection);
        bBack = findViewById(R.id.b_back_map);
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        map = findViewById(R.id.imageMap);
        PhotoView photoView = (PhotoView) map;

        difficulty = getIntent().getStringExtra("difficulty");

        // Si aucune difficulté sélectionnée, pas de carte !
        if (difficulty == null) {
            // photoView.setImageResource(R.color.colorPrimary);
            tMapSelection.setVisibility(View.VISIBLE);
        } else {
            // Rend invisible et laisse la place libre pour la carte.
            tMapSelection.setVisibility(View.GONE);
            if (difficulty.equals("easy")) {
                photoView.setImageResource(R.drawable.plateau_mode_facile);
            } else {
                photoView.setImageResource(R.drawable.plateau_mode_difficile);
            }
        }
    }

}