package org.lamport.tla.toolbox;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * This workbench advisor creates the window advisor, and specifies
 * the perspective id for the initial window.
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {
	
    public static final String PERSPECTIVE_ID = "org.lamport.tla.toolbox.ui.perspective.initial";

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }

	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
	
	public IAdaptable getDefaultPageInput() {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        return workspace.getRoot();
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.application.WorkbenchAdvisor#initialize(org.eclipse.ui.application.IWorkbenchConfigurer)
     */

	/*
    // REMOVE: only required for the navigator, will be removed	
    public void initialize(IWorkbenchConfigurer configurer)
    {

        super.initialize(configurer);
        // do not save the positions of windows etc...
        // configurer.setSaveAndRestore(true);
        

        WorkbenchAdapterBuilder.registerAdapters();

        final String ICONS_PATH = "icons/full/";
        final String PATH_OBJECT = ICONS_PATH + "obj16/";
        Bundle ideBundle = Platform.getBundle(IDEWorkbenchPlugin.IDE_WORKBENCH);
        declareWorkbenchImage(configurer, ideBundle,
                IDE.SharedImages.IMG_OBJ_PROJECT, PATH_OBJECT + "prj_obj.gif",
                true);
        declareWorkbenchImage(configurer, ideBundle,
                IDE.SharedImages.IMG_OBJ_PROJECT_CLOSED, PATH_OBJECT
                        + "cprj_obj.gif", true);
        
        
    }
    private void declareWorkbenchImage(IWorkbenchConfigurer configurer_p,
            Bundle ideBundle, String symbolicName, String path, boolean shared) {
        URL url = ideBundle.getEntry(path);
        ImageDescriptor desc = ImageDescriptor.createFromURL(url);
        configurer_p.declareImage(symbolicName, desc, shared);
    }
*/
}
