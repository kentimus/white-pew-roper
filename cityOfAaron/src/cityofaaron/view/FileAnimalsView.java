/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.model.Game;
import cityofaaron.model.Storehouse;
import cityofaaron.model.Animal;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author willi
 */
public class FileAnimalsView extends ViewBase {
    String fileName = "";

    /**
     * Constructor
     */
    public FileAnimalsView() {
        super();
    }

    @Override
    protected String getMessage() {
        return "Saving Animals report to " + this.fileName + "\n";
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

        saveAnimalsFile();

        return false;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void saveAnimalsFile(){
        Game game = CityOfAaron.getCurrentGame();
        Storehouse storehouse = game.getStorehouse();
        Animal[] animals = storehouse.getAnimals();
        try(PrintWriter report = new PrintWriter(new FileWriter(fileName))) {
            report.println("Animals in the city.");
            report.println();
            
            String printFormat = "%-23s %10s";
            report.println(String.format(printFormat, "Animals", "Quantities"));
            report.println("----------------------- ----------");
            
            for (Animal animal : animals) {
                report.println(String.format(printFormat, animal.getname(), animal.getQuantity()));
            }
            
            report.flush();        
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), "Error saving the Animals report: " + ex.getMessage());
        } 
    }

}

