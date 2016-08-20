package org.ebookdroid.ui.settings.fragments;


import android.annotation.TargetApi;
import the.pdfviewer3.R;

@TargetApi(11)
public class TypeSpecificFragment extends BasePreferenceFragment {

    public TypeSpecificFragment() {
        super(R.xml.fragment_typespec);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateTypeSpecificSettings();
    }
}
