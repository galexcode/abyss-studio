/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.abyss.project.explorer.core;

import org.abyss.project.core.AbyssProject;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.nodes.AbstractNode;
import org.openide.util.Lookup;
import org.openide.util.Lookup.Result;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle.Messages;
import org.openide.util.Utilities;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.abyss.project.explorer.core//ProjectExplorer//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "ProjectExplorerTopComponent",
        //iconBase="SET/PATH/TO/ICON/HERE", 
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = false)
@ActionID(category = "Window", id = "org.abyss.project.explorer.core.ProjectExplorerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ProjectExplorerAction",
        preferredID = "ProjectExplorerTopComponent"
)
@Messages({
    "CTL_ProjectExplorerAction=ProjectExplorer",
    "CTL_ProjectExplorerTopComponent=Project Explorer",
    "HINT_ProjectExplorerTopComponent=This is a ProjectExplorer window"
})
public final class ProjectExplorerTopComponent extends TopComponent implements LookupListener {
    
    private final transient ExplorerManager explorerManager = new ExplorerManager();
    private Result result;

    public ProjectExplorerTopComponent() {
        initComponents();
        setName(Bundle.CTL_ProjectExplorerTopComponent());
        setToolTipText(Bundle.HINT_ProjectExplorerTopComponent());
        
        associateLookup(ExplorerUtils.createLookup(explorerManager, getActionMap()));
        //explorerManager.setRootContext(new AbstractNode(new CategoryChildren()));
        explorerManager.getRootContext().setDisplayName("Untitled Game");
        
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        moviePane = new BeanTreeView();

        setLayout(new java.awt.BorderLayout());
        add(moviePane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane moviePane;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void componentOpened() {
        System.err.println("Component opened");
        //result = Utilities.actionsGlobalContext().lookupResult(AbyssProject.class);
        result = Utilities.actionsGlobalContext().lookup(new Lookup.Template(AbyssProject.class));
        result.addLookupListener(this);
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
        result.removeLookupListener(this);
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    public ExplorerManager getExplorerManager() {
        return explorerManager;
    }

    @Override
    public void resultChanged(LookupEvent le) {
        System.err.println("Called resultChanged");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
