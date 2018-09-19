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
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);






        ViewPager vp = (ViewPager) container;
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
