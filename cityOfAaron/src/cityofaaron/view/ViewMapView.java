
package cityofaaron.view;

import java.util.Scanner;

/**
 *
 * @author kanderson
 * @author hpew
 */
public class ViewMapView extends ViewBase{
    
    /**
     * Constructor
     */
    public ViewMapView(){
        super();
    }
        
    protected String getMessage(){
        return "** The City Of Aaron **\n"
               + "-W- -R- --- --- -U- -L-\n"
               + "--- -W- -R- --- -U- -L-\n"
               + "--- -W- -W- -R- -U- -L-\n"
               + "--- -V- -W- W-R -U- -L-\n"
               + "--- -G- -W- -R- -U- -L-\n"
               + "--- --- --- --R --- -L-\n"
               + "--- --- --- R-- --- ---\n"
               + "W = wheat field      R = river\n"
               + "L = Lamanite border  V = village\n"
               + "U = undeveloped land G = Granary\n";       
    }
    
    /**
     * Get the set of inputs from the user.
     * @return 
     */
    public String[] getInputs() {
        
        //no inputs from this view, just diplay the map and return to the GameView
        return null;
    }
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){
        // no action jusr dispaly the map
        
        startGameMenuView();
        
        return false;
    }
        
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private void startGameMenuView(){
        //pause for a few seconds and return to Game Menu
        pause(3000);
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayView();
    }
}

