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
 * @author willi
 */
public class Provision extends InventoryItem implements Serializable {

    //class instance variables
    private String name;
    private int perishable;

    //javabean code
    public Provision() {
    }

    public Provision(String name, int perishable) {
        setName(name);
        setPerishable(perishable);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPerishable() {
        return perishable;
    }

    public void setPerishable(int perishable) {
        this.perishable = perishable;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Provision other = (Provision) obj;
        if (this.perishable != other.perishable) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Provision{" + "name=" + name + ", perishable=" + perishable + '}';
    }
}
