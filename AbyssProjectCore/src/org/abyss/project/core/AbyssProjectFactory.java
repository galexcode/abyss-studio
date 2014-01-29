/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.abyss.project.core;

import java.io.IOException;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author dan
 */
@ServiceProvider(service=ProjectFactory.class)
public class AbyssProjectFactory implements ProjectFactory {
    public static final String PROJECT_FILE = "project.abyss";
    
    public AbyssProjectFactory() {
    }
    
    @Override
    public boolean isProject(FileObject fo) {
        return fo.getFileObject(PROJECT_FILE) != null;
    }

    @Override
    public Project loadProject(FileObject dir, ProjectState state) throws IOException {
        return isProject(dir) ? new AbyssProject(dir, state) : null;
    }

    @Override
    public void saveProject(Project prjct) throws IOException, ClassCastException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
