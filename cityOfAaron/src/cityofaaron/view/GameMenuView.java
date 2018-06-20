
package cityofaaron.view;

/**
 *
 * @author kanderson
 */
public class GameMenuView extends ViewBase {
    

    
    /**
     * Constructor
     */
    public GameMenuView(){
        super();           
    }
    
    @Override
    protected String getMessage(){
        return "Game Menu\n"
                + "---------------------\n"
                + "1 - View the Map\n"
                + "2 - Move to a new Location\n"
                + "3 - Manage Crops\n"
                + "4 - Live the Year\n"
                + "5 - Reports Menu\n"
                + "6 - Save Game\n"
                + "\n"
                + "7 - Back to Main Menu\n"
                + "---------------------\n";
    }
      
    /**
     * Get the set of inputs from the user.
     * @return 
     */
    @Override
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
    @Override
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
            case "7" :
                // go back to main menu
                return false;
            default : 
                System.out.println("\"" + inputs[0].trim() + "\" wasn't a valid choice.");
                System.out.println("Please Choose a number between 1 and 7.\n");
        }
        
        return true;
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

