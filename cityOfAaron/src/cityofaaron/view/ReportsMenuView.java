package cityofaaron.view;

/**
 *
 * @author hpew
 */
public class ReportsMenuView extends ViewBase {

    /**
     * Constructor
     */
    public ReportsMenuView() {
        super();
    }

    @Override
    protected String getMessage() {
        return "Reports Menu\n"
                + "-----------------------------------------\n"
                + "1 - View animals in the Storehouse\n"
                + "2 - View the tools in the storehouse\n"
                + "3 - View the provisions in the storehouse\n"
                + "4 - View the authors of this game\n"
                + "\n"
                + "5 - Return to the Game Menu.\n"
                + "-----------------------------------------\n";
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

        inputs[0] = getUserInput("Please make a selection");

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
                animalsInStorehouse();
                break;
            case "2":
                toolsInStorehouse();
                break;
            case "3":
                provisionsInStorehouse();
                break;
            case "4":
                viewAuthors();
                break;
            case "5": // return to main menu
                return false;
            default:
                System.out.println("\"" + inputs[0].trim() + "\" wasn't a valid choice.");
                System.out.println("That wasn't a number between 1 and 5. Try again.\n");
        }
        return true;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void animalsInStorehouse() {
        System.out.println("\n**Animals in storehouse**\n"
                + "This will eventually show the animals in the storehouse\n"
                + "And the user will be able to save the report\n"
                + "-------------------------------------------------------\n");
    }

    private void toolsInStorehouse() {
        System.out.println("\n**Tools in storehouse**\n"
                + "This will eventually show the tools in the storehouse\n"
                + "And the user will be able to save the report\n"
                + "-----------------------------------------------------\n");
    }

    private void provisionsInStorehouse() {
        System.out.println("\n**Provisions in storehouse**\n"
                + "This will eventually show the provisions in the storehouse\n"
                + "And the user will be able to save the report\n"
                + "----------------------------------------------------------\n");
    }

    private void viewAuthors() {
        System.out.println("\n**Game Authors**\n"
                + "\n"
                + "This will eventually show the authors of the game\n"
                + "-------------------------------------------------\n");
    }
}
