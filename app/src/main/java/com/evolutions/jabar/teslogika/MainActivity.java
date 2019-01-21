package com.evolutions.jabar.teslogika;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

/*

Created By : Jabar Syahrial Reza
Tgl 10 Januari 2019

 */
public class MainActivity extends AppCompatActivity {
@BindView(R.id.toolbar)
Toolbar mToolbar;
@BindView(R.id.tab_layout)
    TabLayout mTablayout;
     @BindView(R.id.pager)
     ViewPager mViewPager;
     ViewPagerAdapter adapter;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(mToolbar);
        ButterKnife.bind(this);        /*Untuk mendeklarasikan view binding di dalam layout activity_main.xml */

         mTablayout.addTab(mTablayout.newTab().setText(R.string.tab_bilangan));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.tab_bangunan));
mTablayout.setTabGravity(TabLayout.GRAVITY_FILL);

adapter = new ViewPagerAdapter(getSupportFragmentManager(),mTablayout.getTabCount());

mViewPager.setAdapter(adapter);

mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayout));
mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }
    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
});

    }
}
