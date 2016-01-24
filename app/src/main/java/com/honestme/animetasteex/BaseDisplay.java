package com.honestme.animetasteex;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public interface BaseDisplay {

    public boolean hasMainFragment();

    public boolean popUpStackFragments();

    public void showFragment(Fragment fragment);

    public void showFragmentWithDrawer(Fragment fragment);
}
