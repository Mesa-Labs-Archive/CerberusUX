package com.mesalabs.cerberus.base;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mesalabs.cerberus.R;
import com.mesalabs.cerberus.ui.widget.SwitchBar;
import com.mesalabs.cerberus.utils.LogUtils;
import com.samsung.android.ui.preference.SeslPreference;
import com.samsung.android.ui.preference.SeslPreferenceFragmentCompat;
import com.samsung.android.ui.preference.SeslPreferenceGroup;

/*
 * Cerberus Core App
 *
 * Coded by BlackMesa @2020
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * ULTRA-MEGA-PRIVATE SOURCE CODE. SHARING TO DEVKINGS TEAM
 * EXTERNALS IS PROHIBITED AND WILL BE PUNISHED WITH ANAL ABUSE.
 */

public class BaseSwitchBarActivity extends BaseAppBarActivity {
    protected FragmentManager mFragmentManager;
    protected SwitchBar switchBar;
    protected Fragment preferenceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mesa_baselayout_baseswitchbaractivity);

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.mesa_fragmentcontainer_baseswitchbaractivity, getFragment(), "root");
        transaction.commit();

        mFragmentManager.executePendingTransactions();

        preferenceFragment = mFragmentManager.findFragmentByTag("root");

        switchBar = findViewById(R.id.mesa_switchbar_baseswitchbaractivity);
        switchBar.setSwitchBarPressListener(getSwitchBarListener());
        switchBar.setChecked(getSwitchBarDefaultStatus());
    }

    @Override
    protected boolean getIsAppBarExpanded() {
        return false;
    }


    protected Fragment getFragment() {
        return null;
    }

    protected SwitchBar.SwitchBarPressListener getSwitchBarListener() {
        return null;
    }

    public boolean getSwitchBarDefaultStatus() {
        return false;
    }

    protected SeslPreferenceGroup getParent(SeslPreferenceGroup groupToSearchIn, SeslPreference preference) {
        for (int i = 0; i < groupToSearchIn.getPreferenceCount(); ++i) {
            SeslPreference child = groupToSearchIn.getPreference(i);

            if (child == preference)
                return groupToSearchIn;

            if (child instanceof SeslPreferenceGroup) {
                SeslPreferenceGroup childGroup = (SeslPreferenceGroup)child;
                SeslPreferenceGroup result = getParent(childGroup, preference);
                if (result != null)
                    return result;
            }
        }

        return null;
    }
}
