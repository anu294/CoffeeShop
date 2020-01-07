package com.example.coffeeshop;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import com.example.coffeeshop.ui.home.HomeFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Button[][] buttons = new Button[3][3];
    private GoogleMap mMap;
    private Toast toast;
    private AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set no navigation bar
        View overlay = findViewById(R.id.drawer_layout);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery,
                //R.id.nav_slideshow,
                R.id.nav_location,
               // R.id.nav_tools,
                R.id.nav_share,
                R.id.nav_send,
                R.id.nav_help
                        )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

   /* @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            |View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         //Inflate the menu; //this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void onClick(View v) {
        if (((Button) v).getContentDescription()!=null) {
            return;
        }
        Button btn = (Button) findViewById(v.getId());
        String a = btn.getTag().toString();
        Integer b = Integer.parseInt(a);
        //if(x!=0 && (Button) findViewById("button_"+((x-1)%10<3?(x-1):((x/10-1)*10+x%10))));
        Integer pos = b/10*3 + b%10;
        String buttonID = "button_" + (pos-1)/3 + (pos-1)%3;
        int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
        Drawable i = ((Button) v).getBackground();
        if(pos==0 || ((Button) findViewById(resID)).getContentDescription()=="O") {
            ((Button) v).setText("");
            ((Button) v).setContentDescription("O");
            //((Button) v).setText(""+(b/10*3 + b%10+1));
            ((Button) v).setTextSize(30);
            //((Button) v).setBackgroundColor(Color.BLUE);
            ((Button) v).setBackgroundResource(R.mipmap.ic_star_background); //Color(Color.parseColor("#ff99cc00"));
            //((Button) v).setTextColor(Color.GREEN);
            if(pos==8){//pos==8
                //Toast.makeText(this, "Task Completed!", Toast.LENGTH_SHORT).show();
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast,
                        (ViewGroup) findViewById(R.id.custom_toast_container));
                toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
            }
        }else{
//            LayoutInflater inflater = getLayoutInflater();
//            View layout = inflater.inflate(R.layout.error_toast,
//                    (ViewGroup) findViewById(R.id.error_toast_container));
//
//            TextView text = (TextView) layout.findViewById(R.id.text);
//            text.setText("Complete the previous task.");
//
//            toast = new Toast(getApplicationContext());
//            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//            toast.setDuration(Toast.LENGTH_SHORT);
//            toast.setView(layout);
//            toast.show();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            ViewGroup viewGroup = findViewById(R.id.error_toast_container);
            View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.error_toast, viewGroup, false);
            builder.setView(dialogView);
            alertDialog = builder.create();
            alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            alertDialog.show();
            alertDialog.setCanceledOnTouchOutside(true);
            //alertDialog.setCancelable(true);
        }
    }
    public void onResetClick(View v) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setBackgroundResource(R.drawable.button_bg_stroke);
                buttons[i][j].setContentDescription(null);
                buttons[i][j].setText("");
                if(i==0 && j==0){
                    buttons[0][0].setText("START");
                    buttons[0][0].setTextSize(20);
                }
                if(i==2 && j==2){
                    buttons[2][2].setText("END");
                    buttons[2][2].setTextSize(20);
                }
                //buttons[i][j].setOnClickListener(this);
            }
        }
    }
    public void toggle_contents(View v){
        String answerTag = v.getTag().toString();
        TextView txt_help_gest = (TextView) findViewById(getResources().getIdentifier(answerTag, "id", getPackageName()));
        TextView title_txt_help_gest = (TextView) findViewById(getResources().getIdentifier("title_"+answerTag, "id", getPackageName()));
        txt_help_gest.setVisibility( txt_help_gest.isShown()
                ? View.GONE
                : View.VISIBLE );
        title_txt_help_gest.setCompoundDrawablesWithIntrinsicBounds(0, 0, txt_help_gest.isShown()
                ? R.drawable.ic_expand_less_24dp
                : R.drawable.ic_expand_more_24dp, 0);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                // User chose the "Settings" item, show the app settings UI...
                //                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                HomeFragment HomeFragment = new HomeFragment();
                FragmentManager fragMgr = getSupportFragmentManager();
                androidx.fragment.app.FragmentTransaction fragTrans = fragMgr.beginTransaction();
                fragTrans.replace(R.id.nav_host_fragment,//,nav_host_fragment
                        HomeFragment
                );
                fragTrans.addToBackStack(null);
                fragTrans.setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragTrans.commit();
//                NavController navController = Navigation.findNavController((Activity)view.getContext(), R.id.nav_host_fragment);
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                NavigationView navigationView = findViewById(R.id.nav_view);
                navigationView.getCheckedItem().setChecked(false);

                getSupportActionBar().setTitle("Home");
                navigationView.getMenu().getItem(0).setChecked(true);
//                NavController nv=Navigation.findNavController(view);
//                nv.navigate(R.id.home_fragment);
                //setNavDrawer();
//                NavController navController = Navigation.findNavController((Activity) view.getContext(), R.id.nav_host_fragment);
//                boolean a =NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                        || MainActivity.super.onSupportNavigateUp();

                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    public void closeErrorMsg(View v){
        //toast.cancel();
        alertDialog.dismiss();
    }
}
