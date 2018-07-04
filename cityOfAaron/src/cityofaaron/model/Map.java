/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author kent
 */
public class Map implements Serializable {

    //class instance variables
    private Location[][] locations;
    private Point currentLocation;

    //javabean code
    public Map() {
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
        return "Map{" + "locations=" + locations + ", currentLocation=" + currentLocation + '}';
    }

}
