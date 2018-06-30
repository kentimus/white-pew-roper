package cityofaaron.view;
import cityofaaron.CityOfAaron;
import cityofaaron.model.Game;
import cityofaaron.model.Storehouse;
import cityofaaron.model.Tool;


/**
 *
 * @author hpew
 */
public class ReportsToolsView extends ViewBase {

    /**
     * Constructor
     */
    public ReportsToolsView() {
        super();
    }

    @Override
    protected String getMessage() {
        Game game = CityOfAaron.getCurrentGame();
        Storehouse storehouse = game.getStorehouse();
        Tool[] tools = storehouse.getTools();
        
        tools = sortTools(tools);
        int total = getTotal(tools);
        
        String message = "--------------------------/n"
                + "You have " + total + " tools in your inventory:\n"
                + "---------------------------------\n";
        for(Tool tool : tools){
            message += tool.getname() + " : " + tool.getQuantity() + "\n";
        }
        return message;
    }
    
    private Tool[] sortTools(Tool[] tools){
        for(int i=0; i<tools.length; i++){
            for(int j=i+1; j<tools.length; j++){
                if(tools[i].getname().compareTo(tools[j].getname()) > 0){
                    Tool temp = tools[i];
                    tools[i] = tools[j];
                    tools[j] = temp;
                }
            }
        }
        return tools;
    }
    
    private int getTotal(Tool[] tools){
        int total = 0;
        for(Tool tool : tools){
            total += tool.getQuantity();
        }
        return total;
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
    private void startGameMenuView(){ 
    //pause the program for a specific number of miliseconds
            try {
            Thread.sleep(4000);
        } catch (InterruptedException exception) {
            //do nothing
        }
    }
    
}  
