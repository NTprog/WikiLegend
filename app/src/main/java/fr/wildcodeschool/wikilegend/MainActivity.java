package fr.wildcodeschool.wikilegend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPagerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALIZATION VARIABLES

        viewPagerMenu = findViewById(R.id.View_Pager_Menu);
        ImageAdapterMenu imageAdapterMenu = new ImageAdapterMenu(this);

        Button fireButton = findViewById(R.id.fireButton);
        Button lightSpiritButton = findViewById(R.id.ButtonLightSPirit);
        Button turtleButton = findViewById(R.id.ButtonTurtle);
        Button pandaButton = findViewById(R.id.ButtonPanda);
        Button thunderButton = findViewById(R.id.ButtonThunder);
        Button rockillaButton = findViewById(R.id.ButtonRockilla);
        Button metalsaurButton = findViewById(R.id.ButtonMetalsaur);
        Button genieButton = findViewById(R.id.ButtonGenie);
        Button tyrannokingButton = findViewById(R.id.ButtonTyrannoking);
        Button randomButton = findViewById(R.id.randomButton);

        settingButton(fireButton, "fire_lion");
        settingButton(genieButton, "genie");
        settingButton(lightSpiritButton, "light_spirit");
        settingButton(metalsaurButton, "metalsaur");
        settingButton(pandaButton, "panda");
        settingButton(rockillaButton, "rockilla");
        settingButton(thunderButton, "thunder_eagle");
        settingButton(turtleButton, "turtle");
        settingButton(tyrannokingButton, "tyrannoking");

        settingRandomButton(randomButton);

        //SETTING TOP-SLIDER
        viewPagerMenu.setAdapter(imageAdapterMenu);
        onMainListenerSlider(viewPagerMenu);


    }



    //SETTING RANDOM BUTTON ALGO
    public static int getRandomIntegerBetweenRange(double min, double max){
        int x = (int) ((int)(Math.random()*((max-min)+1))+min);
        return x;
    }
    //SETTING CONDITION ON RAND BUTTON
    public String caseSet(){
        int rand = getRandomIntegerBetweenRange(1 , 9);
        String monster = null;

        switch (rand) {
            case 1:
                monster = "fire_lion";
                break;
            case 2:
                monster = "light_spirit";
                break;
            case 3:
                monster = "genie";
                break;
            case 4:
                monster = "panda";
                break;
            case 5:
                monster = "thunder_eagle";
                break;
            case 6:
                monster = "rockilla";
                break;
            case 7:
                monster = "metalsaur";
                break;
            case 8:
                monster = "turtle";
                break;
            case 9:
                monster = "tyrannoking";
                break;

        }
        return monster;
    }


    //SETTING ON CLICK ACTION ON RAND BUTTON

    public void settingRandomButton(Button button) {
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MonsterForm.class);
                intent.putExtra("monsterID", caseSet());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

        });

    }

    /*Setting a button wich open the MonsterForm Activity and send the "MonsterID" as extra.*/
    public void settingButton(Button button, final String monsterID) {
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

    /*Add a Listener on the view Pager, in order to know when user change the "evolution-level-page"*/
    public void onMainListenerSlider(final ViewPager viewPagerMenu) {

        viewPagerMenu.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                habitatSwitcher(position, viewPagerMenu);
            }
        });

    }

    /* Set a link in the top-slider, wich leads to MonsterForm Activity and send the monsterID as extra*/
    public void setViewPagerLink(ViewPager viewPagerMenu, final String monsterID) {

        viewPagerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MonsterForm.class);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                intent.putExtra("monsterID", monsterID);
                startActivity(intent);


            }
        });
    }

    /* For each monster, change the habitat in the top-slider */
    public void habitatSwitcher(int indexEvolution, ViewPager viewPagerMenu) {

        //Initialazing Variable
        ImageView habitat = findViewById(R.id.habitat_menu);

        //Setting habitat
        if (indexEvolution == 0) {
            habitat.setImageResource(R.drawable.fire_lion_habitat);
            setViewPagerLink(viewPagerMenu, "fire_lion");
        }

        if (indexEvolution == 1) {
            habitat.setImageResource(R.drawable.genie_habitat);
            setViewPagerLink(viewPagerMenu, "genie");
        }

        if (indexEvolution == 2) {
            habitat.setImageResource(R.drawable.light_spirit_habitat);
            setViewPagerLink(viewPagerMenu, "light_spirit");
        }

        if (indexEvolution == 3) {
            habitat.setImageResource(R.drawable.metalsaur_habitat);
            setViewPagerLink(viewPagerMenu, "metalsaur");
        }

        if (indexEvolution == 4) {
            habitat.setImageResource(R.drawable.panda_habitat);
            setViewPagerLink(viewPagerMenu, "panda");
        }

        if (indexEvolution == 5) {
            habitat.setImageResource(R.drawable.rockilla_habitat);
            setViewPagerLink(viewPagerMenu, "rockilla");
        }

        if (indexEvolution == 6) {
            habitat.setImageResource(R.drawable.thunder_eagle_habitat);
            setViewPagerLink(viewPagerMenu, "thunder_eagle");
        }

        if (indexEvolution == 7) {
            habitat.setImageResource(R.drawable.turtle_habitat);
            setViewPagerLink(viewPagerMenu, "turtle");
        }

        if (indexEvolution == 8) {
            habitat.setImageResource(R.drawable.tyrannoking_habitat);
            setViewPagerLink(viewPagerMenu, "tyrannoking");
        }

    }

}
