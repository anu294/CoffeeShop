package com.example.coffeeshop.ui.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.coffeeshop.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HelpFragment extends Fragment {

    private HelpViewModel helpViewModel;
    private ViewPager screenPager;
    IntroViewPageAdapter introViewPageAdapter;
    TabLayout tabIndicator;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        helpViewModel =
//                ViewModelProviders.of(this).get(HelpViewModel.class);
        View root = inflater.inflate(R.layout.fragment_help, container, false);
//        final TextView textView = root.findViewById(R.id.text_help);
//        helpViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        //init views
        tabIndicator = root.findViewById(R.id.tab_indicator);

        //fill List Screen
        List<ScreenItemHelp> mList = new ArrayList<>();
        mList.add(new ScreenItemHelp("Chill out", "Use maps to find us", R.drawable.img2));
        mList.add(new ScreenItemHelp("Reserve seats", "Yoyaku on your card", R.drawable.img1));
        mList.add(new ScreenItemHelp("Hotto Beverage", "Maintain your cafe gallery", R.drawable.img3));

        //setup tablayout
        screenPager = root.findViewById(R.id.screen_viewpager);
        introViewPageAdapter = new IntroViewPageAdapter(root.getContext(),mList);
        screenPager.setAdapter(introViewPageAdapter);

        //setup tablayout with viewpager
        tabIndicator.setupWithViewPager(screenPager);

        return root;



    }
}