package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.model.Game;
import cityofaaron.model.Storehouse;
import cityofaaron.model.Tool;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author hpew
 */
public class FileToolsView extends ViewBase {
    String fileName = "";

    /**
     * Constructor
     */
    public FileToolsView() {
        super();
    }

    @Override
    protected String getMessage() {
        return "Saving Tools report to " + this.fileName + "\n";
    }
    
    public void setFileName(String filename){
        this.fileName = filename;
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

        saveReportFile();

        return false;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void saveReportFile(){
        Game game = CityOfAaron.getCurrentGame();
        Storehouse storehouse = game.getStorehouse();
        Tool[] tools = storehouse.getTools();
        try(PrintWriter report = new PrintWriter(new FileWriter(fileName))) {
            report.println("Tools in the inventory");
            String printFormat = "%-23s %-10s";
            report.println(String.format(printFormat, "Tools", "Quantities"));
            report.println("----------------------- --------");
            
            for (Tool tool : tools) {
                report.println(String.format(printFormat, tool.getname(), tool.getQuantity()));
            }
            
            report.flush();        
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), "Error saving the Tools report: " + ex.getMessage());
        } 
    }

}

