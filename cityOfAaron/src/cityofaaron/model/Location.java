/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.model;

import java.io.Serializable;
//import java.util.Arrays;
//import java.util.Objects;

/**
 *
 * @author kent
 */
public class Location implements Serializable {
    // class instance variables
    private String name;
    private String description;
    private String mapSymbol;
    private String gameTip;
    
    // javabean code

    public Location() {
    }
    
    public Location(String name, String description, String mapSymbol, String gameTip){
        setName(name);
        setDescription(description);
        setMapSymbol(mapSymbol);
        setGameTip(gameTip);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }
    
    //shorter name, to reduce typing
    public String gMS(){
        return mapSymbol;
    }

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

    public String getGameTip() {
        return gameTip;
    }

    public void setGameTip(String gameTip) {
        this.gameTip = gameTip;
    } 

    @Override
    public String toString() {
        return "Location{" + "name=" + name 
                + ", description=" + description 
                + ", mapSymbol=" + mapSymbol 
                + ", gameTips=" + gameTip
                + '}';
    }
    
    
    
}
