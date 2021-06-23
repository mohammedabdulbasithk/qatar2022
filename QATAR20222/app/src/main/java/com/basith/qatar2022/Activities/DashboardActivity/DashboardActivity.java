package com.basith.qatar2022.Activities.DashboardActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.basith.qatar2022.Activities.DashboardActivity.Fragments.HomeFragment;
import com.basith.qatar2022.Activities.DashboardActivity.Fragments.ProfileFragment;
import com.basith.qatar2022.Activities.DashboardActivity.Fragments.SecondFragment;
import com.basith.qatar2022.Activities.DashboardActivity.Fragments.TriviaFragment;
import com.basith.qatar2022.Helpers.BaseActivity;
import com.basith.qatar2022.R;
import com.skydoves.androidbottombar.AndroidBottomBarView;
import com.skydoves.androidbottombar.BottomMenuItem;
import com.skydoves.androidbottombar.OnMenuItemSelectedListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    Fragment fragment1;
    Fragment fragment2;
    Fragment fragment3;
    Fragment fragment4;

    final FragmentManager fragmentManager = getSupportFragmentManager();

    AndroidBottomBarView menu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        fragment1 = new HomeFragment(this);
        fragment2 = new SecondFragment(this);
        fragment3 = new TriviaFragment(this);
        fragment4 = new ProfileFragment(this);

        fragmentManager.beginTransaction().replace(R.id.containerview, fragment1).commit();

        menu = findViewById(R.id.menu);
        List<BottomMenuItem> bottomMenuItems = new ArrayList<>();
        bottomMenuItems.add(new BottomMenuItem(this)
                .setTitle("Home")
                .setIcon(R.drawable.ic_baseline_home_24)
                .setIconSize(25)
                .build());
        bottomMenuItems.add(new BottomMenuItem(this)
                .setTitle("Teams")
                .setIcon(R.drawable.ic_baseline_sports_soccer_24)
                .setIconSize(25)
                .build());
        bottomMenuItems.add(new BottomMenuItem(this)
                .setTitle("Trivia")
                .setIcon(R.drawable.ic_baseline_question_answer_24)
                .setIconSize(25)
                .build());
        bottomMenuItems.add(new BottomMenuItem(this)
                .setTitle("Profile")
                .setIcon(R.drawable.ic_baseline_account_circle_24)
                .setIconSize(25)
                .build());

        menu.addBottomMenuItems(bottomMenuItems);

        menu.setOnMenuItemSelectedListener(new OnMenuItemSelectedListener() {
            @Override
            public void onMenuItemSelected(int i, @NotNull BottomMenuItem bottomMenuItem, boolean b) {
                Fragment fragment;
                switch (i) {
                    case 0:
                        fragment = fragment1;
                        fragmentManager.beginTransaction().replace(R.id.containerview, fragment).commit();
                    case 1:
                        fragment = fragment2;
                        fragmentManager.beginTransaction().replace(R.id.containerview, fragment).commit();
                    case 2:
                        fragment = fragment3;
                        fragmentManager.beginTransaction().replace(R.id.containerview, fragment).commit();
                    case 3:
                        fragment = fragment4;
                        fragmentManager.beginTransaction().replace(R.id.containerview, fragment).commit();
                    default:
                        break;
                }
            }
        });


    }


}