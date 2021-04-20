package com.ericapp.scheduledemo;

import androidx.fragment.app.Fragment;

public class AffairListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new AffairListFragment();
    }
}
