
package cityofaaron.view;

import java.util.Scanner;

/**
 *
 * @author kanderson
 */
public class ViewMapView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public ViewMapView(){
        
        message = "-W- -R- --- --- -U- -L-\n"
                + "--- -W- -R- --- -U- -L-\n"
                + "--- -W- -W- -R- -U- -L-\n"
                + "--- -V- -W- W-R -U- -L-\n"
                + "--- -G- -W- -R- -U- -L-\n"
                + "--- --- --- --R --- -L-\n"
                + "--- --- --- R-- --- ---\n"
                + "W = wheat field      R = river\n"
                + "L = Lamanite border  V = village\n"
                + "U = undeveloped land G = Granary\n"
                + "\n";
                
    }
    
    
    /**
     * Get the user's input. Keep prompting them until they enter a value.
     * @param prompt
     * @param allowEmpty - determine whether the user can enter no value (just a return key)
     * @return 
     */
    protected String getUserInput(String prompt, boolean allowEmpty){
        
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;
        
        while(inputReceived == false){
            
            System.out.println(prompt);
            input = keyboard.nextLine();
            
            // Make sure we avoid a null-pointer error.
            if (input == null){
                input = "";
            }
            
            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();
            
            if (input.equals("") == false || allowEmpty == true){
                inputReceived = true;
            }
        }
        
        return input;
    }
    
    
    /**
     * An overloaded version of getUserInput that sets allowEmpty to false so we don't have 
     * to type it ourselves.
     * @param prompt
     * @return 
     */
    protected String getUserInput(String prompt){
        return getUserInput(prompt, false);
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
    
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses and action that causes this view to close.
     */
    public void displayView(){
        
        boolean keepGoing = true;
        
        while(keepGoing == true){
            
            System.out.println(message);
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private void startGameMenuView(){
        //pause for a few seconds and return to Game Menu
        try {
            Thread.sleep(4000);
        }
        catch (InterruptedException exception){
            //ignore the exception for now  
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayView();
    }
}

