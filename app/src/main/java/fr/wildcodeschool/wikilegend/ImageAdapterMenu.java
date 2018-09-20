package fr.wildcodeschool.wikilegend;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ImageAdapterMenu extends PagerAdapter{

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.fire_lion_3 ,
    R.drawable.genie_3,
    R.drawable.light_spirit_3,
    R.drawable.metalsaur_3,
    R.drawable.panda_3,
    R.drawable.rockilla_3a,
    R.drawable.thunder_eagle_3,
    R.drawable.turtle_3,
    R.drawable.tyrannoking_3};


    public ImageAdapterMenu(Context context) {

        this.context = context;
    }



    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        String monsterID = "fire_lion";

        if (position == 0){
            monsterID = "fire_lion";
        }

        if (position == 1){
            monsterID = "genie";
        }

        if (position == 2){
            monsterID = "light_spirit";
        }

        if (position == 3){
            monsterID = "metalsaur";
        }

        if (position == 4){
            monsterID = "panda";
        }

        if (position == 5){
            monsterID = "rockilla";
        }

        if (position == 6){
            monsterID = "thunder_eagle";
        }

        if (position == 7){
            monsterID = "turtle";
        }

        if (position == 8){
            monsterID = "tyrannoking";
        }

        final String monsterId= monsterID;





        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        ViewPager vp = (ViewPager) container;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MonsterForm.class);
                intent.putExtra("monsterID", monsterId);
                context.startActivity(intent);
            }
        });
        vp.addView(imageView, 0);
        return imageView;

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }


}
