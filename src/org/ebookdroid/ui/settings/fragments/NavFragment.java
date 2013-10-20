package org.ebookdroid.ui.settings.fragments;


import android.annotation.TargetApi;

import the.pdfviewer3.R;

@TargetApi(11)
public class NavFragment extends BasePreferenceFragment {
    public NavFragment() {
        super(R.xml.fragment_navigation);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateUISettings();
    }
}
