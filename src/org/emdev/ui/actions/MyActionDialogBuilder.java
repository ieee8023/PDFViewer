package org.emdev.ui.actions;


import android.app.AlertDialog;
import android.content.Context;

import org.emdev.utils.LengthUtils;

import the.pdfviewerx.R;

public class MyActionDialogBuilder extends AlertDialog.Builder {

    private final MyIActionController<?> actions;
    private final Context context;

    public MyActionDialogBuilder(final Context context, final MyIActionController<?> actions) {
        super(context);
        this.actions = actions;
        this.context = context;
    }

    public MyActionDialogBuilder setPositiveButton(final int resId, final int actionId, final IActionParameter... params) {
        final MyActionEx action = actions.getOrCreateAction(actionId);
        for (final IActionParameter ap : params) {
            action.addParameter(ap);
        }
        super.setPositiveButton(resId, action);
        return this;
    }

    public MyActionDialogBuilder setPositiveButton(final int actionId, final IActionParameter... params) {
        final MyActionEx action = actions.getOrCreateAction(actionId);
        for (final IActionParameter ap : params) {
            action.addParameter(ap);
        }
        super.setPositiveButton(android.R.string.ok, action);
        return this;
    }

    public MyActionDialogBuilder setNegativeButton() {
        super.setNegativeButton(android.R.string.cancel, actions.getOrCreateAction(R.id.actions_no_action));
        return this;
    }

    public MyActionDialogBuilder setNegativeButton(int resId) {
        super.setNegativeButton(resId, actions.getOrCreateAction(R.id.actions_no_action));
        return this;
    }

    public MyActionDialogBuilder setNegativeButton(final int resId, final int actionId, final IActionParameter... params) {
        final MyActionEx action = actions.getOrCreateAction(actionId);
        for (final IActionParameter ap : params) {
            action.addParameter(ap);
        }
        super.setNegativeButton(android.R.string.cancel, action);
        return this;
    }

    public MyActionDialogBuilder setMultiChoiceItems(final int itemsId, final int actionId, final boolean... checkedItems) {
        final MyActionEx action = actions.getOrCreateAction(actionId);
        super.setMultiChoiceItems(itemsId, LengthUtils.isNotEmpty(checkedItems) ? checkedItems : null, action);
        return this;
    }

    public MyActionDialogBuilder setMessage(final int msgId, final Object... args) {
        setMessage(context.getResources().getString(msgId, args));
        return this;
    }
}
