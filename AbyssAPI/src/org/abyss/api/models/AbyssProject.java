/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.abyss.api.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dan Armstrong
 */
public final class AbyssProject {
    private String name;
    private String author;
    private String version;
    private final List<TileSet> tileSets;
    
    public AbyssProject() {
        name = "Untitled";
        author = "Anonymous";
        version = "1.0";
        tileSets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<TileSet> getTileSets() {
        return tileSets;
    }
    
    public void addTileSet(TileSet tileSet) {
        tileSets.add(tileSet);
    }
}
