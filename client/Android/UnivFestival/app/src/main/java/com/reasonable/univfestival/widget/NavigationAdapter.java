package com.reasonable.univfestival.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.github.ksoichiro.android.observablescrollview.CacheFragmentStatePagerAdapter;
import com.reasonable.univfestival.UniversityListFragment;

/**
 * Created by jkimab on 2017. 4. 22..
 */
public class NavigationAdapter extends CacheFragmentStatePagerAdapter {

    private static final String[] TITLES = new String[]{"Applepie", "Butter Cookie", "Cupcake"};

    private int mScrollY;

    public NavigationAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setScrollY(int scrollY) {
        mScrollY = scrollY;
    }

    @Override
    protected Fragment createItem(int position) {
        UniversityListFragment f;
        switch (position) {
            case 0: {
                f = new UniversityListFragment();
                break;
            }
            case 1: {
                f = new UniversityListFragment();
                break;
            }
            case 2:
            default: {
                f = new UniversityListFragment();
                break;
            }
        }
        return f;
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
