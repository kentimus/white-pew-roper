package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.control.GameControl;
import cityofaaron.exceptions.GameControlException;
import cityofaaron.model.Game;

/**
 *
 * @author HaydenPew
 */
public class AcresPlantedView extends ViewBase {

    /**
     * Constructor
     */
    public AcresPlantedView() {
        super();
    }

    @Override
    public String getMessage() {
        Game game = CityOfAaron.getCurrentGame();
        int wheatInStore = game.getWheatInStorage();
        int acresOwned = game.getAcresOwned();

        return "-----------------------------------------------\n"
                + "Plant Acres with Wheat\n"
                + "-----------------------------------------------\n"
                + "You have " + wheatInStore + " bushels of wheat in Storage\n"
                + "And you own " + acresOwned + " acres\n\n"
                + "How many acres do you want to plant?\n";
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
            int acresToPlant = Integer.parseInt(inputs[0]);
            acresPlanted(acresToPlant);
            return false;
        } catch (NumberFormatException e) {
            String errorMessage = "***abc's are letters,1234 are examples of numbers, please use numbers***";
            ErrorView.display(this.getClass().getName(), errorMessage);

            return true;
        }
    }

    private void acresPlanted(int acresToPlant) {
        try {
            Game game = CityOfAaron.getCurrentGame();
            int pop = game.getCurrentPopulation();
            int acresOwned = game.getAcresOwned();
            int plantableAcres = (pop * 10 + 1);
            if (acresToPlant > plantableAcres) {
                this.console.println("Each person can only farm 10 acres\n");
                AcresPlantedView apView = new AcresPlantedView();
                apView.displayView();
            } else {
                GameControl.acresPlanted(game, acresToPlant);

                int wheatInStorage = game.getWheatInStorage();

                this.console.println("You now have " + wheatInStorage + " bushels of wheat in storage.\n");
            }
        } catch (GameControlException te) {
            ErrorView.display(this.getClass().getName(), "Error palanting crops: " + te.getMessage());

        }
    }
}
