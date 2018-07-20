package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.control.GameControl;
import cityofaaron.exceptions.GameControlException;
import cityofaaron.model.Game;


/**
 *
 * @author Hayden Pew
 */
public class FeedPeopleView extends ViewBase {

    /**
     * Constructor
     */
    public FeedPeopleView() {
        super();
    }

    @Override
    public String getMessage() {
        Game game = CityOfAaron.getCurrentGame();
        int wheatInStorage = game.getWheatInStorage();
        int currentPopulation = game.getCurrentPopulation();
        int feedPeople;
             
        return "-----------------------------------------------\n"
                + "Feed The People\n"
                + "-----------------------------------------------\n"
                + "Your current population is " + currentPopulation + "\n"
                + "Current Wheat in Storage is: " + wheatInStorage + "\n"
                + "How many bushels of wheat do you want to feed your people?\n";
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
            int wheatForPopulation = Integer.parseInt(inputs[0]);
            feedPeople(wheatForPopulation);
            return false;
        } catch (NumberFormatException e) {
            String errorMessage = "***abc's are letters,1234 are examples of numbers, please use numbers***";
            ErrorView.display(this.getClass().getName(), errorMessage);
            
            return true;
        }
    }

    private void feedPeople(int wheatForPopulation) {
        try {
            Game game = CityOfAaron.getCurrentGame();
                                   
            GameControl.starvedPopulation(game, wheatForPopulation);
            
            int wheatInStorage = game.getWheatInStorage();
            int currentPopulation = game.getCurrentPopulation();
            
            this.console.println("You have allocated " + wheatForPopulation + " bushels of wheat to feed you people\n"
                    + "You now have " + wheatInStorage + " bundles of wheat left is storage.\n");
        } catch (GameControlException te) {
            ErrorView.display(this.getClass().getName(), "Error buying acres: " + te.getMessage());
        }
    }
}
