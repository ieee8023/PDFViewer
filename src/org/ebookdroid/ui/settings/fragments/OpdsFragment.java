package org.ebookdroid.ui.settings.fragments;


import android.annotation.TargetApi;

import the.pdfviewer3.R;

@TargetApi(11)
public class OpdsFragment extends BasePreferenceFragment {

    public OpdsFragment() {
        super(R.xml.fragment_opds);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateOpdsSettings();
    }

}
