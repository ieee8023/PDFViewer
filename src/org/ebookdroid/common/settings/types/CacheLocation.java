package org.ebookdroid.common.settings.types;


import org.emdev.utils.enums.ResourceConstant;

import the.pdfviewerx.EBookDroidApp;
import the.pdfviewerx.R;

public enum CacheLocation implements ResourceConstant {

    /**
     *
     */
    System(R.string.pref_cachelocation_system),
    /**
     *
     */
    Custom(R.string.pref_cachelocation_custom);

    private final String resValue;

    private CacheLocation(final int resId) {
        this.resValue = EBookDroidApp.context.getString(resId);
    }

    public String getResValue() {
        return resValue;
    }

}
