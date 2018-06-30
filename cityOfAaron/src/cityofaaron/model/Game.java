/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author kent
 */
public class Game implements Serializable {
    // class instance variables
    private Player thePlayer;
    private Map theMap;
    private Storehouse storehouse;
    private int currentPopulation;
    private int acresOwned;
    private int wheatInStorage;
    private int currentYear;
    
    //javabean code
    public Game() {
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public Map getTheMap() {
        return theMap;
    }

    public void setTheMap(Map theMap) {
        this.theMap = theMap;
    }

    public Storehouse getStorehouse() {
        return storehouse;
    }

    public void setStorehouse(Storehouse storehouse) {
        this.storehouse = storehouse;
    }

    public int getCurrentPopulation() {
        return currentPopulation;
    }

    public void setCurrentPopulation(int currentPopulation) {
        this.currentPopulation = currentPopulation;
    }
    
    public int getAcresOwned() {
        return acresOwned;
    }

    public void setAcresOwned(int acresOwned) {
        this.acresOwned = acresOwned;
    }

    public int getWheatInStorage() {
        return wheatInStorage;
    }

    public void setWheatInStorage(int wheatInStorage) {
        this.wheatInStorage = wheatInStorage;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    @Override
    public String toString() {
        return "Game{" 
                + "thePlayer=" + thePlayer 
                + ", theMap=" + theMap 
                + ", theStorehouse=" + storehouse 
                + ", currentPopulation=" + currentPopulation 
                + ", wheatInStorage=" + wheatInStorage 
                + ", currentYear=" + currentYear 
                + '}';
    }

    
}
