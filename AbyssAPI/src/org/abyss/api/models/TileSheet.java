/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.abyss.api.models;

/**
 *
 * @author Dan Armstrong
 */
public final class TileSheet {
    public static final String A1 = "a1";
    public static final String A2 = "a2";
    public static final String A3 = "a3";
    public static final String A4 = "a4";
    public static final String A5 = "a5";
    public static final String B = "b";
    public static final String C = "c";
    public static final String D = "d";
    public static final String E = "e";
    
    private String filename;
    private String tileType;
    private String description;
    
    public TileSheet(String filename, String tileType) {
        this.filename = filename;
        this.tileType = tileType;
        this.description = null;
    }
    
    public TileSheet(String filename, String tileType, String description) {
        this.filename = filename;
        this.tileType = tileType;
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTileType() {
        return tileType;
    }

    public void setTileType(String tileType) {
        this.tileType = tileType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
