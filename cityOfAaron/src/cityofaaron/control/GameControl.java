/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;

import cityofaaron.CityOfAaron;
import cityofaaron.exceptions.GameControlException;
import cityofaaron.exceptions.MapControlException;
import cityofaaron.model.Player;
import cityofaaron.model.Game;
import cityofaaron.model.Map;
import cityofaaron.model.Author;
import cityofaaron.model.Storehouse;
import cityofaaron.model.Provision;
import cityofaaron.model.Tool;
import cityofaaron.model.Animal;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
//import cityofaaron.control.MapControl

/**
 *
 * @author hpew, kroper, wwhite
 */
public class GameControl {

    public static Game createNewGame(String playerName)
            throws GameControlException {

        // this createsa new game  
        Game game = new Game();
        //

        // this creates a new player object 
        // and assigns the player to the game
        try {
            Player player = new Player();
            player.setName(playerName);
            game.setThePlayer(player);

        } catch (Throwable te) {
            throw new GameControlException("FAILED TO CREATE NEW PLAYER");
        }

        //build the storehouse
        Storehouse storehouse = new Storehouse();
        game.setStorehouse(storehouse);

        // create authors , populate an array and
        //add it to the storehouse
        try {
            // author group
            Author[] authors = new Author[3];

            authors[0] = new Author("Hayden Pew", "SupremeAlliedCommander");
            authors[1] = new Author("Kent Roper", "Chief Complainer");
            authors[2] = new Author("Will White", "White Boy");
            // Added author for testing/failing purposes
            //authors[3] = new Author("Will fsdfWhite", "White Boy");
            storehouse.setAuthors(authors);

        } catch (Throwable te) {
            throw new GameControlException("**FAILED TO CREATE AUTHORS**");
        }

        try {
            // Author hpew
            Provision[] provisions = new Provision[6];

            provisions[0] = new Provision("Goat milk", 2, 4);
            provisions[1] = new Provision("Dates", 10, 300);
            provisions[2] = new Provision("Twizzlers", 1000, 22);
            provisions[3] = new Provision("Wheat", 365, 503);
            provisions[4] = new Provision("Lama jerky", 730, 328);
            provisions[5] = new Provision("Grapes", 4, 33);

            storehouse.setProvisions(provisions);

        } catch (Throwable te) {
            throw new GameControlException("**FAILED TO ADD PROVISIONS**");
        }

        try {
            // author kroper
            Tool[] tools = new Tool[9];

            tools[0] = new Tool("Combine Harvester", 2);
            tools[1] = new Tool("Sickle", 17);
            tools[2] = new Tool("Seed drill", 2);
            tools[3] = new Tool("Pitchfork", 4);
            tools[4] = new Tool("Tractor", 3);
            tools[5] = new Tool("Curelom Harness", 5);
            tools[6] = new Tool("Cumon Bridle", 4);
            tools[7] = new Tool("Farmers Almenac", 1);
            tools[8] = new Tool("Mesoamerican Calendar", 1);

            storehouse.setTools(tools);

        } catch (Throwable te) {
            throw new GameControlException("**FAILED TO CREATE TOOLS**");
        }

        try {
            //author willw
            Animal[] animals = new Animal[4];

            animals[0] = new Animal("Cat", 5);
            animals[1] = new Animal("Deer", 20);
            animals[2] = new Animal("Sheep", 260);
            animals[3] = new Animal("Horse", 8);

            storehouse.setAnimals(animals);

        } catch (Throwable te) {
            throw new GameControlException("**FAILED TO CREATE ANIMALS**");
        }

        try {
            Map map = MapControl.createMap();
            game.setTheMap(map);

        } catch (MapControlException te) {
            throw new GameControlException("**FAILED TO CREATE MAP**");
        }

        // adding intitial wheat, acres, population, year:
        game.setAcresOwned(100);
        game.setWheatInStorage(2000);
        game.setCurrentPopulation(100);
        game.setCurrentYear(1);

        //Save a reference to the game in the main class
        CityOfAaron.setCurrentGame(game);

        return game;

    }

    public static void saveGame(Game game, String fileName) 
            throws GameControlException {
        if(game == null || fileName == null || fileName.length() < 1){
            throw new GameControlException("Game or Filename not valid");
        }
        
        try(ObjectOutputStream out = 
            new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(game); // writing the game
            
        } catch(IOException ex){
            throw new GameControlException("Game won't write to the file:" + ex.getMessage());
        }
    }
    
    public static Game getSavedGame(String fileName) throws GameControlException {
        Game game = null;
        if(fileName == null){
            throw new GameControlException("Missing Filename");
        }
        try(ObjectInputStream in = 
            new ObjectInputStream(new FileInputStream(fileName))){
            
            game = (Game)in.readObject();
            CityOfAaron.setCurrentGame(game);
            
        } catch(IOException | ClassNotFoundException ex){
            throw new GameControlException("Game won't open the file:" + ex.getMessage());
        }
        return game;
    }

    public int newPopulation(int currentPopulation)
            throws GameControlException {
        //Kent
        int addedPopulation;
        int newPopulation;

        //currentPopulation needs to be greater than zero
        if (currentPopulation <= 0) {
            throw new GameControlException("Population cannot be greater than zero");
        }

        Random rand = new Random(0);
        // get randomNumber between 1 and 5, inclusive
        int randomNum = rand.nextInt(5) + 1;
        addedPopulation = (currentPopulation * randomNum) / 100;
        newPopulation = addedPopulation + currentPopulation;
        return newPopulation;
    }

    public int pricePerAcre() {
        //kent
        Random rand = new Random();
        // get randomNumber between 17 and 27, inclusive
        int pricePerAcre = rand.nextInt(11) + 17;
        return pricePerAcre;
    }

    public int sellAcres(int acresToSell, int pricePerAcre, int acresOwned)
            throws GameControlException {
        //Hayden   
        if (acresToSell < 0 || acresToSell > acresOwned) {
            throw new GameControlException("You cannot sell more acres than you own");
        } else {
            int wheatFromAcres = (acresToSell * pricePerAcre);
            return wheatFromAcres;
        }
    }

    public int buyAcres(int acresRequested, int pricePerAcre, int wheatInStore)
            throws GameControlException {
        //group

        if (acresRequested < 0) {
            throw new GameControlException("The number of acres must be >= to 0");
        }
        // get request cost
        int cost = (acresRequested * pricePerAcre);
        if (cost > wheatInStore) {
            //not enough wheat in store
            throw new GameControlException("Insuffecient wheat for purchases");
        } else {
            int acresBought = acresRequested;
            return acresBought;
        }
    }

    public int acresPlanted(int acresRequested, int wheatInStore)
            throws GameControlException {
        //will
        Random rand = new Random();
        int acresPlanted;
        int low;
        int high;

        if (acresRequested < 0) {
            throw new GameControlException("Acres cannot be negative negative");
        }
        low = 17;
        high = 27;
        int cost = (acresRequested * (rand.nextInt(high - low) + low));
        if (cost > wheatInStore) {
            //not enough wheat in store
            throw new GameControlException("There is not enough wheat in store to plant this many acres");
        } else {
            acresPlanted = acresRequested;
            return acresPlanted;
        }
    }

    public int wheatHarvested(int acresPlanted, double tithingPaid) {
        //will
        int wheatHarvested = 0;
        Random rand = new Random();
        int low;
        int high;

        if (tithingPaid < .08) {
            low = 1;
            high = 3;
            // 1-3 bushels harvested
            wheatHarvested = (rand.nextInt(high - low) + low) * acresPlanted;
        }
        if (tithingPaid > .12) {
            low = 2;
            high = 5;
            // 2-5 bushels harvested
            wheatHarvested = (rand.nextInt(high - low) + low) * acresPlanted;
        }
        if (tithingPaid >= .08 && tithingPaid <= .12) {
            low = 2;
            high = 4;
            // 2-4 bushels harvested
            wheatHarvested = (rand.nextInt(high - low) + low) * acresPlanted;
        }
        return wheatHarvested;
    }

    // argument "rando" temporary for testing
    public double wheatEatenByRats(int wheatInStore, double tithingPaid, int rando)
            throws GameControlException {
        //Kent
        int percentEaten = 0;
        int bushelsEaten;

        // wheatInStore can't be below zero
        if (wheatInStore < 0) {
            throw new GameControlException("Wheat in store cannot be below zero");
        }

        // tithingPaid can't be below zero
        if (tithingPaid < 0) {
            throw new GameControlException("Tithing cannot be negative");
        }
        // create instance of Random class
        Random rand = new Random(5);
        //int randomNum = rand.nextInt(100);

        //temporary line, for testing
        int randomNum = rando;
        if (randomNum < 30) {
            if (tithingPaid < .08) {
                // Generate random percent between 6% and 10%
                percentEaten = rand.nextInt(5) + 6;
            }
            if (tithingPaid > .12) {
                // Generate randome percent between 3% and 5%
                percentEaten = rand.nextInt(3) + 3;
            }
            if (tithingPaid >= .08 && tithingPaid <= .12) {
                // tithingPaid between 8% and 12%, inclusive
                // Generate random percent between 3% and 7%
                percentEaten = rand.nextInt(5) + 3;
            }
        } else { // randomNum not less than 30
            percentEaten = 0;
        }
        bushelsEaten = (percentEaten * wheatInStore) / 100;
        return bushelsEaten;
    }

    public int starvedPopulation(int currentPopulation, int feedPopulation, int wheatInStore)
            throws GameControlException {
        //Hayden
        int totalWheatNeeded = currentPopulation * 20;
        int starvedPopulation;

        if (feedPopulation <= 0) {
            throw new GameControlException("wheat in store must be >= feed population or cannot be zero");
        }

        if (feedPopulation > wheatInStore) {
            throw new GameControlException("Wheat feed to population must be less then wheat in store");
        }

        if (totalWheatNeeded > wheatInStore) {
            starvedPopulation = currentPopulation - (wheatInStore / 20);
            return starvedPopulation;
        } else {
            starvedPopulation = currentPopulation - (feedPopulation / 20);
        }
        return starvedPopulation;
    }
}
