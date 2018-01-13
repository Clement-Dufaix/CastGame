package pts3.castgame.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import pts3.castgame.R;

public class HelpActivity extends AppCompatActivity {

    private ImageButton bBack;
    private TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        bBack = findViewById(R.id.b_back_help);
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        TextView link = (TextView) findViewById(R.id.help_text2);
        link.setMovementMethod(LinkMovementMethod.getInstance());


    }



}