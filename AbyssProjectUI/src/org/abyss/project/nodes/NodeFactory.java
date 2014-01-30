/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.abyss.project.nodes;

import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.Node;

/**
 *
 * @author Dan Armstrong
 */
public class NodeFactory {
    
    public static Node getNode(FileObject fileObject) 
            throws DataObjectNotFoundException {
        if(fileObject.isFolder())
            return new DirectoryObjectNode(fileObject);
        return new FileObjectNode(fileObject);
    }
    
}
