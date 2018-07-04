package cityofaaron.view;

//import cityofaaron.CityOfAaron;
//import cityofaaron.model.Player;
import cityofaaron.model.Game;
import cityofaaron.control.GameControl;
import cityofaaron.exceptions.GameControlException;

/**
 *
 * @author kanderson
 */
public class NewGameView extends ViewBase {

    /**
     * Constructor
     */
    public NewGameView() {
        super();
    }

    @Override
    protected String getMessage() {
        return "Starting a new Game ...\n";

    }

    @Override
    public String[] getInputs() {

        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[2];

        inputs[0] = getUserInput("Plese enter your name or press Enter to return to the Main Menu", false);
        inputs[1] = getUserInput("Plese enter your age", true);

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
            System.out.println("No player name entered, returning to the Main Menu ...");
            return false;
        }
        try {
            int age = Integer.parseInt(inputs[1]);
        } catch (Exception e) {
            System.out.println("***1234 are examples of numbers abc's are letters, please use numbers***");
        }

        String playerName = inputs[0];
        System.out.println("\nWelcome to the game, " + inputs[0] + "!");

        createAndStartGame(playerName);

        return false;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void createAndStartGame(String playerName) {
        try {
            Game game = GameControl.createNewGame(playerName);

            //Display Game Menu
            GameMenuView view = new GameMenuView();
            view.displayView();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
