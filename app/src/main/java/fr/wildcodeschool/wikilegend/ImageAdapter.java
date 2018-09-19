package fr.wildcodeschool.wikilegend;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageAdapter extends PagerAdapter {
    private Context mContext;


    private int[] mImageIds;


    //Constructor. Set different images for each monster when a new ImageAdapter is istantiated
     ImageAdapter(Context context, String monsterID){
        mContext = context;

        //CHANGE LES VISUELS DES MONSTRES
        if(monsterID.equals("fire_lion")) {

            mImageIds = new int []
                    {R.drawable.fire_lion_1,
                    R.drawable.fire_lion_2,
                    R.drawable.fire_lion_3};

        } else if(monsterID.equals("genie")) {

             mImageIds = new int []
                     {R.drawable.genie_1,
                             R.drawable.genie_2,
                             R.drawable.genie_3};

         }
        else if(monsterID.equals("light_spirit")) {

            mImageIds = new int []
                    {R.drawable.light_spirit_1,
                            R.drawable.light_spirit_2,
                            R.drawable.light_spirit_3};

        }
        else if(monsterID.equals("metalsaur")) {

            mImageIds = new int []
                    {R.drawable.metalsaur_1,
                            R.drawable.metalsaur_2,
                            R.drawable.metalsaur_3};

        }
        else if(monsterID.equals("panda")) {

            mImageIds = new int []
                    {R.drawable.panda_1,
                            R.drawable.panda_2,
                            R.drawable.panda_3};

        }
        else if(monsterID.equals("rockilla")) {

            mImageIds = new int []
                    {R.drawable.rockilla_1a,
                            R.drawable.rockilla_2a,
                            R.drawable.rockilla_3a};

        }
        else if(monsterID.equals("thunder_eagle")) {

            mImageIds = new int []
                    {R.drawable.thunder_eagle_1,
                            R.drawable.thunder_eagle_2,
                            R.drawable.thunder_eagle_3};

        }
        else if(monsterID.equals("turtle")) {

            mImageIds = new int []
                    {R.drawable.turtle_1,
                            R.drawable.turtle_2,
                            R.drawable.turtle_3};

        }
        else {

            mImageIds = new int []
                    {R.drawable.tyrannoking_1,
                            R.drawable.tyrannoking_2,
                            R.drawable.tyrannoking_3};

        }



        //FIN DE L'AJOUT

    }

    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView monster = new ImageView(mContext);
        monster.setScaleType(ImageView.ScaleType.FIT_CENTER);
        monster.setImageResource(mImageIds[position]);
        container.addView(monster, 0);


        return monster;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
