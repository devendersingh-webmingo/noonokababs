package com.webmingo.oldjerusalemrestaurant.Adapters;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.webmingo.oldjerusalemrestaurant.ModelRepo.HomePageRepo;
import com.webmingo.oldjerusalemrestaurant.R;


public class SlidingImageAdapter extends PagerAdapter {
    HomePageRepo homePageRepo;

    private LayoutInflater layoutInflater;
    private Context context;

    //private SliderClick itemClickListenerr;


    public SlidingImageAdapter(HomePageRepo homePageRepo, Context context) {
        this.homePageRepo = homePageRepo;
        this.context = context;

       // this.itemClickListenerr = itemClickListenerr;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return homePageRepo.getData().getPromotionalBanners().size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.image_slider_layout_item, container, false);

        assert view != null;
        final ImageView imageView = (ImageView) view.findViewById(R.id.iv_auto_image_slider);
        final TextView titleTv = view.findViewById(R.id.titleTv);

        //  imageView.setImageResource(Images.get(position));
        //Picasso.get().load(homePageRepo.getData().getSliders().get(position).getLink()).into(imageView);
        Glide.with(context)
                .load(homePageRepo.getData().getImageBaseUrl() + homePageRepo.getData().getPromotionalBanners().get(position).getImage())
                .into(imageView);
        titleTv.setText(homePageRepo.getData().getPromotionalBanners().get(position).getName());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ///  itemClickListenerr.SliderClickk(homePageRepo, position);
            }
        });
        container.addView(view, 0);
        return view;
    }

    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
        super.restoreState(state, loader);
    }

    @Nullable
    @Override

    public Parcelable saveState() {
        return null;
    }

    public interface SliderClick {

        void SliderClickk(HomePageRepo repo, int pos);


    }
}
