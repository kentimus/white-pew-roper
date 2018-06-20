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
        return "Hello! Welcome to the beautiful city of Aaron. The highpriest has summoned you here to\n"
                + "lead our people to prosperity, as the ruler of our city.  What you do as ruler\n"
                + "will determine if we prosper or perish. Your responsibilities include buying and selling\n"
                + "land, how much wheat to plant, how much wheat to store, feeding our people, and paying\n"
                + "a tithe on the wheat grown. If you do not grow enough wheat, you will not be able to feed\n"
                + "our people, they will starve, and some will die.  Our workforce will be disminished and we\n"
                + "will find a new leader. Plan your moves carefully, also not to stress you out, but the city\n"
                + "is infested with rats which constantly eat our wheat.\n";
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
