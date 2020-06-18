package com.appstone.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        TabLayout mTabLayout = findViewById(R.id.tabs);
        ViewPager viewPager = findViewById(R.id.viewpager);

        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(viewPager);
    }
}