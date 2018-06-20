/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron;

import cityofaaron.model.Game;
//import cityofaaron.model.Player;
import cityofaaron.view.StartProgramView;
import cityofaaron.view.View;


/**
 *
 * @author kent
 */
public class CityOfAaron {

    // keep a copy of the current game in the main class
    public static Game currentGame = null;
    
    public static Game getCurrentGame(){
        return currentGame;
    }
    
    public static void setCurrentGame(Game game){
        currentGame = game;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       View startProgramView = new StartProgramView();
       startProgramView.displayView();
    }
    
}
