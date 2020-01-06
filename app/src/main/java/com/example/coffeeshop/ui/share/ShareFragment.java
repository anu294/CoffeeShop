package com.example.coffeeshop.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.coffeeshop.R;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;
    TextView txt_help_gest;
    TextView txt_help_gest2;
    TextView txt_help_gest3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
//        final TextView textView = root.findViewById(R.id.text_share);
//        shareViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        txt_help_gest = (TextView) root.findViewById(R.id.txt_help_gest);
        txt_help_gest.setVisibility(View.GONE);
        TextView tv = (TextView) root.findViewById(R.id.title_txt_help_gest);
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_more_24dp, 0);
        //txt_help_gest.setCompoundDrawablePadding(8);
        txt_help_gest2 = (TextView) root.findViewById(R.id.txt_help_gest2);
        txt_help_gest2.setVisibility(View.GONE);
        tv = (TextView) root.findViewById(R.id.title_txt_help_gest2);
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_more_24dp, 0);
        txt_help_gest3 = (TextView) root.findViewById(R.id.txt_help_gest3);
        txt_help_gest3.setVisibility(View.GONE);
        tv = (TextView) root.findViewById(R.id.title_txt_help_gest3);
        tv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_expand_more_24dp, 0);
        return root;
    }
}