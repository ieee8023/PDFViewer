package the.pdfviewerx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebViewActivity extends Activity {

	private WebView webView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		Intent intent = getIntent();
		String url = intent.getExtras().getString("url");
		
		webView = (WebView) findViewById(R.id.webView1);
		Button backButton = (Button)findViewById(R.id.my_back_button);
		
		webView.setWebViewClient(new WebViewClient() {
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            return false;
	        }
	    });
		
		class MyTouchListener implements View.OnTouchListener {
			private WebViewActivity act;
			
			public MyTouchListener(WebViewActivity act) {
				this.act = act;
			}
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				WebView webView =(WebView) findViewById(R.id.webView1);

				if (webView.canGoBack()) {
					webView.goBack();
					return true;
				} else {
					act.finish();
				}
				return false;
			}
			
		}
		
		backButton.setOnTouchListener(new MyTouchListener(this));
		
		
		
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(url);

	}
	
}