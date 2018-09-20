package fr.wildcodeschool.wikilegend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPagerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String monsterID = getIntent().getStringExtra("monsterID");
        viewPagerMenu = findViewById(R.id.View_Pager_Menu);
        ImageAdapterMenu imageAdapterMenu = new ImageAdapterMenu(this);
        viewPagerMenu.setAdapter(imageAdapterMenu);
        onMainListenerSlider(viewPagerMenu);

        //Initialazing variables

        Button fireButton = findViewById(R.id.fireButton);
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

    //Add a Listener on the view Pager, in order to know when user change the "evolution-level-page"
    public void onMainListenerSlider(final ViewPager viewPagerMenu) {

        viewPagerMenu.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                sliderBuilder(position, viewPagerMenu);
            }
        });

    }

    public void setViewPagerLink(ViewPager viewPagerMenu, final String monsterID) {

        viewPagerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "ERROR EMPTY!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, MonsterForm.class);
                intent.putExtra("monsterID", monsterID);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


            }
        });
    }

    public void sliderBuilder(int indexEvolution, ViewPager viewPagerMenu) {

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
