package org.ebookdroid.ui.library;

import java.io.File;

import org.ebookdroid.common.settings.books.Bookmark;
import org.emdev.ui.AbstractActivityController;

import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;
import the.pdfviewerx.BrowserActivity;
import the.pdfviewerx.MainActivity;
import the.pdfviewerx.MyViewerActivity;
import the.pdfviewerx.RecentActivity;
import the.pdfviewerx.ViewerActivity;

public class MainActivityController extends AbstractActivityController<MainActivity> implements IBrowserActivity {

	public MainActivityController(final MainActivity activity) {
        super(activity, BEFORE_CREATE, AFTER_CREATE, ON_RESUME, ON_DESTROY);

    }
	
	@Override
	public void showProgress(boolean show) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCurrentDir(File newDir) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void loadThumbnail(String path, ImageView imageView, int defaultResID) {
		// TODO Auto-generated method stub
		
	}

	@Override
    public void showDocument(final Uri uri, final Bookmark b) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setClass(getManagedComponent(), ViewerActivity.class);
        if (b != null) {
            intent.putExtra("pageIndex", "" + b.page.viewIndex);
            intent.putExtra("offsetX", "" + b.offsetX);
            intent.putExtra("offsetY", "" + b.offsetY);
        }
        getManagedComponent().startActivity(intent);
    }
}
