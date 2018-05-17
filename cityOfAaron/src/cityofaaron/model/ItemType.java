/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.model;

/**
 *
 * @author pewst
 */
public enum ItemType {
    Animal,
    Tool,
    Provision;

    @Override
    public String toString() {
        return "ItemType{" + '}';
    }

    public static ItemType getAnimal() {
        return Animal;
    }

    public static ItemType getTool() {
        return Tool;
    }

    public static ItemType getProvision() {
        return Provision;
    }
    
   
            
    
}
