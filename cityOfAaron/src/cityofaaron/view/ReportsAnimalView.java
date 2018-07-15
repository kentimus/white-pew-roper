/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Animals | Templates
 * and open the template in the editor.
 */
package cityofaaron.view;

import cityofaaron.CityOfAaron;
import cityofaaron.model.Game;
import cityofaaron.model.Animal;
import cityofaaron.model.Storehouse;

/**
 *
 * @author willi
 */
public class ReportsAnimalView extends ViewBase {

    private Object[] animals;

    /**
     * Constructor
     */
    public ReportsAnimalView() {
        super();
    }

    @Override
    protected String getMessage() {
        Game game = CityOfAaron.getCurrentGame();
        Storehouse storehouse = game.getStorehouse();
        Animal[] animals;
        animals = storehouse.getAnimals();

        animals = sortAnimal(animals);
        int total = getTotal(animals);

        String message;
        message = "-------------------------------------\n"
                + "There are " + total + " animals in the city.\n"
                + "-------------------------------------\n";
        for (Animal animal : animals) {
            message += animals.getname() + " : " + animals.getQuantity() + "\n";
        }
        return message;
    }

    private Animal[] sortAnimals(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            for (int j = i + 1; j < animals.length; j++) {
                if (animals[i].getname().compareTo(animals[j].getname()) > 0) {
                    Animal temp = animals[i];
                    animals[i] = animals[j];
                    animals[j] = temp;
                }
            }
        }
        return animals;
    }

    private int getTotal(Animal[] animals) {
        int total = 0;
        for (Animal animal : animals) {
            total += animal.getQuantity();
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
    private void startGameMenuView() {
        //pause the program for a specific number of miliseconds
        try {
            Thread.sleep(4000);
        } catch (InterruptedException exception) {
            //do nothing
        }
    }

    private Animal[] sortAnimal(Animal[] animals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Animals | Templates.
    }

}
