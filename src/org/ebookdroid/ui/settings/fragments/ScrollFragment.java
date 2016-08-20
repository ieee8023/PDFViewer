package org.ebookdroid.ui.settings.fragments;


import android.annotation.TargetApi;
import the.pdfviewer3.R;

@TargetApi(11)
public class ScrollFragment extends BasePreferenceFragment {

    public ScrollFragment() {
        super(R.xml.fragment_scroll);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateScrollSettings();
    }

}
