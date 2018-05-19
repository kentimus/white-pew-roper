/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron;

import cityofaaron.model.Game;
import cityofaaron.model.Player;
import cityofaaron.model.Point;
import cityofaaron.model.Location;
import cityofaaron.model.Map;
import cityofaaron.model.Storehouse;

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
        System.out.println(playerOne.toString());
        
        Point pointOne = new Point();
        pointOne.setRow(3);
        pointOne.setColumn(3);
        System.out.println(pointOne.toString());
        
        Location locationOne = new Location();
        locationOne.setName("my house");
        locationOne.setDescription("the place where I watch Netflix");
        locationOne.setMapSymbol("house");
        locationOne.setGameTips(new String[]{ "Tip 1", "Tip 2"});
        System.out.println(locationOne.toString());
        
        Map mapOne = new Map();
        mapOne.setCurrentLocation(pointOne);
        System.out.println(mapOne.toString());
        
        Game gameOne = new Game();
        gameOne.setThePlayer(playerOne);
        gameOne.setTheMap(mapOne);
        gameOne.setTheStorehouse(new Storehouse());
        gameOne.setCurrentPopulation(1000);
        gameOne.setAcresOwned(250);
        gameOne.setWheatInStorage(500);
        gameOne.setCurrentYear(4);
        System.out.println(gameOne.toString());
    }
    
}
