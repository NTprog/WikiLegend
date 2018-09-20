package fr.wildcodeschool.wikilegend;


import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


    public class MonsterForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_form);



        //Initialazing variables
        String monsterID = getIntent().getStringExtra("monsterID");
        ViewPager viewPager = findViewById(R.id.viewPager);

        View popUpPosition = findViewById(R.id.myCircleView);
        ImageView popUpButton = findViewById(R.id.popUpButton);

        //Creating the page
        settingImageSlider(viewPager, monsterID);
        settingPopUpWindow(popUpPosition, popUpButton, monsterID);
        monsterBuilder(monsterID, 1);
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
                monsterBuilder(monsterID, position+1);
            }
        });

    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void monsterBuilder(String monsterID, int indexEvolution) {

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

        //Setting roar

        final MediaPlayer mediaPlayer = MediaPlayer.create(MonsterForm.this, MonsterForm.this.getResources().getIdentifier(
                "scream_"+monsterID,
                "raw",
                MonsterForm.this.getPackageName()));
        //mediaPlayer.prepareAsync();
        mediaPlayer.setVolume(0.2f, 0.2f);

        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();

            }

        });



        //Setting infodescription


       /* popUpText.setText(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_information",
                "string",
                MonsterForm.this.getPackageName()));*/



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

    public void settingPopUpWindow (final View popUpPosition, ImageView popUpButton, final String monsterID) {

        popUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonShowPopupWindowClick(popUpPosition, monsterID);
            }

        });







    }

    public void onButtonShowPopupWindowClick(View view, String monsterID) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

            // create the popup window
            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            boolean focusable = true; // lets taps outside the popup also dismiss it
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

            // show the popup window
            // which view you pass in doesn't matter, it is only used for the window tolken
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

            //Recup popUpText and set it REVOIR ICI
            TextView popUpText = popupView.findViewById(R.id.pop_up);
            popUpText.setText(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_information",
                "string",
                MonsterForm.this.getPackageName()));


            // dismiss the popup window when touched
            popupView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    return true;
                }
            });
        }


}