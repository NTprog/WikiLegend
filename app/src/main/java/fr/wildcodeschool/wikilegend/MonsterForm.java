package fr.wildcodeschool.wikilegend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;




    public class MonsterForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_form);


        //Initialazing variables
        String monsterID = getIntent().getStringExtra("monsterID");
        ViewPager viewPager = findViewById(R.id.viewPager);

        //Creating the page
        settingImageSlider(viewPager, monsterID);
        monsterBuilder(monsterID, 1, false);
        addListenerOnSlider(viewPager, monsterID);


    }

    public void settingImageSlider(ViewPager viewPager, String monsterID) {

        ImageAdapter adapter = new ImageAdapter(this, monsterID);
        viewPager.setAdapter(adapter);

    }

    //Add a Listener on the view Pager, in order to know when user change the "evolution-level-page"
    public void addListenerOnSlider(ViewPager viewPager, final String monsterID) {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                monsterBuilder(monsterID, position+1, false);
            }
        });

    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void monsterBuilder(String monsterID, int indexEvolution, boolean datasAlreadySet) {

        //INITIALISATION VARIABLES
        TextView name = findViewById(R.id.monster_name);
        TextView level = findViewById(R.id.monster_level);
        ImageView egg = findViewById(R.id.monster_egg);
        ImageView element = findViewById(R.id.monster_element);
        ImageView habitat = findViewById(R.id.monster_habitat);
        TextView life = findViewById(R.id.stat_life);
        TextView speed = findViewById(R.id.stat_speed);
        TextView power = findViewById(R.id.stat_power);
        TextView stamina = findViewById(R.id.stat_stamina);
        View circle = findViewById(R.id.myCircleView);

        String lifeStat = getResources().getString(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_life",
                "string",
                MonsterForm.this.getPackageName()));

        String speedStat = getResources().getString(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_speed",
                "string",
                MonsterForm.this.getPackageName()));

        String powerStat = getResources().getString(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_power",
                "string",
                MonsterForm.this.getPackageName()));

        String staminaStat = getResources().getString(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_stamina",
                "string",
                MonsterForm.this.getPackageName()));


        //Setting name
        name.setText(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_name",
                "string",
                MonsterForm.this.getPackageName()));

        //Setting egg
        egg.setImageResource(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_0",
                "drawable",
                MonsterForm.this.getPackageName()));

        //Setting element
        element.setImageResource(MonsterForm.this.getResources().getIdentifier(
                "bte_" + monsterID,
                "drawable",
                MonsterForm.this.getPackageName()));

        //Setting habitat
        habitat.setImageResource(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_habitat",
                "drawable",
                MonsterForm.this.getPackageName()));

        //Setting background circle
        circle.setBackgroundDrawable(ContextCompat.getDrawable(MonsterForm.this, MonsterForm.this.getResources().getIdentifier(
                "circle_"+ monsterID,
                "drawable",
                MonsterForm.this.getPackageName())) );


        //Setting level
        if(indexEvolution==1) {
            level.setText(R.string.level_1);

        } else if (indexEvolution==2) {
            level.setText(R.string.level_2);

        } else {
            level.setText(R.string.level_3);

        }

        //Setting Stats

        if(indexEvolution==1) {
            life.setText(lifeStat);
            speed.setText(speedStat);
            power.setText(powerStat);
            stamina.setText(staminaStat);

        } else if (indexEvolution==2) {
            life.setText(String.valueOf(Integer.parseInt(lifeStat)+23*4));
            speed.setText(String.valueOf(Integer.parseInt(speedStat)+23*4));
            power.setText(String.valueOf(Integer.parseInt(powerStat)+23*4));
            stamina.setText(String.valueOf(Integer.parseInt(staminaStat)+23*4));

        } else {
            life.setText(String.valueOf(Integer.parseInt(lifeStat)+23*7));
            speed.setText(String.valueOf(Integer.parseInt(speedStat)+23*7));
            power.setText(String.valueOf(Integer.parseInt(powerStat)+23*7));
            stamina.setText(String.valueOf(Integer.parseInt(staminaStat)+23*7));

        }


    }


}