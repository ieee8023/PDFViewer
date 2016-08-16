package org.ebookdroid.ui.viewer.stubs;

import org.ebookdroid.common.settings.books.BookSettings;
import org.ebookdroid.core.DecodeService;
import org.ebookdroid.core.models.DecodingProgressModel;
import org.ebookdroid.core.models.DocumentModel;
import org.ebookdroid.core.models.MySearchModel;
import org.ebookdroid.core.models.SearchModel;
import org.ebookdroid.core.models.ZoomModel;
import org.ebookdroid.ui.viewer.IActivityController;
import org.ebookdroid.ui.viewer.IView;
import org.ebookdroid.ui.viewer.IViewController;
import org.ebookdroid.ui.viewer.MYIActivityController;
import org.ebookdroid.ui.viewer.MyIView;

import android.app.Activity;
import android.content.Context;

import org.emdev.ui.actions.ActionController;
import org.emdev.ui.actions.IActionController;
import org.emdev.ui.actions.IActionParameter;
import org.emdev.ui.actions.MyActionController;
import org.emdev.ui.actions.MyActionEx;
import org.emdev.ui.actions.MyIActionController;

import the.pdfviewerx.EBookDroidApp;
import the.pdfviewerx.MyViewerActivity;
import the.pdfviewerx.ViewerActivity;

public class MyActivityControllerStub extends MyActionController<MyViewerActivity> implements MYIActivityController {

    public static final MyActivityControllerStub STUB = new MyActivityControllerStub();

    public static final DocumentModel DM_STUB = new DocumentModel(null);

    public static final ZoomModel ZM_STUB = new ZoomModel();

    private MySearchModel SEARCH_STUB = new MySearchModel(this);

    MyActivityControllerStub() {
        super(null, null);
    }

    @Override
    public Context getContext() {
        return EBookDroidApp.context;
    }

    @Override
    public Activity getActivity() {
        return null;
    }

    @Override
    public DecodeService getDecodeService() {
        return null;
    }

    @Override
    public BookSettings getBookSettings() {
        return null;
    }

    @Override
    public DocumentModel getDocumentModel() {
        return DM_STUB;
    }

   
    @Override
    public IViewController getDocumentController() {
        return ViewContollerStub.STUB;
    }


    @Override
    public ZoomModel getZoomModel() {
        return ZM_STUB;
    }

    @Override
    public DecodingProgressModel getDecodingProgressModel() {
        return null;
    }

    @Override
    public void jumpToPage(final int viewIndex, final float offsetX, final float offsetY, final boolean addToHistory) {
    }


    @Override
    public void runOnUiThread(final Runnable r) {
    }

	@Override
	public MyIActionController<?> getMyParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyViewerActivity getManagedComponent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setManagedComponent(MyViewerActivity component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MyActionEx getAction(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyActionEx getOrCreateAction(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyActionEx createAction(int id, IActionParameter... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MySearchModel getSearchModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyIView getView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyIActionController<?> getActionController() {
		// TODO Auto-generated method stub
		return null;
	}
}
