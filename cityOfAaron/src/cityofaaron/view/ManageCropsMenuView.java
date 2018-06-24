
package cityofaaron.view;

public class ManageCropsMenuView extends ViewBase{

/**
 *
 * @author willi
 * constructor
 */
    public ManageCropsMenuView (){
        super();
    }

    /**
     * Message displayed by view.
     */
    @Override
    protected String getMessage() {

        return "Manage Crops Menu\n"
               + "---------------------\n"
               + "1 - Buy Land\n"
               + "2 - Sell Land\n"
               + "3 - Feed the people\n"
               + "4 - Plant Crops\n"
               + "5 - Pay tithes and Offerings\n"
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
        
        // Repeat this for every input in the proper spot in the array.
        
        return inputs;
    }
    
    
    /**
     * Perform the action indicated by the input.
     * @param inputs
     * @return true if the view should repeat itself, and false if
     * should exit and return to the previous view.
     */
     
    @Override
    public boolean doAction(String[] inputs){
        switch (inputs[0].trim().toUpperCase() ){
            case "1":
                buyLand();
                break;
            case "2":
                sellLand();
                break;
            case "3":
                feedThePeople();
                break;
            case "4":
                plantCrops();
                break;
            case "5":
                payTithesAndOfferings();
                break;
            
            default : 
                System.out.println("\"" + inputs[0].trim() + "\" invalid choice.");
                System.out.println("Please Choose a number between 1 and 6.\n");
        }
        
        return true;
    }
    
    
    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    
    
    private void buyLand(){
        buyLandView view = new buyLandView();
        view.displayView(); 
    }
    
    private void sellLand(){
        sellLandView view = new sellLandView();
        view.displayView(); 
    }
    
    private void feedThePeople(){
        feedThePeopleView view = new feedThePeopleView();
        view.displayView(); 
    }
    
    private void plantCrops(){
        plantCropsView view = new plantCropsView();
        view.displayView(); 
    }
    
    private void payTithesAndOfferings(){
        payTithesAndOfferingsView view = new payTithesAndOfferingsView();
        view.displayView(); 
    }

}