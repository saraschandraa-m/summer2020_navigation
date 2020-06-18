package com.appstone.navigation;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {


    private String[] titles;

    public TabPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        titles = context.getResources().getStringArray(R.array.fragment_titles);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        switch (position) {
            case 0:
                Bundle args = new Bundle();
                args.putString("LABEL", "ARCHIVE");
                fragment = new ArchiveFragment();
                fragment.setArguments(args);
                break;

            case 1:
                Bundle args1 = new Bundle();
                args1.putString("LABEL", "MARK AS IMPORTANT");
                fragment = new MarkAsFragment();
                fragment.setArguments(args1);
                break;

            case 2:
                Bundle args2 = new Bundle();
                args2.putString("LABEL", "MOVE TO INBOX");
                fragment = new MoveToInboxFragment();
                fragment.setArguments(args2);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
