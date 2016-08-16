package org.ebookdroid.ui.library.adapters;

import org.emdev.ui.adapters.BaseViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import the.pdfviewerx.R;

public class ViewHolder extends BaseViewHolder {

    TextView name;
    ImageView imageView;
    TextView info;
    TextView fileSize;

    @Override
    public void init(final View convertView) {
        super.init(convertView);
        name = (TextView) convertView.findViewById(R.id.recentItemName);
        imageView = (ImageView) convertView.findViewById(R.id.recentItemIcon);
        info = (TextView) convertView.findViewById(R.id.recentItemInfo);
        fileSize = (TextView) convertView.findViewById(R.id.recentItemfileSize);
    }
}