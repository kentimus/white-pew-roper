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
public class Tool {

    private String name;
    private int quantity;

    public Tool() {
    }

    public Tool(String name, int quantity) {
        setName(name);
        setQuantity(quantity);
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
