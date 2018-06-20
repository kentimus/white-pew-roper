
package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.model.Player;
import cityofaaron.model.Game;

/**
 *
 * @author kanderson
 */
public class NewGameView extends ViewBase {
    
    /**
     * Constructor
     */
    public NewGameView(){
        super();
    }
    
    protected String getMessage(){
        return "Starting a new Game ...\n";
                               
    }
    
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        inputs[0] = getUserInput("Plese enter your name or press Enter to return to the Main Menu", true);
        
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
    }
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){
        // there is only one action here, start a new game and set it in the main cityofaaron class
        
        // if user hits "enter", quit to main menu
        
        if (inputs[0] == null || inputs[0].equals("")){
            System.out.println("No player name entered, returning to the Main Menu ...");
            return false;
        }
        
        String playerName = inputs[0];
        createAndStartGame(playerName);
        
        
        return false;
    }
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private void createAndStartGame(String playerName){
        // eventually we will do this when we know more
        // Game game = GameControl.creatNewGame(playerName)
        // for this week we will do this
        
        Player player = new Player();
        player.setName(playerName);
        
        Game game = new Game();
        game.setThePlayer(player);
        
        CityOfAaron.setCurrentGame(game);
        
        //Display Game Menu
        GameMenuView view = new GameMenuView();
        view.displayView();
    }
}

