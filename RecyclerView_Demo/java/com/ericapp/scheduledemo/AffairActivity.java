package com.ericapp.scheduledemo;

import androidx.fragment.app.Fragment;

public class AffairActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        // 放入哪个Fragment呢？
        return new AffairFragment();
    }
}