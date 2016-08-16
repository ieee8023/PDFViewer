package org.ebookdroid.ui.viewer.views;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.graphics.PorterDuff;

import org.emdev.ui.actions.ActionEx;
import org.emdev.ui.actions.params.Constant;
import org.emdev.ui.actions.params.EditableValue;

import the.pdfviewerx.R;
import the.pdfviewerx.ViewerActivity;

public class SearchControls extends LinearLayout {

    private EditText m_edit;
    private TextView m_page;
    private ImageButton m_prevButton;
    private ImageButton m_nextButton;
    private ViewerActivity parent;
    private SeekBar seekBar;

    public SearchControls(final ViewerActivity parent) {
        super(parent);
        this.parent = parent;
        setVisibility(View.GONE);
        setOrientation(LinearLayout.VERTICAL);

        LayoutInflater.from(parent).inflate(R.layout.seach_controls, this, true);
        m_prevButton = (ImageButton) findViewById(R.id.search_controls_prev);
        m_nextButton = (ImageButton) findViewById(R.id.search_controls_next);
        m_edit = (EditText) findViewById(R.id.search_controls_edit);
        m_page = (TextView) findViewById(R.id.search_controls_page_num );
        seekBar = (SeekBar) findViewById(R.id.seekBar2 );
        m_edit.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
        m_edit.setOnTouchListener(new OnTouchListener()
        {
        
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				m_edit.setSelection(m_edit.getText().toString().length());
				return false;
			}
        });
        
        
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int progress = 0;

			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				progress = progresValue;
				int count = parent.getController().getDocumentModel().getPageCount();
				seekBar.setMax(count);
				updatePageText(String.valueOf(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// Do something here,
				// if you want to do anything at the start of
				// touching the seekbar
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				parent.getController().getDocumentController().goToPage(progress);
			}
		});

        ActionEx forwardSearch = parent.getController().getOrCreateAction(R.id.actions_doSearch);
        ActionEx backwardSearch = parent.getController().getOrCreateAction(R.id.actions_doSearchBack);

        forwardSearch.addParameter(new EditableValue("input", m_edit)).addParameter(new Constant("forward", "true"));
        backwardSearch.addParameter(new EditableValue("input", m_edit)).addParameter(new Constant("forward", "false"));

        m_prevButton.setOnClickListener(backwardSearch);
        m_nextButton.setOnClickListener(forwardSearch);
        m_edit.setOnEditorActionListener(forwardSearch);
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == VISIBLE) {
            m_edit.requestFocus();
            parent.showKeyboard();
        }
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        return false;
    }

    public int getActualHeight() {
        return m_edit.getHeight();
    }
    
    public void updatePageText(String text) {
    	m_page.setText(text);
    }
}
