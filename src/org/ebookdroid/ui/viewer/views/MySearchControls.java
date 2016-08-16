package org.ebookdroid.ui.viewer.views;


import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import org.emdev.ui.actions.ActionEx;
import org.emdev.ui.actions.MyActionEx;
import org.emdev.ui.actions.params.Constant;
import org.emdev.ui.actions.params.EditableValue;

import the.pdfviewerx.MyViewerActivity;
import the.pdfviewerx.R;
import the.pdfviewerx.ViewerActivity;

public class MySearchControls extends LinearLayout {

    private EditText m_edit;
    private ImageButton m_prevButton;
    private ImageButton m_nextButton;
    private MyViewerActivity parent;

    public MySearchControls(final MyViewerActivity myViewerActivity) {
        super(myViewerActivity);
        this.parent = myViewerActivity;
        setVisibility(View.GONE);
        setOrientation(LinearLayout.VERTICAL);

        LayoutInflater.from(myViewerActivity).inflate(R.layout.seach_controls, this, true);
        m_prevButton = (ImageButton) findViewById(R.id.search_controls_prev);
        m_nextButton = (ImageButton) findViewById(R.id.search_controls_next);
        m_edit = (EditText) findViewById(R.id.search_controls_edit);

        MyActionEx forwardSearch = myViewerActivity.getController().getOrCreateAction(R.id.actions_doSearch);
        MyActionEx backwardSearch = myViewerActivity.getController().getOrCreateAction(R.id.actions_doSearchBack);

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
}
