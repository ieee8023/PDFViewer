package org.ebookdroid.ui.settings.fragments;


import android.annotation.TargetApi;
import free.pdfviewer.R;

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
