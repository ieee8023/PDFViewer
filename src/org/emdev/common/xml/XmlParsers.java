package org.emdev.common.xml;


import org.emdev.BaseDroidApp;
import org.emdev.utils.enums.ResourceConstant;

import the.pdfviewer3.R;

public enum XmlParsers implements ResourceConstant {

    /**
     *
     */
    VTDEx(R.string.pref_fb2_xmlparser_vtd_ex),
    /**
     *
     */
    Duckbill(R.string.pref_fb2_xmlparser_duckbill);

    private final String resValue;

    private XmlParsers(final int resId) {
        this.resValue = BaseDroidApp.context.getString(resId);
    }

    @Override
    public String getResValue() {
        return resValue;
    }

}
