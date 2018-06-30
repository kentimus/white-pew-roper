package cityofaaron.view;

/**
 *
 * @author kanderson
 */
public class StartProgramView extends ViewBase {

    /**
     * Constructor
     */
    public StartProgramView() {
        super();
    }

    @Override
    protected String getMessage() {
        String message = "   _____ _ _                  __                                 \n"
                + "  / ____(_) |                / _|     /\\                         \n"
                + " | |     _| |_ _   _    ___ | |_     /  \\   __ _ _ __ ___  _ __  \n"
                + " | |    | | __| | | |  / _ \\|  _|   / /\\ \\ / _` | '__/ _ \\| '_ \\ \n"
                + " | |____| | |_| |_| | | (_) | |    / ____ \\ (_| | | | (_) | | | |\n"
                + "  \\_____|_|\\__|\\__, |  \\___/|_|   /_/    \\_\\__,_|_|  \\___/|_| |_|\n"
                + "                __/ |                                            \n"
                + "               |___/"
                + "\n"
                + "------------------------------------------------------------------\n"
                + "The new fun game where you can:\n"
                + "------------------------------------------------------------------\n"
                + "Buy and Sell Land! Grow Wheat! Pay tithing! View your inventory!\n\n"
                + "Don't let your people starve,and you can be a winner!\n"
                + "------------------------------------------------------------------\n";

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
        // There are no inputs for this menu
        // it is simply an introduction to the game 
        startMainMenuView();

        return false;
    }

    private void startMainMenuView() {
        //pause for a couple od seconds 
        pause(3000);

        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayView();

    }
}
