
package cityofaaron.view;

import java.util.Scanner;

/**
 *
 * @author kanderson
 */
public class ReportsMenuView{
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public ReportsMenuView(){
        
        message = "Reports Menu\n"
                + "-----------------------------------------\n"
                + "1 - View animals in the Storehouse\n"
                + "2 - View the tools in the storehouse\n"
                + "3 - View the provisions in the storehouse\n"
                + "4 - View the authors of this game\n"
                + "\n"
                + "5 - Return to the Game Menu.\n"
                + "-----------------------------------------\n";
                
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
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];
        
        inputs[0] = getUserInput("Please make a selection");
        
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
        switch (inputs[0].trim().toUpperCase() ){
            case "1":
                animalsInStorehouse();
                break;
            case "2":
                toolsInStorehouse();
                break;
            case "3":
                provisionsInStorehouse();
                break;
            case "4":
                viewAuthors();
                break;
            case "5": // return to main menu
                return false;
            default : 
                System.out.println("\"" + inputs[0].trim() + "\" wasn't a valid choice.");
                System.out.println("That wasn't a number between 1 and 5. Try again.\n");
        }
             
        return true;
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
    
    
    private void animalsInStorehouse(){
        System.out.println ("\n**Animals in storehouse**\n"
                + "This will eventually show the animals in the storehouse\n"
                + "And the user will be able to save the report\n"
                + "-------------------------------------------------------\n");
    }
    
    private void toolsInStorehouse(){
        System.out.println ("\n**Tools in storehouse**\n"
                + "This will eventually show the tools in the storehouse\n"
                + "And the user will be able to save the report\n"
                + "-----------------------------------------------------\n");
    }
    
    private void provisionsInStorehouse(){
        System.out.println("\n**Provisions in storehouse**\n"
                + "This will eventually show the provisions in the storehouse\n"
                + "And the user will be able to save the report\n"
                + "----------------------------------------------------------\n");
    }
    
    private void viewAuthors(){
        System.out.println("\n**Game Authors**\n"
                + "\n"
                + "This will eventually show the authors of the game\n"
                + "-------------------------------------------------\n");
    }
    
        // Define whatever code you need here to accomplish the action.
        // You can make this a void method if you want. Whatever you need 
        // here, you are free to do.
        //
        // Generally, though, this is where you will call into your Control
        // classes to do the work of the application.
        
}

