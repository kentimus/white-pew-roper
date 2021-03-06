
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
import java.util.ArrayList;
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
            ArrayList<Author> authors = new ArrayList<>();
            authors.add(new Author("Hayden Pew", "SupremeAlliedCommander"));
            authors.add(new Author("Kent Roper", "Chief Complainer"));
            authors.add(new Author("Will White", "White Boy"));
            
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

        // adding intitial wheat, acres, population, year, etc:
        game.setAcresOwned(1000);
        game.setWheatInStorage(2000);
        game.setCurrentPopulation(100);
        game.setCurrentYear(1);
        game.setPricePerAcre(pricePerAcre());
        game.setLandBought(0);
        game.setEatenByRats(0);
        game.setWheatHarvested(0);

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

    public static void newPopulation(Game game, int currentPopulation)
            throws GameControlException {
        //Kent/Hayden
        currentPopulation = game.getCurrentPopulation();
        int addedPopulation;
        int newPopulation;

        //currentPopulation needs to be greater than zero
        if (currentPopulation <= 0) {
            throw new GameControlException("Population cannot be greater than zero");
        }

        Random rand = new Random(0);
        // get randomNumber between 1 and 5, inclusive
        int randomNum = rand.nextInt(6) + 1;
        addedPopulation = (currentPopulation + randomNum)/100;
        newPopulation = addedPopulation + currentPopulation;
        
        game.setCurrentPopulation(newPopulation);
    }

    public static int pricePerAcre() {
        //kent
        Random rand = new Random();
        // get randomNumber between 17 and 27, inclusive
        int pricePerAcre = rand.nextInt(11) + 17;
        return pricePerAcre;
    }

    public static void sellAcres(Game game, int acresToSell, int pricePerAcre, int wheatInStore)
            throws GameControlException {
        //Hayden
        int acresOwned = game.getAcresOwned();
         
        if (acresToSell < 0 || acresToSell > acresOwned) {
            throw new GameControlException("You cannot sell more acres than you own");
        } else {
            int wheatFromAcres = (acresToSell * pricePerAcre);
            wheatInStore = (wheatInStore + wheatFromAcres);
            int newAcresOwned = (acresOwned - acresToSell);
            
            game.setWheatInStorage(wheatInStore);
            game.setAcresOwned(newAcresOwned);
            
        }
    }

    public static void buyAcres(Game game, int acresRequested)
            throws GameControlException {
        //group
        int wheatInStore = game.getWheatInStorage();
        int pricePerAcre = game.getPricePerAcre();
        
        if (acresRequested < 0) {
            throw new GameControlException("The number of acres must be >= to 0");
        }
        // get request cost
        int cost = (acresRequested * pricePerAcre);
        if (cost > wheatInStore) {
            //not enough wheat in store
            //throw new GameControlException("Insuffecient wheat for purchases");
            throw new GameControlException("cost = " + cost + ", wheatInStore = " + wheatInStore
                    + " pricePerAcre = " + pricePerAcre
                    + " acresRequested = " + acresRequested);
        } else {
            int acresBought = acresRequested;
            
            int acresOwned = game.getAcresOwned();
            int newAcresOwned = acresOwned + acresBought;
            
            int wheatSpent = acresRequested * pricePerAcre;
            int newWheatInStorage = wheatInStore - wheatSpent;
            
            game.setAcresOwned(newAcresOwned);
            game.setWheatInStorage(newWheatInStorage);
            game.setLandBought(acresRequested);
        }   
    }
    
    public static void sellAcres(Game game, int acresSold)
            throws GameControlException {
        //kent
        
        int acresOwned = game.getAcresOwned();
        int pricePerAcre = game.getPricePerAcre();
        int wheatInStore = game.getWheatInStorage();
        

        if (acresSold < 0) {
            throw new GameControlException("The number of acres must be >= to 0");
        }
        if (acresSold > acresOwned) {
            throw new GameControlException("You can't sell " + acresSold + " acres of land\n"
                    + " when you only have " + acresOwned + " of land that you own.");
        } else {
            
            int newAcresOwned = acresOwned - acresSold;
            int newWheat = wheatInStore + (acresSold * pricePerAcre);
           
            game.setAcresOwned(newAcresOwned);
            game.setWheatInStorage(newWheat);   
        }   
    }

    public static void acresPlanted(Game game, int acresToPlant)
            throws GameControlException {
        //will
        int wheatInStore = game.getWheatInStorage();
        int currentAcres = game.getAcresOwned();
        int currentPop = game.getCurrentPopulation();
        
        
        if (acresToPlant < 0) {
            throw new GameControlException("Acres cannot be negative negative");
        }
        
        if (acresToPlant > currentAcres) {
            throw new GameControlException(" You can not plant more acres then you own");
        }
        
        int possibleAcresPlanted = (currentPop *10);       
        
        if (acresToPlant > possibleAcresPlanted) {
            throw new GameControlException ("Each person can only farm 10 acres");
        }
        
        if (acresToPlant > wheatInStore) {
            //not enough wheat in store
            throw new GameControlException("There is not enough wheat in store to plant this many acres");
        } else {
            int newWheatInStore = (wheatInStore - acresToPlant);
            game.setCropsPlanted(acresToPlant);
            game.setWheatInStorage(newWheatInStore);
                        
        }
    }

    public static void wheatHarvested(Game game, int tithingPaid) {
        //will
        int wheatHarvested = 0;
        Random rand = new Random();
        
        int acresPlanted = game.getCropsPlanted();
        int wheatInStore = game.getWheatInStorage();
        int yield = 2;

        if (tithingPaid < 9) {
            yield = (rand.nextInt((3 - 1) + 1) +1);
            // 1-3 bushels harvested
            wheatHarvested = yield * acresPlanted;
        }
        if (tithingPaid > 12) {
            //low = 4;
            //high = 6;
            yield = (rand.nextInt(6 - 4) + 1) + 4;
            // 4-6 bushels harvested
            wheatHarvested = yield * acresPlanted;
        }
        if (tithingPaid >= 9 && tithingPaid <= 12) {
            //low = 3;
            //high = 5;
            yield = (rand.nextInt(5 - 3) + 1)+ 3;
            // 3-5 bushels harvested
            wheatHarvested = yield * acresPlanted;
        }
        int wheatTithe = wheatHarvested*tithingPaid/100;
        int newWheatHarvested = (wheatInStore + wheatHarvested - wheatTithe);
        game.setWheatInStorage(newWheatHarvested);
        game.setWheatHarvested(wheatHarvested);
        game.setTithingPaid(wheatTithe);
        game.setCropYield(yield);
    }

    public static void wheatEatenByRats(Game game, int wheatInStore, int tithingPaid)
            throws GameControlException {
        //Kent
        int percentEaten = 0;
        int bushelsEaten;
        wheatInStore = game.getWheatInStorage();

        // wheatInStore can't be below zero
        if (wheatInStore < 0) {
            throw new GameControlException("Wheat in store cannot be below zero");
        }

        // tithingPaid can't be below zero
        if (tithingPaid < 0) {
            throw new GameControlException("Tithing cannot be negative");
        }
        // create instance of Random class
        Random rand = new Random();
        int randomNum = rand.nextInt(100);

        if (randomNum < 30) {
            if (tithingPaid < 8) {
                // Generate random percent between 6% and 10%
                percentEaten = rand.nextInt(5) + 6;
            }
            if (tithingPaid > 12) {
                // Generate randome percent between 3% and 5%
                percentEaten = rand.nextInt(2) + 3;
            }
            if (tithingPaid >= 8 && tithingPaid <= 12) {
                // tithingPaid between 8% and 12%, inclusive
                // Generate random percent between 3% and 7%
                percentEaten = rand.nextInt(5) + 3;
            }
        } else { // randomNum not less than 30
            percentEaten = 0;
        }
        bushelsEaten = (percentEaten * wheatInStore) / 100;
        game.setEatenByRats(bushelsEaten);
    }

    public static void starvedPopulation(Game game, int wheatForPop)
            throws GameControlException {
        //Hayden
        int totalWheatNeeded = (game.getCurrentPopulation() * 20);
        int starvedPopulation;
        int wheatInStore = game.getWheatInStorage();
        int currentPopulation = game.getCurrentPopulation();
        if (wheatForPop <= 0) {
            throw new GameControlException("wheat in store must be >= feed population or cannot be zero");
        }

        if (wheatForPop > wheatInStore) {
            throw new GameControlException("Wheat feed to population must be less then wheat in store");
        }
        
        else if (wheatForPop < totalWheatNeeded){
            starvedPopulation = (totalWheatNeeded - wheatForPop)/20;
            game.setCurrentPopulation(currentPopulation - starvedPopulation);
            game.setWheatInStorage(wheatInStore - wheatForPop);
            game.setStarvedPopulation(starvedPopulation);
        }

        else if (totalWheatNeeded > wheatInStore) {
            starvedPopulation = currentPopulation - (wheatInStore / 20);
            int newCurrentPop = currentPopulation - starvedPopulation;
            int newWheatInStorage = wheatInStore - wheatForPop;
            
            game.setCurrentPopulation(newCurrentPop);
            game.setWheatInStorage(newWheatInStorage);
            game.setStarvedPopulation(starvedPopulation);
            
        } else {
            game.setCurrentPopulation(currentPopulation);
            game.setWheatInStorage(wheatInStore - wheatForPop);
            game.setStarvedPopulation(0);
        }
    }
        
}