/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.abyss.project.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.abyss.project.core.AbyssProjectFactory;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ui.OpenProjects;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Project",
        id = "org.abyss.project.actions.OpenProjectAction"
)
@ActionRegistration(
        iconBase = "org/abyss/project/icons/open.png",
        displayName = "#CTL_OpenProjectAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 0),
    @ActionReference(path = "Toolbars/File", position = 0)
})
@Messages("CTL_OpenProjectAction=Open Project")
public final class OpenProjectAction implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JFileChooser projectChooser = new JFileChooser();
            projectChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            projectChooser.showOpenDialog(null);
            File projectToBeOpenedFile = projectChooser.getSelectedFile();
            if(projectToBeOpenedFile != null) {
                FileObject projectToBeOpened = FileUtil.toFileObject(projectToBeOpenedFile);
                AbyssProjectFactory factory = new AbyssProjectFactory();
                Project project = factory.loadProject(projectToBeOpened, null);
                
                if(project == null) {
                    System.err.println("Project isn't valid!");
                } else {
                }
                //Project project = ProjectManager.getDefault().findProject(projectToBeOpened);
                Project[] array = new Project[1];
                array[0] = project;
                OpenProjects.getDefault().open(array, false);
                
                
            }

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
