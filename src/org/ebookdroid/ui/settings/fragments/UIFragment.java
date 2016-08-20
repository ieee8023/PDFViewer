package org.ebookdroid.ui.settings.fragments;


import android.annotation.TargetApi;
import free.pdfviewer.R;

@TargetApi(11)
public class UIFragment extends BasePreferenceFragment {
    public UIFragment() {
        super(R.xml.fragment_ui);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateUISettings();
    }
}
