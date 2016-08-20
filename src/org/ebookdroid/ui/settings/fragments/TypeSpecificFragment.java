package org.ebookdroid.ui.settings.fragments;


import android.annotation.TargetApi;
import free.pdfviewer.R;

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
