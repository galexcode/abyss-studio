/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.abyss.project.nodes;

import java.util.ArrayList;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Lookup;

/**
 *
 * @author Dan Armstrong
 */
public class DirectoryObjectNode extends AbstractNode {

    private Node node;
    
    public DirectoryObjectNode(FileObject fileObject) 
            throws DataObjectNotFoundException {
        super(Children.LEAF);
        node = DataObject.find(fileObject).getNodeDelegate();
        
        ArrayList<Node> nodeList = new ArrayList<Node>();
        for (Node n: node.getChildren().getNodes()) {
            System.out.println("Add child!");
            nodeList.add(NodeFactory.getNode((n.getLookup().lookup(DataObject.class)).getPrimaryFile()));
        }
        Node[] childNodes = new Node[nodeList.size()];
        childNodes = nodeList.toArray(childNodes);
        
        getChildren().add(childNodes);
        
        setIconBaseWithExtension("org/abyss/project/icons/folder.png");
        setDisplayName(node.getDisplayName());
    }
    
    public DirectoryObjectNode(Children children) {
        super(children);
    }
    
    public DirectoryObjectNode(Children children, Lookup lookup) {
        super(children, lookup);
    }
    
}
