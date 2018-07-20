package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.control.GameControl;
import cityofaaron.model.Game;


/**
 *
 * @author Kent Roper
 */
public class TithingPaidView extends ViewBase {

    /**
     * Constructor
     */
    public TithingPaidView() {
        super();
    }

    @Override
    public String getMessage() {
        Game game = CityOfAaron.getCurrentGame();
        int wheatInStorage = game.getWheatInStorage();

        
        
        return "-----------------------------------------------\n"
                + "Tithing Paid\n"
                + "-----------------------------------------------\n"
                + "Current Wheat in Storage is: " + wheatInStorage + "\n";
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[1];

        inputs[0] = getUserInput("What percentage of wheat would you like to pay as a tithe?");

        // Repeat for each input you need, putting it into its proper slot in the array.
        return inputs;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
        // there is only one action here, start a new game and set it in the main cityofaaron class

        // if user hits "enter", quit to main menu
        if (inputs[0] == null || inputs[0].equals("")) {
            String errorMessage = "Nothing entered. Try again.";
            ErrorView.display(this.getClass().getName(), errorMessage);
            
            return true;
        }

        try {
            int percent = Integer.parseInt(inputs[0]);
            tithesPaid(percent);
            return false;
        } catch (Exception e) {
            String errorMessage = "***abc's are letters,1234 are examples of numbers, please use numbers***";
            ErrorView.display(this.getClass().getName(), errorMessage);
            
            return true;
        }
    }

    private void tithesPaid(int percent) {
        try {
            Game game = CityOfAaron.getCurrentGame();
            
            int wheatInStorage = game.getWheatInStorage();
                        
            GameControl.wheatHarvested(game, percent);
            
            wheatInStorage = game.getWheatInStorage();
            
            this.console.println("You paid " + percent + " percent in tithing.\n"
                    + "You now have " + wheatInStorage + " acres of land and "
                            + wheatInStorage + " bushels of wheat.\n");
        } catch (Exception te) {
            ErrorView.display(this.getClass().getName(), "Error buying acres: " + te.getMessage());
        }
    }
}

