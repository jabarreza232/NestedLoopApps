package com.evolutions.jabar.teslogika;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int position;
    public ViewPagerAdapter(FragmentManager fm,int position) {
        super(fm);
        this.position = position;
    }

    @Override
    public Fragment getItem(int position) {
    switch (position) {
        case 0: //posisi tab pertama
            return new Bilangan(); //Nama Fragment tab Pertama yaitu Bilangan
        case 1: //posisi tab kedua
            return new BentukRumus(); //Nama Fragment tab Kedua yaitu Bentuk Rumus
            default:
          return null;
    }
    }

    @Override
    public int getCount() {
        return position;
    }
}
