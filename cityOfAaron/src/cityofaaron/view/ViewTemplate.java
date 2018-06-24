
package cityofaaron.view;

import java.util.Scanner;

/**
 *
 * @author 
 */
public class ViewTemplate extends ViewBase{
    
    /**
     * Constructor
     */
    public ViewTemplate(){
        super();
    }
    
    @Override    
    protected String getMessage() {
        return "This is the message that is printed to the user by this view.\n"
               + "You have three tasks:\n"
               + "1 - Replace this message text with the text that is specific to your view.\n"
               + "2 - Replace this list with menu options that are specific to your view.\n"
               + "\n"
               + "3 - Prompt the user for what they are expected to enter.\n";
                
    }
    
    @Override
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        inputs[0] = getUserInput("Change this text to prompt the user for the input.");
        
        // Repeat for each input you need, putting it into its proper slot in the array.
        
        return inputs;
    }
    
    
    /**
     * Perform the action indicated by the user's input.
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs){
        // Act on the user's input.
        // This is a "dispatch" function that decides what
        // other functions to call. You can use an if-, if-else,
        // or switch statement.
        
        // return false if you want this view to exit and return
        // to the view that called it.
        someActionHandler();
        
        return true;
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private boolean someActionHandler(){
        // Define whatever code you need here to accomplish the action.
        // You can make this a void method if you want. Whatever you need 
        // here, you are free to do.
        //
        // Generally, though, this is where you will call into your Control
        // classes to do the work of the application.
        
        return true;
    }
}

