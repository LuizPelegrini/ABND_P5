package com.example.android.abnd_p5;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = findViewById(R.id.view_pager);
        FragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this);
        pager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.categories_tab_layout);
        tabLayout.setupWithViewPager(pager);
    }
}
