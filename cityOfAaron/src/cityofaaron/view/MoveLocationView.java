package cityofaaron.view;

/**
 *
 * @author willi
 */
public class MoveLocationView extends ViewBase {
    /**
     * Constructor
     */
    public MoveLocationView(){
        super();
    }
    
    @Override
    public String getMessage(){
        return "Please enter the coordinates of the location on the map you want to move to ...\n";
                               
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
        
        inputs[0] = getUserInput("", true);
        
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
        // the only action here is for the user to input coordinates, and then to move to thos coordinates
        
        // if user hits "enter", quit to main menu
        
        if (inputs[0] == null || inputs[0].equals("")){
            System.out.println("No coordinates entered. Please try again");
            return true;
        }
        
        String coordinates = inputs[0];
        moveLocation(coordinates);
        
        return false;
    }
    
    
    private void moveLocation(String coordinates){
        System.out.println("\"" + coordinates + "\" is a great location. It will be better, "
                + "when the program works.\n");
       
    }
}