package edu.huflit.ftracerproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import edu.huflit.ftracerproject.database.photo;

public class PhotoAdapter extends PagerAdapter {

    private Context mContext;
    private List<photo> mListPhoto;

    public PhotoAdapter(Context mContext, List<photo> mListPhoto) {
        this.mContext = mContext;
        this.mListPhoto = mListPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo,container,false);
        ImageView imgPhoto = view.findViewById(R.id.logo);

        photo photo = mListPhoto.get(position);
        if(photo != null){
            Glide.with(mContext).load(photo.getResourceId()).into(imgPhoto);
        }

        //ADD VIEW TO VIEWGROUP
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        if(mListPhoto != null)
        {
            return mListPhoto.size();
        }

        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // Remove view
        container.removeView((View) object);
    }
}
