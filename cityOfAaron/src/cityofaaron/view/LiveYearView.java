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
public class LiveYearView extends ViewBase {

    /**
     * Constructor
     */
    public LiveYearView() {
        super();
    }

    @Override
    protected String getMessage() {
        String message = "";
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
        try {
            liveYear();
        } catch (GameControlException ex) {
             ErrorView.display(this.getClass().getName(), "Error living year: " + ex.getMessage());
        }

        return false;
    }

    private void liveYear() throws GameControlException {
        Game game = CityOfAaron.getCurrentGame();
        
        BuyLandView blView = new BuyLandView();
        blView.displayView();
        
        //int landBought = game.getLandBought();
        //if(landBought == 0){
            SellLandView slView = new SellLandView();
            slView.displayView();
        //}
        
        FeedPeopleView fpView = new FeedPeopleView();
        fpView.displayView();
        
        AcresPlantedView apView = new AcresPlantedView();
        apView.displayView();
        
        TithingPaidView tpView = new TithingPaidView();
        tpView.displayView();
        
        GameControl.wheatEatenByRats(game, game.getWheatInStorage(), game.getTithingPaid());
        
        game.setCurrentYear(game.getCurrentYear() + 1);
        
        YearReportView yrView = new YearReportView();
        yrView.displayView();
    }
}
