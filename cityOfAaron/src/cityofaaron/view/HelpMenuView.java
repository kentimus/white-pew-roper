
package cityofaaron.view;

import java.util.Scanner;

/**
 *
 * @author kanderson
 */
public class HelpMenuView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public HelpMenuView(){
        
        message = "This is the Help Menu. It is here to help you.\n"
                + "----------------------------------------------\n"
                + "1 - What are the goals of the game?\n"
                + "2 - Where is the city of Aaron?\n"
                + "3 - How do I view the map?\n"
                + "4 - How do I move to another location?\n"
                + "5 - How do I display a list of cureloms and cumons, tools, ontis of gold, \n"
                + "         Sons of Mosiah trading cards, etc., from the city storehouse?\n"
                + "6 - Never mind; this menu isn't helpful. Take me back to the Main Menu.\n";
                
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
        
        inputs[0] = getUserInput("Please choose a number");
        
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
                helpGameGoals();
                break;
            case "2":
                helpWhereIs();
                break;
            case "3":
                helpViewingMap();
                break;
            case "4":
                helpOtherLocation();
                break;
            case "5":
                helpViewInventory();
                break;
            case "6": // return to main menu
                return false;
            default : 
                System.out.println("\"" + inputs[0].trim() + "\" wasn't a valid choice.");
                System.out.println("That wasn't a number between 1 and 6. Try again.\n");
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
    
    
    
    
    private void helpGameGoals(){
        System.out.println ("\nGame Goals:\n"
                + "1: Don't let your people starve\n"
                + "2: Buy land\n\n");
    }
    private void helpWhereIs(){
        System.out.println ("\nWhere is the city of Aaron?\n"
                + "It's somewhere in the greater Zarahemla Metropolitan Area,"
                + "not far off of Interstate 5 near the Nehphihah/Moroni interchage.\n\n");
    }
    private void helpViewingMap(){
        System.out.println("\nHow do I view the map?\n"
                + "Try one of the following methods:\n"
                + "1) Install Google Maps on your Liahona and use faith.\n"
                + "2) Choose \"View the Map\" from the Game Menu.\n\n");
    }
    private void helpOtherLocation(){
        System.out.println("\nHow do I move to another location?\n"
                + "The city of Aaron is laid out in a 5x5 grid. In the map menu, choose\n"
                + "your x and y coordinates. 1,1 is in the top left-hand corner. 5,5 is\n"
                + "in the bottom right-hand corner.\n\n");
    }
    private void helpViewInventory(){
        System.out.println("\nHow do I display a list of cureloms and cumons, tools, ontis of gold, \n"
                + "         Sons of Mosiah trading cards, etc., from the city storehouse?\n"
                + "We suggest calling Jerry, the warehouse manager.\n"
                + "If he doesn't answer, just pick \"See Storehouse Inventory\" from the Game Menu\n\n");
    }
}