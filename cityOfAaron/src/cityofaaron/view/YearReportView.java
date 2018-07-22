package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.control.GameControl;
import cityofaaron.exceptions.GameControlException;
import cityofaaron.model.Game;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kanderson
 */
public class YearReportView extends ViewBase {

    /**
     * Constructor
     */
    public YearReportView() {
        super();
    }

    @Override
    protected String getMessage() {
        Game game = CityOfAaron.getCurrentGame();
        int starvedPopulation = game.getStarvedPopulation();
        int eatenByRats = game.getEatenByRats();
        int wheatHarvested = game.getWheatHarvested();
        int currentPopulation = game.getCurrentPopulation();
        int tithingPaid = game.getTithingPaid();
        int currentYear = game.getCurrentYear();
        int wheatInStorage = game.getWheatInStorage();
        int cropYield = game.getCropYield();
        
        String message = "\n\n*******************************************\n"
                + "You made it to year " + currentYear + "\n"
                + "*******************************************\n"
                + "You starved " + starvedPopulation + " people\n"
                + "your crop yield was " + cropYield + " per acre\n"
                + "You harvested " + wheatHarvested + " bushels of wheat\n"
                + "You paid " + tithingPaid + " in wheat for tithing\n"
                + eatenByRats + " bushels of wheat were eaten by rats\n"
                + "Which leaves you with " + wheatInStorage + " bushels of wheat\n"
                + "And " + currentPopulation + " people in your city\n"
                + "*******************************************";
        return message;
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {
        // no inputs from this view it is the opening view that explains the game      
        return null;
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
        showYear();

        return false;
    }

    private void showYear(){
        pause(3000);
    }
}

