package the.pdfviewerx;

import org.ebookdroid.ui.library.MainActivityController;
import org.ebookdroid.ui.viewer.WebBrowserActivityController;
import org.emdev.ui.AbstractActionActivity;

import android.app.Activity;
import android.os.Bundle;

public class WebBrowserActivity extends AbstractActionActivity<WebBrowserActivity, WebBrowserActivityController> {

	protected WebBrowserActivity(boolean shouldBeTaskRoot, int[] events) {
		super(shouldBeTaskRoot, events);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected WebBrowserActivityController createController() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
    protected void onCreateImpl(final Bundle savedInstanceState) {
		
	}
}
