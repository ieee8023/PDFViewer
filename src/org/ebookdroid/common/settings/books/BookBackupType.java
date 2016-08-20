package org.ebookdroid.common.settings.books;


import org.emdev.BaseDroidApp;
import org.emdev.utils.enums.ResourceConstant;

import free.pdfviewer.R;

public enum BookBackupType implements ResourceConstant {

    /**
     *
     */
    NONE(R.string.pref_bookbackuptype_none),
    /**
     *
     */
    RECENT(R.string.pref_bookbackuptype_recent),
    /**
     *
     */
    ALL(R.string.pref_bookbackuptype_all);

    public final String resValue;

    private BookBackupType(final int resId) {
        this.resValue = BaseDroidApp.context.getString(resId);
    }

    @Override
    public String getResValue() {
        return resValue;
    }
}
