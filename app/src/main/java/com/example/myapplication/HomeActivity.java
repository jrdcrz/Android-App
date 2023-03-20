package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.fragments.HomeFragment;
import com.example.myapplication.fragments.LeaderboardsFragment;
import com.example.myapplication.fragments.RewardsFragment;
import com.example.myapplication.fragments.SettingsFragment;
import com.example.myapplication.fragments.TaskFragment;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView menuBtn;
    private ImageView exitBtn;
    private RelativeLayout sidebar;
    private Animation slideInAnimation, slideOutAnimation;
    private TextView homeTab, taskTab, rewardsTab, leaderboardsTab, settingsTab, logoutTab;
    private List<TextView> tabs;

    private ScrollView scrollView2;

    public void onClick(View v){
        Fragment fragment;

        for (TextView tab : tabs) {
            if (tab.getId() == v.getId()) {
                tab.setTextColor(getResources().getColor(R.color.green));
                Toast.makeText(HomeActivity.this, tab.getText() + " Page", Toast.LENGTH_SHORT).show();
            } else {
                tab.setTextColor(getResources().getColor(R.color.black));
            }
        }

        switch (v.getId()){
            case R.id.home_tab:
                fragment = new HomeFragment();
                break;
            case R.id.task_tab:
                fragment = new TaskFragment();
                break;
            case R.id.rewards_tab:
                fragment = new RewardsFragment();
                break;
            case R.id.leaderboards_tab:
                fragment = new LeaderboardsFragment();
                break;
            case R.id.settings_tab:
                fragment = new SettingsFragment();
                break;
            case R.id.logout_tab:
                // Handle logout
                return;
            default:
                return;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        scrollView2.setVisibility(View.GONE);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //This is for the sidebar
        menuBtn = findViewById(R.id.menuBtn);
        exitBtn = findViewById(R.id.exitBtn);
        sidebar = findViewById(R.id.sidebar);
        //This handles the animation of opening and closing of sidebar
        slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in);
        slideOutAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out);

        scrollView2 = findViewById(R.id.scrollView2);

        homeTab = findViewById(R.id.home_tab);
        taskTab = findViewById(R.id.task_tab);
        rewardsTab = findViewById(R.id.rewards_tab);
        leaderboardsTab = findViewById(R.id.leaderboards_tab);
        settingsTab = findViewById(R.id.settings_tab);
        logoutTab = findViewById(R.id.logout_tab);

        tabs = Arrays.asList(homeTab, taskTab, rewardsTab, leaderboardsTab, settingsTab, logoutTab);

        for (TextView tab : tabs) {
            tab.setOnClickListener(this);
        }
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sidebar.setVisibility(View.VISIBLE);
                sidebar.startAnimation(slideInAnimation);
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sidebar.startAnimation(slideOutAnimation);
                sidebar.setVisibility(View.GONE);
            }
        });

        homeTab.performClick();
    }

}