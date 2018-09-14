package fr.wildcodeschool.wikilegend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button fireButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fireButton = (Button) findViewById(R.id.fireButton);
        fireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMonsterForm();
            }

        });
    }

    public void openMonsterForm(){
        Intent intent = new Intent(this, MonsterForm.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}