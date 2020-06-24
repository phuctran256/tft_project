package com.example.finalapptft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.finalapptft.Adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        addTab(viewPager);

        ((TabLayout) findViewById(R.id.tabLayout)).setupWithViewPager(viewPager);
    }

    public void addTab(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.add(new FragmentOne(),"Tướng");
        adapter.add(new FragmentTwo(),"Đội Hình");
        adapter.add(new FragmentThree(),"Trang Bị");
        viewPager.setAdapter(adapter);
    }

}