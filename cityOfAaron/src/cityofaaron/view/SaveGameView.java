package cityofaaron.view;

import cityofaaron.control.GameControl;
import cityofaaron.exceptions.GameControlException;
import cityofaaron.model.Game;

/**
 *
 * @author kent roper
 */
public class SaveGameView extends ViewBase {

    /**
     * Constructor
     */
    public SaveGameView() {
        super();
    }

    @Override
    public String getMessage() {
        return "Please enter a file name to save your game ...\n";

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
            String errorMessage = "No file name entered. Please try again";
            ErrorView.display(this.getClass().getName(), errorMessage);
            
            return true;
        }

        String fileName = inputs[0];
        saveGame(fileName);

        return false;
    }

    private void saveGame(String fileName) {
        //this.console.println("\"" + fileName + "\" is a pretty good filename. Unfortunately, "
        //        + "saving the game doesn't work yet.\n");
        try {
            GameControl.saveGame(fileName);
        } catch (Exception te) {
            ErrorView.display(this.getClass().getName(), "Error saving game: " + te.getMessage());
        }

    }
}
