package com.reasonable.univfestival.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.github.ksoichiro.android.observablescrollview.CacheFragmentStatePagerAdapter;
import com.reasonable.univfestival.UniversityFragment;

/**
 * Created by jkimab on 2017. 4. 22..
 */
public class NavigationAdapter extends CacheFragmentStatePagerAdapter {

    private static final String[] TITLES = new String[]{"한양대", "홍대", "이화여대", "가천대", "가톨릭대", "강남대"};

    private int mScrollY;

    public NavigationAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setScrollY(int scrollY) {
        mScrollY = scrollY;
    }

    @Override
    protected Fragment createItem(int position) {
        UniversityFragment f;
        switch (position) {
            case 0: {
                f = UniversityFragment.newInstance();
                break;
            }
            case 1: {
                f = UniversityFragment.newInstance();
                break;
            }
            case 2:
            default: {
                f = UniversityFragment.newInstance();
                break;
            }
        }
        f.setArguments(mScrollY);
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
