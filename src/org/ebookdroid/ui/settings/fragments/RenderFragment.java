package org.ebookdroid.ui.settings.fragments;


import android.annotation.TargetApi;

import the.pdfviewer3.R;

@TargetApi(11)
public class RenderFragment extends BasePreferenceFragment {

    public RenderFragment() {
        super(R.xml.fragment_render);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateRenderSettings();
    }
}
