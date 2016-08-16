package the.pdfviewerx;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.ebookdroid.common.cache.CacheManager;
import org.ebookdroid.common.cache.ThumbnailFile;
import org.ebookdroid.common.settings.books.Bookmark;
import org.ebookdroid.ui.library.MainActivityController;
import org.ebookdroid.ui.library.RecentActivityController;
import org.emdev.common.android.AndroidVersion;
import org.emdev.ui.AbstractActionActivity;
import org.emdev.ui.adapters.BaseViewHolder;
import org.emdev.ui.uimanager.IUIManager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings.SettingNotFoundException;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AbstractActionActivity<MainActivity, MainActivityController> implements AdapterView.OnItemClickListener  {
	private final ThumbnailFile def = CacheManager.getThumbnailFile(".");
	private TextView batteryTxt;
	private String filePath; 
	private SeekBar seekBar;
	
	public MainActivity() {
		super(true, ON_CREATE, ON_RESUME);
	}

	@Override
	protected MainActivityController createController() {
		return new MainActivityController(this);
	}

	private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
		@Override
		public void onReceive(Context c, Intent i) {
			int level = i.getIntExtra("level", 0);
			ProgressBar pb = (ProgressBar) findViewById(R.id.progressbarBattery);
			pb.setProgress(level);
			TextView tv = (TextView )findViewById(R.id.textfieldBattery);
			tv.setText("Battery Level: "+Integer.toString(level)+"%");
		}
	};
	
	@Override
	protected void onStartImpl() {
		//batteryTxt = (TextView)findViewById(R.id.batteryLevel);
		//this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	}
	/**
     * {@inheritDoc}
     *
     * @see org.emdev.ui.AbstractActionActivity#onCreateImpl(android.os.Bundle)
     */
    @Override
    protected void onCreateImpl(final Bundle savedInstanceState) {
		Date today = new Date();
		String str_date = "16-05-27";
		DateFormat formatter;
		Date date = null;
		formatter = new SimpleDateFormat("dd-MM-yy");
		registerReceiver(mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
		
		try {
			date = formatter.parse(str_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(date == null || today.after(date)) {
			this.finish();
			System.exit(0);
		}

    	String path = getFileName();
    	String old_path = "/sdcard/Android/data/com.android.email/cache/No Limit Hold 'em Theory and Practice (David Sklansky, Ed Miller).pdf";
    	
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	
    	setContentView(R.layout.main_page_view);
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
    	this.filePath = "/sdcard/MainPDF/" + path;
        
    	if(!"".equals(path)) {
	        final ImageView currentView = (ImageView)findViewById(R.id.myImageView);
	        final ThumbnailFile newTF = CacheManager.getThumbnailFile(this.filePath);
	        currentView.setTag(newTF);
	
	        final Bitmap defImage = def.getImage();
	        newTF.loadImageAsync(defImage, new ThumbnailFile.ImageLoadingListener() {
	
	            @Override
	            public void onImageLoaded(final Bitmap image) {
	                if (image != null && currentView.getTag() == newTF) {
	                	currentView.setImageBitmap(image);
	                	currentView.postInvalidate();
	                }
	            }
	        });
	        
	        currentView.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	            	createController().showDocument(Uri.fromFile(new File(filePath)), (Bookmark)null);
	            }
	        });
	        
	        
	        
	        Button button = (Button) findViewById(R.id.myDeleteButton);

			button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					if(!"/sdcard/MainPDF/".equals(filePath) && !"".equals(filePath)) {
						File file = new File(filePath);
						file.delete();
						ImageView currentView2 = (ImageView)findViewById(R.id.myImageView);
						currentView2.invalidate();
					}
				}

			});
    	}
    	
    	getWindow().getDecorView().setSystemUiVisibility(
    	          View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    	        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    	        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    	        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    	        | View.SYSTEM_UI_FLAG_FULLSCREEN
    	        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    	
		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		seekBar.setMax(255);

		float curBrightnessValue = 0;
		
		try {
			curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
		} catch (SettingNotFoundException e) {
			e.printStackTrace();
		}

		int screen_brightness = (int) curBrightnessValue;
		seekBar.setProgress(screen_brightness);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int progress = 0;

			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				progress = progresValue;
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// Do something here,
				// if you want to do anything at the start of
				// touching the seekbar
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				android.provider.Settings.System.putInt(getContentResolver(),
						android.provider.Settings.System.SCREEN_BRIGHTNESS, progress);
			}
		});
    }
   
    
    private void toggleFullscreen(Activity activity, boolean fullscreen) {
        if (Build.VERSION.SDK_INT >= 11) {
            // The UI options currently enabled are represented by a bitfield.
            // getSystemUiVisibility() gives us that bitfield.
            int uiOptions = activity.getWindow().getDecorView().getSystemUiVisibility();
            int newUiOptions = uiOptions;
            boolean isImmersiveModeEnabled =
                    ((uiOptions | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY) == uiOptions);
           

            // Navigation bar hiding:  Backwards compatible to ICS.
            if (Build.VERSION.SDK_INT >= 14) {
                newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
            }

            // Status bar hiding: Backwards compatible to Jellybean
            if (Build.VERSION.SDK_INT >= 16) {
                newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
            }

            // Immersive mode: Backward compatible to KitKat.
            // Note that this flag doesn't do anything by itself, it only augments the behavior
            // of HIDE_NAVIGATION and FLAG_FULLSCREEN.  For the purposes of this sample
            // all three flags are being toggled together.
            // Note that there are two immersive mode UI flags, one of which is referred to as "sticky".
            // Sticky immersive mode differs in that it makes the navigation and status bars
            // semi-transparent, and the UI flag does not get cleared when the user interacts with
            // the screen.
            if (Build.VERSION.SDK_INT >= 18) {
                newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
        } else {
            // for android pre 11
            WindowManager.LayoutParams attrs = activity.getWindow().getAttributes();
            if (fullscreen) {
                attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            } else {
                attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
            }
            activity.getWindow().setAttributes(attrs);
        }

        

        // set landscape
       // if(fullscreen)  activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
       // else activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
    }
    

	private String getFileName() {
		File root = Environment.getExternalStorageDirectory();
		String rootPath= "";root.getPath();
		String masterFolderPath = rootPath + "/sdcard/MainPDF";
		File f = new File(masterFolderPath);
		File item = null;
		
		if(!f.isDirectory() && !f.exists()) {
			if(f.mkdir()) {
				item = findFile(masterFolderPath);
			} else {
				// TODO error popup
			}
		} else {
			item = findFile(masterFolderPath);
		}
		
		if(item == null) {
			return "";
		}
		
		return item.getName();
	}

	private File findFile(String masterFolderPath) {
		File f = new File(masterFolderPath);
		File[] files = f.listFiles();
		
		for(int i = 0; i < files.length; ++i) {
			if(files[i].getName().toLowerCase().contains("pdf")) {
				return files[i];
			}
		}
		
		return null;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		createController().showDocument(Uri.fromFile(new File(this.filePath)), (Bookmark)null);
		
	}
    
   
/*
    public void loadThumbnail(final String path, final ImageView imageView, final int defaultResID) {
        final ThumbnailFile newTF = CacheManager.getThumbnailFile(path);
        imageView.setTag(newTF);

        final Bitmap defImage = def.getImage();
        newTF.loadImageAsync(defImage, new ThumbnailFile.ImageLoadingListener() {

            @Override
            public void onImageLoaded(final Bitmap image) {
                if (image != null && imageView.getTag() == newTF) {
                    imageView.setImageBitmap(image);
                    imageView.postInvalidate();
                }
            }
        });
    }
/*/
}
