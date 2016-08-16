
package org.ebookdroid.ui.viewer;

import org.ebookdroid.common.settings.books.BookSettings;
import org.ebookdroid.core.DecodeService;
import org.ebookdroid.core.models.DecodingProgressModel;
import org.ebookdroid.core.models.DocumentModel;
import org.ebookdroid.core.models.MySearchModel;
import org.ebookdroid.core.models.SearchModel;
import org.ebookdroid.core.models.ZoomModel;

import android.app.Activity;
import android.content.Context;

import org.emdev.ui.actions.IActionController;
import org.emdev.ui.actions.MyIActionController;

import the.pdfviewerx.MyViewerActivity;
import the.pdfviewerx.ViewerActivity;

public interface MYIActivityController extends MyIActionController<MyViewerActivity> {

    Context getContext();

    Activity getActivity();

    BookSettings getBookSettings();

    DecodeService getDecodeService();

    DocumentModel getDocumentModel();

    MySearchModel getSearchModel();

    MyIView getView();

    IViewController getDocumentController();

    MyIActionController<?> getActionController();

    ZoomModel getZoomModel();

    DecodingProgressModel getDecodingProgressModel();

    void jumpToPage(int viewIndex, float offsetX, float offsetY, boolean addToHistory);

    void runOnUiThread(Runnable r);

}