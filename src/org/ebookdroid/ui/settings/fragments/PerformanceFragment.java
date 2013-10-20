package org.ebookdroid.ui.settings.fragments;


import android.annotation.TargetApi;

import the.pdfviewer3.R;

@TargetApi(11)
public class PerformanceFragment extends BasePreferenceFragment {

    public PerformanceFragment() {
        super(R.xml.fragment_performance);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decoratePerformanceSettings();
    }
}
