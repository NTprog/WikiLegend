package fr.wildcodeschool.wikilegend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialazing variables

        Button fireButton =  findViewById(R.id.fireButton);
        Button lightSpiritButton = findViewById(R.id.ButtonLightSPirit);
        Button turtleButton = findViewById(R.id.ButtonTurtle);
        Button pandaButton = findViewById(R.id.ButtonPanda);
        Button thunderButton = findViewById(R.id.ButtonThunder);
        Button rockillaButton = findViewById(R.id.ButtonRockilla);
        Button metalsaurButton = findViewById(R.id.ButtonMetalsaur);
        Button genieButton = findViewById(R.id.ButtonGenie);
        Button tyrannokingButton = findViewById(R.id.ButtonTyrannoking);

        settingButton(fireButton, "fire_lion");
        settingButton(genieButton, "genie");
        settingButton(lightSpiritButton, "light_spirit");
        settingButton(metalsaurButton, "metalsaur");
        settingButton(pandaButton, "panda");
        settingButton(rockillaButton, "rockilla");
        settingButton(thunderButton, "thunder_eagle");
        settingButton(turtleButton, "turtle");
        settingButton(tyrannokingButton, "tyrannoking");

    }

    public void settingButton(Button button, final String monsterID){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MonsterForm.class);
                intent.putExtra("monsterID", monsterID);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

        });

    }

}