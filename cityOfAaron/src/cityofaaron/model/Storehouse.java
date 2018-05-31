/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author pewst
 */
public class Storehouse implements Serializable {
    
    //Class instance variables
    private Author authors;
    private InventoryItem tools ;
    private ArrayList<Animal> animal = new ArrayList<Animal>();
    private ArrayList<Provision> provision = new ArrayList<Provision>();
    // Javabean code
    
    // Constructor
    public Storehouse() {
    }
    
    //Getters and setters

    public Author getAuthors() {
        return authors;
    }

    public void setAuthors(Author authors) {
        this.authors = authors;
    }

    public InventoryItem getTools() {
        return tools;
    }

    public void setTools(InventoryItem tools) {
        this.tools = tools;
    }
    // hashcode and equals
        @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.authors);
        hash = 83 * hash + Objects.hashCode(this.animal);
        hash = 83 * hash + Objects.hashCode(this.tools);
        hash = 83 * hash + Objects.hashCode(this.provision);
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
        final Storehouse other = (Storehouse) obj;
        if (!Objects.equals(this.authors, other.authors)) {
            return false;
        }
        if (!Objects.equals(this.animal, other.animal)) {
            return false;
        }
        if (!Objects.equals(this.tools, other.tools)) {
            return false;
        }
        if (!Objects.equals(this.provision, other.provision)) {
            return false;
        }
        return true;
    }
    
    // to string

    @Override
    public String toString() {
        return "Storehouse{" + "authors=" + authors + ", animal=" + animal + ", tools=" + tools + ", provision=" + provision + '}';
    }
    
    

    
    }