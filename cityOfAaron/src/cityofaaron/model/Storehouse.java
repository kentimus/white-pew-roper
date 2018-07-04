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
 * @author pewst
 */
public class Storehouse implements Serializable {

    //Class instance variables
    private Author[] authors;
    private Animal[] animals;
    private Provision[] provisions;
    private Tool[] tools;
    // Javabean code

    // Constructor
    public Storehouse() {
    }

    //Getters and setters
    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public Tool[] getTools() {
        return tools;
    }

    public void setTools(Tool[] tools) {
        this.tools = tools;
    }

    public Provision[] getProvisions() {
        return provisions;
    }

    public void setProvisions(Provision[] provisions) {
        this.provisions = provisions;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    // hashcode and equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.authors);
        hash = 83 * hash + Objects.hashCode(this.animals);
        hash = 83 * hash + Objects.hashCode(this.tools);
        hash = 83 * hash + Objects.hashCode(this.provisions);
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
        if (!Objects.equals(this.animals, other.animals)) {
            return false;
        }
        if (!Objects.equals(this.tools, other.tools)) {
            return false;
        }
        if (!Objects.equals(this.provisions, other.provisions)) {
            return false;
        }
        return true;
    }

    // to string
    @Override
    public String toString() {
        return "Storehouse{" + "authors=" + authors + ", animals=" + animals + ", tools=" + tools + ", provisions=" + provisions + '}';
    }

}
