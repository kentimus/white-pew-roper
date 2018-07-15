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
    private int quantity;

    //javabean code
    public Provision() {
    }

    public Provision(String name, int perishable, int quantity) {
        setName(name);
        setPerishable(perishable);
        setQuantity(quantity);
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
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + this.perishable;
        hash = 37 * hash + this.quantity;
        return hash;
    }

    @Override
    public String toString() {
        return "Provision{" + "name=" + name + ", perishable=" + perishable + '}';
    }
}
