/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.abyss.project.ui;

import java.io.File;
import org.abyss.project.nodes.NodeFactory;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.filesystems.FileUtil;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(
        dtd = "-//org.abyss.project.ui//FileSystemExplorer//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "FileSystemExplorerTopComponent",
        iconBase = "org/abyss/project/ui/folder.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "org.abyss.project.ui.FileSystemExplorerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_FileSystemExplorerAction",
        preferredID = "FileSystemExplorerTopComponent"
)
@Messages({
    "CTL_FileSystemExplorerAction=FileSystemExplorer",
    "CTL_FileSystemExplorerTopComponent=FileSystemExplorer Window",
    "HINT_FileSystemExplorerTopComponent=Opens projects from the disk."
})
public final class FileSystemExplorerTopComponent extends TopComponent 
    implements ExplorerManager.Provider, Lookup.Provider {

    private final transient ExplorerManager explorerManager = new ExplorerManager();
    
    public FileSystemExplorerTopComponent() {
        initComponents();
        setName(Bundle.CTL_FileSystemExplorerTopComponent());
        setToolTipText(Bundle.HINT_FileSystemExplorerTopComponent());
        
        
        associateLookup(ExplorerUtils.createLookup(explorerManager, getActionMap()));
        //((BeanTreeView)rootPane).setRootVisible(true);
        //explorerManager.setRootContext(Node.EMPTY);
        
        File paths[] = File.listRoots();
        for(File path: paths) {
            try {
                explorerManager.setRootContext(
                        DataObject.find(FileUtil.toFileObject(path)).getNodeDelegate()
                );
            } catch (DataObjectNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPane = new BeanTreeView();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane rootPane;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
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
}
