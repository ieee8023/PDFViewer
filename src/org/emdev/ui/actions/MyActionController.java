package org.emdev.ui.actions;

import org.ebookdroid.ui.viewer.IActivityController;
import org.ebookdroid.ui.viewer.MYIActivityController;
import org.ebookdroid.ui.viewer.dialogs.MyOutlineDialog;

/**
 * This class defines base features for action controller.
 * 
 * @param <ManagedComponent>
 *            manager GUI component class
 */
public class MyActionController<ManagedComponent> extends MyAbstractComponentController<ManagedComponent> {

    /**
     * Constructor
     * 
     * @param managedComponent
     *            managed component
     */
    public MyActionController(final ManagedComponent managedComponent) {
        this(null, managedComponent);
    }

    
    /**
     * Constructor.
     * 
     * @param parent
     *            the parent controller
     * @param managedComponent
     *            managed component
     */
    public MyActionController(final MyIActionController<?> parent, final ManagedComponent managedComponent) {
        super(parent, managedComponent);
    }

	
    
}
