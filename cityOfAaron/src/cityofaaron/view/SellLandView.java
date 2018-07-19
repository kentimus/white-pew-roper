package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.control.GameControl;
import cityofaaron.model.Game;


/**
 *
 * @author Kent Roper
 */
public class SellLandView extends ViewBase {

    /**
     * Constructor
     */
    public SellLandView() {
        super();
    }

    @Override
    public String getMessage() {
        Game game = CityOfAaron.getCurrentGame();
        int pricePerAcre = game.getPricePerAcre();
        int wheatInStorage = game.getWheatInStorage();
        int currentPopulation = game.getCurrentPopulation();
        int acresOwned = game.getAcresOwned();
        
        
        return "-----------------------------------------------\n"
                + "Sell Land\n"
                + "-----------------------------------------------\n"
                + "Current Price per Acre is: " + pricePerAcre + "\n"
                + "Current Wheat in Storage is: " + wheatInStorage + "\n"
                + "You currently own " + acresOwned + " acres of land.\n"
                + "Your current population is " + currentPopulation + "\n\n"
                + "How much land do you want to sell?\n";
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

        inputs[0] = getUserInput("", true);

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
            int acres = Integer.parseInt(inputs[0]);
            return sellAcres(acres);
            
        } catch (Exception e) {
            String errorMessage = "***abc's are letters,1234 are examples of numbers, please use numbers***";
            ErrorView.display(this.getClass().getName(), errorMessage);
            
            return true;
        }
    }

    private boolean sellAcres(int acres) {
        try {
            Game game = CityOfAaron.getCurrentGame();            
            GameControl.sellAcres(game, acres);
            
            int wheatInStorage = game.getWheatInStorage();
            int acresOwned = game.getAcresOwned();
            
            this.console.println("You sold " + acres + " acres.\n"
                    + "You now have " + acresOwned + " acres of land and "
                            + wheatInStorage + " bushels of wheat.\n");
            return false;
        } catch (Exception te) {
            ErrorView.display(this.getClass().getName(), "Error buying acres: " + te.getMessage());
            return true;
        }
    }
}

