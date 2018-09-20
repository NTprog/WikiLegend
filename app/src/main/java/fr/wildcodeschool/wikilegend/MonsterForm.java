package fr.wildcodeschool.wikilegend;




import android.content.Intent;
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
import android.widget.Toast;


public class MonsterForm extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_form);



        //Initialazing variables
        String monsterID = getIntent().getStringExtra("monsterID");
        ViewPager viewPager = findViewById(R.id.viewPager);
        //ViewPager viewPagerMenu = findViewById(R.id.View_Pager_Menu);


        View popUpPositionInfo = findViewById(R.id.myCircleView);
        ImageView popUpButtonInfo = findViewById(R.id.popUpButton);

        View popUpPositionElement = findViewById(R.id.monster_element);
        ImageView popUpButtonElement = findViewById(R.id.monster_element);

        //Creating the page
        settingImageSlider(viewPager, monsterID);
        settingPopUpInformation(popUpPositionInfo, popUpButtonInfo, monsterID); // setting information popup
        settingPopUpElement(popUpPositionElement, popUpButtonElement, monsterID); //setting element popup
        monsterBuilder(monsterID, 1);
        addListenerOnSlider(viewPager, monsterID);


        ImageView logoRetour = findViewById(R.id.logo);
        logoRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });
    }


        /*Start main Activity*/
        public void backToMain(){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }


        /*Set a ViewPager as a slider to witch between different evolutions of each monster*/
        public void settingImageSlider(ViewPager viewPager, String monsterID) {

        ImageAdapter adapter = new ImageAdapter(this, monsterID);
        viewPager.setAdapter(adapter);

    }

    /*Add a Listener on the slider, in order to know when user change the "evolution-level-page"
    * When he/she does, it triggers a monsterBuilder method.
    * */
    public void addListenerOnSlider(ViewPager viewPager, final String monsterID) {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {

                monsterBuilder(monsterID, position+1);
                dotBuilder(position+1);


            }
        });

    }
    public void dotBuilder (int dotIndex) {
        ImageView dot1 = findViewById(R.id.dot1);
        ImageView dot2 = findViewById(R.id.dot2);
        ImageView dot3 = findViewById(R.id.dot3);

        if (dotIndex == 1) {
            dot1.setImageResource(R.drawable.circle_white);
            dot2.setImageResource(R.drawable.circle_black);
            dot3.setImageResource(R.drawable.circle_black);

        } else if (dotIndex == 2) {
            dot1.setImageResource(R.drawable.circle_black);
            dot2.setImageResource(R.drawable.circle_white);
            dot3.setImageResource(R.drawable.circle_black);
        } else {
            dot1.setImageResource(R.drawable.circle_black);
            dot2.setImageResource(R.drawable.circle_black);
            dot3.setImageResource(R.drawable.circle_white);
        }

    }

    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    /*Build a different page for each monster and monster-evolution */
    public void monsterBuilder(String monsterID, int indexEvolution) {

        //INITIALISATION VARIABLES
        TextView name = findViewById(R.id.monster_name);
        TextView level = findViewById(R.id.monster_level);
        ImageView egg = findViewById(R.id.monster_egg);
        ImageView element = findViewById(R.id.monster_element);
        ImageView habitat = findViewById(R.id.habitat);
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

        //SETTING ROAR

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


        //SETTING NAME
        name.setText(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_name",
                "string",
                MonsterForm.this.getPackageName()));

        //SETTING EGG PICTO
        egg.setImageResource(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_0",
                "drawable",
                MonsterForm.this.getPackageName()));

        //SETTING ELEMENT PICTO
        element.setImageResource(MonsterForm.this.getResources().getIdentifier(
                "bte_" + monsterID,
                "drawable",
                MonsterForm.this.getPackageName()));

        //SETTING HABITAT
        habitat.setImageResource(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_habitat",
                "drawable",
                MonsterForm.this.getPackageName()));

        //SETTING BACKGROUNDCIRCLE
        circle.setBackgroundDrawable(ContextCompat.getDrawable(MonsterForm.this, MonsterForm.this.getResources().getIdentifier(
                "circle_"+ monsterID,
                "drawable",
                MonsterForm.this.getPackageName())) );

        //SETTING LEVEL
        if(indexEvolution==1) {
            level.setText(R.string.level_1);

        } else if (indexEvolution==2) {
            level.setText(R.string.level_2);

        } else {
            level.setText(R.string.level_3);

        }

        //SETTING STATS

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

    /*Set the "info button" listener */
    public void settingPopUpInformation (final View popUpPosition, ImageView popUpButton, final String monsterID) {

        popUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configurationPopUpInformation(popUpPosition, monsterID);
            }

        });

    }


    /*Set the PopUp Panel with a monster description adapted for each monster */
    public void configurationPopUpInformation(View view, String monsterID) {

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

            //Set a different text for each monster
            TextView popUpText = popupView.findViewById(R.id.pop_up);
            popUpText.setText(MonsterForm.this.getResources().getIdentifier(
                monsterID+"_information",
                "string",
                MonsterForm.this.getPackageName()));

            //Dismiss the popup window when touched
            popupView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    return true;
                }
            });
        }


        /*Set the PopUp Panel with a description of the element, adapted for each monster */
        public void configurationPopUpElement(View view, String monsterID) {

            // inflate the layout of the popup window
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup_element, null);

            // create the popup window
            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            boolean focusable = true; // lets taps outside the popup also dismiss it
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

            // show the popup window
            // which view you pass in doesn't matter, it is only used for the window tolken
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

            //Set a different text for each element
            TextView popUpElementFirstText = popupView.findViewById(R.id.pop_up_first_element_text);
            popUpElementFirstText.setText(MonsterForm.this.getResources().getIdentifier(
                    monsterID+"_element",
                    "string",
                    MonsterForm.this.getPackageName()));

            //Set a different text for each antagonist element
            TextView popUpElementSecondText = popupView.findViewById(R.id.pop_up_second_element_text);
            popUpElementSecondText.setText(MonsterForm.this.getResources().getIdentifier(
                    monsterID+"_antagonist_element",
                    "string",
                    MonsterForm.this.getPackageName()));


            //Set a different picto for each monster element
            ImageView popUpElementFirstImage = popupView.findViewById(R.id.pop_up_first_element_image);
            popUpElementFirstImage.setImageResource(MonsterForm.this.getResources().getIdentifier(
                    "bte_"+monsterID,
                    "drawable",
                    MonsterForm.this.getPackageName()));


            //Set a different picto for each antagonist monster element :

            String antagonistElement = "fire_lion_element";

            switch (monsterID)
            {
                case "fire_lion":
                    antagonistElement = "bte_panda";
                    break;
                case "genie":
                    antagonistElement = "bte_metalsaur";
                    break;
                case "light_spirit":
                    antagonistElement = "bte_tyrannoking";
                    break;
                case "metalsaur":
                    antagonistElement = "bte_light_spirit";
                    break;
                case "panda":
                    antagonistElement = "bte_genie";
                    break;
                case "rockilla":
                    antagonistElement = "bte_thunder_eagle";
                    break;
                case "thunder_eagle":
                    antagonistElement = "bte_turtle";
                    break;
                case "turtle":
                    antagonistElement = "bte_fire_lion";
                    break;
                case "tyrannoking":
                    antagonistElement = "bte_rockilla";
                    break;
                default:

            }

            ImageView popUpElementSecondImage = popupView.findViewById(R.id.pop_up_second_element_image);
            popUpElementSecondImage.setImageResource(MonsterForm.this.getResources().getIdentifier(
                    antagonistElement,
                    "drawable",
                    MonsterForm.this.getPackageName()));

            //Dismiss the popup window when touched
            popupView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    return true;
                }
            });
        }

        /*Set the "element button" listener */
        public void settingPopUpElement (final View popUpPosition, ImageView popUpButton, final String monsterID) {

            popUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    configurationPopUpElement(popUpPosition, monsterID);
                }

            });

        }

}