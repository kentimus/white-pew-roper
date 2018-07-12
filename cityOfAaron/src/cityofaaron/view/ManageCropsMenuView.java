package cityofaaron.view;

public class ManageCropsMenuView extends ViewBase {

    /**
     *
     * @author willi constructor
     */
    public ManageCropsMenuView() {
        super();
    }

    /**
     * Message displayed by view.
     */
    @Override
        protected String getMessage() {

        return "Manage Crops Menu\n"
                + "---------------------\n"
                + "1 - Buy Land\n"
                + "2 - Sell Land\n"
                + "3 - Feed the people\n"
                + "4 - Plant Crops\n"
                + "5 - Pay tithes and Offerings\n"
                + "\n6 - Go back to Game Menu\n"
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

        // Repeat this for every input in the proper spot in the array.
        return inputs;
    }

    /**
     * Perform the action indicated by the input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if should exit
     * and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
        switch (inputs[0].trim().toUpperCase()) {
            case "1":
                buyLand();
                break;
            case "2":
                sellLand();
                break;
            case "3":
                feedThePeople();
                break;
            case "4":
                plantCrops();
                break;
            case "5":
                payTithesAndOfferings();
                break;
            case "6": // return to main menu
                return false;
            default:
                String errorMessage = "\"" + inputs[0].trim() + "\" wasn't a valid choice."
                        + "\nThat wasn't a number between 1 and 6. Try again.";
                ErrorView.display(this.getClass().getName(), errorMessage);
        }

        return true;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    /*
    I think this will be something like the newGameView 
    where it simply prompts the user for the amount of acres or wheat
    they want to assign.
     */
    private void buyLand() {
        this.console.println("\n**Buy Land**\n"
                + "This will allow the user to enter the number of acres to buy\n"
                + "-------------------------------------------------------\n");
    }

    private void sellLand() {
        this.console.println("\n**Buy Land**\n"
                + "This will allow the user to enter the number of acres to sell if no areas are bought\n"
                + "-------------------------------------------------------\n");
    }

    private void feedThePeople() {
        this.console.println("\n**Buy Land**\n"
                + "This will allow the user to enter the number of wheat to feed the population\n"
                + "-------------------------------------------------------\n");
    }

    private void plantCrops() {
        this.console.println("\n**Buy Land**\n"
                + "This will allow the user to enter the number of acres to plant\n"
                + "-------------------------------------------------------\n");
    }

    private void payTithesAndOfferings() {
        this.console.println("\n**Buy Land**\n"
                + "This will allow the user to enter the amount of wheat to tithe or offer\n"
                + "-------------------------------------------------------\n");
    }

}
