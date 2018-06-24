package cityofaaron.view;


public class ManageCropssMenuView extends viewbase{

/**
 *
 * @author willi
 * constructor
 */
    public ManageCropssMenuView (){
        super();
    }

    /**
     * Message displayed by view.
     */
    
    @Override
    protected abstract String getMessage(); {

        return = "Manage Crops Menu\n"
                + "---------------------\n"
                + "1 - Buy Land\n"
                + "2 - Sell Land\n"
                + "3 - Feed the people\n"
                + "4 - Plant Crops\n"
                + "5 - Pay tithes and Offerings\n"
                + "---------------------\n";
                
    }
    
    
    /**
     * An overloaded version of getUserInput that sets allowEmpty to avoid 
     * to type it.
     * @param prompt
     * @return 
     */
    
    @Override
    protected String getUserInput(String prompt){
        return getUserInput(prompt, false);
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