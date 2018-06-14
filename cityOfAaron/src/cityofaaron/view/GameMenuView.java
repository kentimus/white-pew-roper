
package cityofaaron.view;

import java.util.Scanner;

/**
 *
 * @author kanderson
 */
public class GameMenuView {
    
    
    /**
     * The message that will be displayed by this view.
     */
    protected String message;
    
    /**
     * Constructor
     */
    public GameMenuView(){
        
        message = "Game Menu\n"
                + "---------------------\n"
                + "1 - View the Map\n"
                + "2 - Move to a new Location\n"
                + "3 - Manage Crops\n"
                + "4 - Live the Year\n"
                + "5 - Reports Menu\n"
                + "6 - Save Game\n"
                + "---------------------\n";
                
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
        
        inputs[0] = getUserInput("Please choose an option.");
        
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
                viewTheMap();
                break;
            case "2":
                moveNewLocation();
                break;
            case "3":
                manageCrops();
                break;
            case "4":
                liveTheYear();
                break;
            case "5":
                reportsMenu();
                break;
            case "6":
                saveGame();
                break;
            
            default : 
                System.out.println("\"" + inputs[0].trim() + "\" wasn't a valid choice.");
                System.out.println("Please Choose a number between 1 and 6.\n");
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
    
    
    private void viewTheMap(){
        ViewMapView view = new ViewMapView();
        view.displayView(); 
    }
    
    private void moveNewLocation(){
        System.out.println("Moving to new location ... eventually");
    }
    
    private void manageCrops(){
        System.out.println("Crops Managed!\n");
    }
    
    private void liveTheYear(){
        System.out.println("Living the Year isn't available quite yet.\n");
    }
    
    private void reportsMenu(){
        ReportsMenuView view = new ReportsMenuView();
        view.displayView(); 
    }
    
    private void saveGame(){
        SaveGameView view = new SaveGameView();
        view.displayView(); 
    }
}
