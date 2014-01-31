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
public final class TileSet {
    private List<TileSheet> tileSheets;
    
    public TileSet() {
        tileSheets = new ArrayList<>();
    }
    
    public void add(TileSheet tileSheet) {
        tileSheets.add(tileSheet);
    }
    
    public void add(String filename, String tileType) {
        tileSheets.add(new TileSheet(filename, tileType));
    }
    
    public void add(String filename, String tileType, String description) {
        tileSheets.add(new TileSheet(filename, tileType, description));
    }
}
