package cityofaaron.view;

/**
 *
 * @author kanderson
 */
public class GameMenuView extends ViewBase {

    /**
     * Constructor
     */
    public GameMenuView() {
        super();
    }

    @Override
    protected String getMessage() {
        return "Game Menu\n"
                + "---------------------\n"
                + "1 - View the Map\n"
                + "2 - Move to a new Location\n"
                
                + "3 - Live the Year\n"
                + "4 - Reports Menu\n"
                + "5 - Save Game\n"
                + "\n"
                + "6 - Back to Main Menu\n"
                + "---------------------\n";
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

        inputs[0] = getUserInput("Please choose an option.");

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
        switch (inputs[0].trim().toUpperCase()) {
            case "1":
                viewTheMap();
                break;
            case "2":
                moveNewLocation();
                break;
            case "7":
                manageCrops();
                break;
            case "3":
                liveTheYear();
                break;
            case "4":
                reportsMenu();
                break;
            case "5":
                saveGame();
                break;
            case "6":
                // go back to main menu
                return false;
            default:
                String errorMessage = "\"" + inputs[0].trim() + "\" wasn't a valid choice."
                        + "\nPlease Choose a number between 1 and 6.";
                ErrorView.display(this.getClass().getName(), errorMessage);
        }

        return true;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void viewTheMap() {
        ViewMapView view = new ViewMapView();
        view.displayView();
    }

    private void moveNewLocation() {
        MoveLocationView view = new MoveLocationView();
        view.displayView();
    }

    private void manageCrops() { 
        ManageCropsMenuView view = new ManageCropsMenuView();
        view.displayView();
    }

    private void liveTheYear() {
        LiveYearView view = new LiveYearView();
        view.displayView();
    }

    private void reportsMenu() {
        ReportsMenuView view = new ReportsMenuView();
        view.displayView();
    }

    private void saveGame() {
        SaveGameView view = new SaveGameView();
        view.displayView();
    }
}
