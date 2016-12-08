package com.example.aspirev15.newfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout=(TabLayout)findViewById(R.id.tabLayout);
        mViewPager=(ViewPager)findViewById(R.id.view_pager);
        final String[] title = new String[]{"New","Popular"};
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new NewFragments());
        fragments.add(new PopularFragment());
        ViewPageAdapter mViewPageAdapter=new ViewPageAdapter(getSupportFragmentManager(),title,fragments);
        mViewPager.setAdapter(mViewPageAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTitle(title[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

