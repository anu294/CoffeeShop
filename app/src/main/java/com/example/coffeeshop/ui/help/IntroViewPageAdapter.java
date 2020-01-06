package com.example.coffeeshop.ui.help;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.coffeeshop.R;

import java.util.List;

public class IntroViewPageAdapter extends PagerAdapter {

    Context mContext;
    List<ScreenItemHelp> mListScreensHelp;

    public IntroViewPageAdapter(Context mContext, List<ScreenItemHelp> mListScreensHelp) {
        this.mContext = mContext;
        this.mListScreensHelp = mListScreensHelp;
    }

    @Override
    public int getCount() {
        return mListScreensHelp.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screenshelp, null);
        ImageView imgSlide = layoutScreen.findViewById(R.id.intro_img);
        TextView title = layoutScreen.findViewById(R.id.intro_title);
        TextView description = layoutScreen.findViewById(R.id.intro_description);
        title.setText(mListScreensHelp.get(position).getTitle());
        description.setText(mListScreensHelp.get(position).getDescription());
        imgSlide.setImageResource(mListScreensHelp.get(position).getScreenImg());

        container.addView(layoutScreen);
        return layoutScreen;

    }
}
