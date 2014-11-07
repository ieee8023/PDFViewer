package the.pdfviewerx;


import android.annotation.TargetApi;
import android.content.res.Configuration;

import java.util.List;

import the.pdfviewerx.R;

@TargetApi(11)
public class FragmentedSettingsActivity extends SettingsActivity {

    @Override
    protected void onCreate() {
    }

    @Override
    public void onBuildHeaders(final List<Header> target) {
        loadHeadersFromResource(R.xml.preferences_headers, target);
    }

    @Override
    public boolean onIsMultiPane() {
        final Configuration c = this.getResources().getConfiguration();
        if (0 != (Configuration.SCREENLAYOUT_SIZE_XLARGE & c.screenLayout)) {
            return c.orientation == Configuration.ORIENTATION_LANDSCAPE;
        }
        return false;
    }
}
