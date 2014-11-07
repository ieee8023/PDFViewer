package org.ebookdroid.ui.settings.fragments;


import android.annotation.TargetApi;
import the.pdfviewerx.R;

@TargetApi(11)
public class BrowserFragment extends BasePreferenceFragment {

    public BrowserFragment() {
        super(R.xml.fragment_browser);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateBrowserSettings();
    }

}
