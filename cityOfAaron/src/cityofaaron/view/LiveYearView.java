/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.control.GameControl;
import cityofaaron.exceptions.GameControlException;
import cityofaaron.model.Game;

/**
 *
 * @author pewst
 */
public class LiveYearView extends ViewBase {

    /**
     * Constructor
     */
    public LiveYearView() {
        super();
    }

    @Override
    protected String getMessage() {
        Game game = CityOfAaron.getCurrentGame();
        int wheatInStore = game.getWheatInStorage();
        int population = game.getCurrentPopulation();
        int acres = game.getAcresOwned();
        int price = game.getPricePerAcre();

        return "Welcome Esteemed " + game.getThePlayer() + " we look forward to your inspired leadreship\n\n"
                + "You currently have:\n"
                + population + " citizens in the City,\n"
                + acres + " acres to be used, and\n"
                + wheatInStore + " bushels of wheat in storage\n"
                + "The current price per acres is " + price +"\n\n";

    }

    @Override
    public String[] getInputs() {
        
        // Declare the array to have the number of elements you intend to get 
        // from the user.
        String[] inputs = new String[4];

        inputs[0] = getUserInput("How many acres would you like to buy?");

        inputs[1] = getUserInput("How many acres would you like to sell?");

        inputs[2] = getUserInput("How many bushels of wheat do you want to reserve for feeding your people?");

        inputs[3] = getUserInput("How many acres would you like to plant");

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
            String errorMessage = "Nothing entered. Try again.";
            ErrorView.display(this.getClass().getName(), errorMessage);
            
            return true;
        }

        try {
            int acresBuy = Integer.parseInt(inputs[0]);
            int acresSell = Integer.parseInt(inputs[1]);
            liveYear(acresBuy,acresSell);
            return false;
        } catch (NumberFormatException e) {
            String errorMessage = "***abc's are letters,1234 are examples of numbers, please use numbers***";
            ErrorView.display(this.getClass().getName(), errorMessage);
        }
        return true;
        
   }
   
    private void liveYear(int acresBuy, int acresSell) {
        try {
            Game game = CityOfAaron.getCurrentGame();
            int pricePerAcre = game.getPricePerAcre();
            int wheatInStorage = game.getWheatInStorage();
            int currentPopulation = game.getCurrentPopulation();

            GameControl.buyAcres(game, acresBuy, pricePerAcre, wheatInStorage);

            wheatInStorage = game.getWheatInStorage();
            int acresOwned = game.getAcresOwned();
            
            this.console.println("You bought " + acresBuy + " acres.\n"
                    + "You now have " + wheatInStorage + " bunshels of wheat.\n");
            
            GameControl.sellAcres(game, acresSell, pricePerAcre, wheatInStorage);
            
            wheatInStorage = game.getWheatInStorage();
            acresOwned = game.getAcresOwned();
            
            this.console.println("You sold " + acresSell + " acres.\n"
                    + "You now have " + wheatInStorage + " bunshels of wheat.\n");

        } catch (GameControlException te) {
            ErrorView.display(this.getClass().getName(), "Error buying acres: " + te.getMessage());
        }
    }
    
}
