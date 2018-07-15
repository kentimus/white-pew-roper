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
                + "5 - Save animals report to a file\n"
                + "6 - Save the tools report to a file\n"
                + "7 - Save the provisions report to a file\n"
                + "8 - Save the authors report to a file\n"
                + "\n"
                + "9 - Return to the Game Menu.\n"
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
            case "5":
                saveAnimals();
                break;
            case "6":
                saveTools();
                break;
            case "7":
                saveProvisions();
                break;
            case "8":
                saveAuthors();
                break;
            case "9": // return to main menu
                return false;
            default:
                String errorMessage = "\"" + inputs[0].trim() + "\" wasn't a valid choice."
                        + "\nThat wasn't a number between 1 and 9. Try again.";
                ErrorView.display(this.getClass().getName(), errorMessage);;
        }
        return true;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void animalsInStorehouse() {
        this.console.println("\n**Animals in storehouse**\n"
                + "This will eventually show the animals in the storehouse\n"
                + "And the user will be able to save the report\n"
                + "-------------------------------------------------------\n");
    }

    private void toolsInStorehouse() {
        //method to call the tools report
        ReportsToolsView view = new ReportsToolsView();
        view.displayView();
    }

    private void provisionsInStorehouse() {
        ReportsProvisionsView view = new ReportsProvisionsView();
        view.displayView();
    }

    private void viewAuthors() {
        //method to call the authors report
        ReportsAuthorsView view = new ReportsAuthorsView();
        view.displayView();
    }
    
    private void saveAnimals(){
        ReportsAnimalView view = new ReportsAnimalView();
        view.displayView();
    }
    
    private void saveTools(){
        try{
            SaveToolsView view = new SaveToolsView();
            view.displayView();
        } catch(Exception ex){
            ErrorView.display(this.getClass().getName(), "Error displaying the Tools report screen: " + ex.getMessage());
        }
    }
    
    private void saveProvisions(){
        try{
            SaveProvisionsView view = new SaveProvisionsView();
            view.displayView();
        } catch(Exception ex){
            ErrorView.display(this.getClass().getName(), "Error displaying the Provisions report screen: " + ex.getMessage());
        }
    }
    
    private void saveAuthors(){
        try{
            SaveAuthorsView view = new SaveAuthorsView();
            view.displayView();
        } catch(Exception ex){
            ErrorView.display(this.getClass().getName(), "Error displaying the Authors report screen: " + ex.getMessage());
        }
    }
    
}
