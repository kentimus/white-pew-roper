
package cityofaaron.view;

import java.util.Scanner;

/**
 *
 * @author kanderson
 */
public class StartProgramView {
  
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public StartProgramView(){
        // will - welcome message and short explaination of the game
        message = "Hello! Welcome to the beautiful city of Aaron. The highpriest has summoned you here to\n" +
        "lead our people to prosperity, as the ruler of our city.  What you do as ruler\n" +
        "will determine if we prosper or perish. Your responsibilities include buying and selling\n" +
        "land, how much wheat to plant, how much wheat to store, feeding our people, and paying\n" +
        "a tithe on the wheat grown. If you do not grow enough wheat, you will not be able to feed\n" +
        "our people, they will starve, and some will die.  Our workforce will be disminished and we\n" +
        "will find a new leader. Plan your moves carefully, also not to stress you out, but the city\n" +
        "is infested with rats which constantly eat our wheat.\n";
                
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
        
       // no inputs from this view it is the opening view that explains the game      
        return null;
    }
    
        /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    public boolean doAction(String[] inputs){
        // Act on the user's input.
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.
        
        // return false if you want this view to exit and return
        // to the view that called it.
        startMainMenuView();
        
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
    
        private void startMainMenuView(){
       //pause for a couple od seconds 
       try {
           Thread.sleep(2000);
        } 
       catch (InterruptedException exception){
           //ignore this exception for now
        }
       
       MainMenuView mainMenu = new MainMenuView();
       mainMenu.displayView();
       
    }
}

