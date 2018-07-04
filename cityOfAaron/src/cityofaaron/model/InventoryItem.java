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
public class InventoryItem implements Serializable {

//Class instance variables
    private ItemType itemType;
    private int quantity;
    private Condition condition;

    // Javabean code
    // Constructor
    public InventoryItem() {
    }

    //Getters and setters
    public ItemType getitemType() {
        return itemType;
    }

    public void ItemType(ItemType type) {
        this.itemType = itemType;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public Condition getcondition() {
        return condition;
    }

    public void setcondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.itemType);
        hash = 29 * hash + this.quantity;
        hash = 29 * hash + Objects.hashCode(this.condition);
        return hash;
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
        final InventoryItem other = (InventoryItem) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (this.itemType != other.itemType) {
            return false;
        }
        if (this.condition != other.condition) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InventoryItem{" + "itemType=" + itemType + ", quantity=" + quantity + ", condition=" + condition + '}';
    }

}
