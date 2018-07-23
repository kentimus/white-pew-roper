package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.model.Game;
import cityofaaron.model.Storehouse;
import cityofaaron.model.Author;
import java.util.ArrayList;

/**
 *
 * @author hpew
 */
public class ReportsAuthorsView extends ViewBase {

    /**
     * Constructor
     */
    public ReportsAuthorsView() {
        super();
    }

    @Override
    protected String getMessage() {
        Game game = CityOfAaron.getCurrentGame();
        Storehouse storehouse = game.getStorehouse();
        ArrayList<Author> authors = storehouse.getAuthors();
        
        String message = "------------------------------------\n"
                + "Authored by:\n"
                + "-------------------------------------\n";
        for (Author author : authors) {
            message += author.getName() + " -- " + author.getTitle() + "\n";
        }
        return message;
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        //no inputs from this view, just diplay the map and return to the GameView
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
        // no action jusr dispaly the map

        startGameMenuView();

        return false;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void startGameMenuView() {
        //pause the program for a specific number of miliseconds
        try {
            Thread.sleep(4000);
        } catch (InterruptedException exception) {
            //do nothing
        }
    }

}
