package cityofaaron.view;


/**
 *
 * @author kanderson
 */
public class MainMenuView extends ViewBase {
    
    /**
     * Constructor
     */
    public MainMenuView(){
        super();
    }
    
    @Override
    protected String getMessage(){
        return "Main Menu\n"
                + "---------------------\n"
                + "1 - Start New Game\n"
                + "2 - Load a Saved Game\n"
                + "3 - Help Menu\n"
                + "\n"
                + "Q - Quit\n"
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
        
        inputs[0] = getUserInput("Please make an appropriate selection.");
        
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
                startNewGame();
                break;
            case "2":
                loadSavedGame();
                break;
            case "3":
                helpMenu();
                break;
            case "Q":
                System.out.println("Thank you for playing, have a Heavenly day");
                return false;
        }
        
        return true;
    }
      
    private void startNewGame(){
        // method to start a new game    
        NewGameView view = new NewGameView();
        view.displayView();             
    }
    
    private void loadSavedGame(){
        //method to load a saved game
        System.out.println ("*** loadSavedGame () ***");
    }
    
    private void helpMenu(){
        //method to call the help menu
        HelpMenuView view = new HelpMenuView();
        view.displayView();      
    }
}