/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron;

import cityofaaron.model.Player;

/**
 *
 * @author kent
 */
public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        playerOne.setName("Hayden");
        String playerOneName = playerOne.getName();
        System.out.println("Da playa name is = " + playerOneName);
    }
    
}
