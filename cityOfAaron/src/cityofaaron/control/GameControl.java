/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;

import cityofaaron.CityOfAaron;
import cityofaaron.model.Player;
import cityofaaron.model.Game;
import cityofaaron.model.Map;
import cityofaaron.model.Author;
import cityofaaron.model.Storehouse;
import cityofaaron.model.Provision;
import cityofaaron.model.Tool;
import java.util.Random;
//import cityofaaron.control.MapControl

/**
 *
 * @author willi
 */
public class GameControl {

    public static Game createNewGame(String playerName) {

        // this createsa new game  
        Game game = new Game();

        // this creates a new player object 
        // and assigns the player to the game
        try {
            Player player = new Player();
            player.setName(playerName);
            game.setThePlayer(player);

            System.out.println("\n**New Player created**");
        } catch (Exception e) {
            System.out.println("\n**FAILED TO CREATE NEW PLAYER**\n");
        }

        //build the storehouse
        Storehouse storehouse = new Storehouse();
        game.setStorehouse(storehouse);

        System.out.println("\n**Storehouse created**");

        // create authors , populate an array and
        //add it to the storehouse
        try {
            Author[] authors = new Author[3];

            authors[0] = new Author("Hayden Pew", "SupremeAlliedCommander");
            authors[1] = new Author("Kent Roper", "Chief Complainer");
            authors[2] = new Author("Will White", "White Boy");

            storehouse.setAuthors(authors);

            System.out.println("\n**Authors are set**");
        } catch (Exception e) {
            System.out.println("\n**FAILED TO CREATE AUTHORS**\n");
        }

        try {
            Provision[] provisions = new Provision[3];

            provisions[0] = new Provision("Goat milk", 2);
            provisions[1] = new Provision("dates", 10);
            provisions[2] = new Provision("Twizzlers", 1000);

            storehouse.setProvisions(provisions);

            System.out.println("\n**Provisions added**");
        } catch (Exception e) {
            System.out.println("\n**FAILED TO ADD PROVISIONS**\n");
        }
        
        try {
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

            System.out.println("\n**Tools are set**");
        } catch (Exception e) {
            System.out.println("\n**FAILED TO CREATE TOOLS**\n");
        }

        try {
            Map map = MapControl.createMap();
            game.setTheMap(map);

            System.out.println("\n**Map Created**");
        } catch (Exception e) {
            System.out.println("\n**FAILED TO CREATE MAP**\n");
        }

        //Save a reference to the game in the main class
        CityOfAaron.setCurrentGame(game);

        return game;

    }

    public int newPopulation(int currentPopulation) {
        //Kent
        int addedPopulation;
        int newPopulation;

        //currentPopulation needs to be greater than zero
        if (currentPopulation <= 0) {
            return -1;
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

    public int sellAcres(int acresToSell, int pricePerAcre, int acresOwned) {
        //Hayden   
        if (acresToSell < 0 || acresToSell > acresOwned) {
            return -1;
        } else {
            int wheatFromAcres = (acresToSell * pricePerAcre);
            return wheatFromAcres;
        }
    }

    public int buyAcres(int acresRequested, int pricePerAcre, int wheatInStore) {
        //group

        if (acresRequested < 0) {
            return -1;
        }

        // get request cost
        int cost = (acresRequested * pricePerAcre);
        if (cost > wheatInStore) {
            //not enough wheat in store
            return -1;
        } else {
            int acresBought = acresRequested;
            return acresBought;
        }
    }

    public int acresPlanted(int acresRequested, int wheatInStore) {
        //will
        Random rand = new Random();
        int acresPlanted;
        int low;
        int high;

        if (acresRequested < 0) {
            return -1;
        }
        low = 17;
        high = 27;
        int cost = (acresRequested * (rand.nextInt(high - low) + low));
        if (cost > wheatInStore) {
            //not enough wheat in store
            return -1;
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
    public double wheatEatenByRats(int wheatInStore, double tithingPaid, int rando) {
        //Kent
        int percentEaten = 0;
        int bushelsEaten;

        // wheatInStore can't be below zero
        if (wheatInStore < 0) {
            return -1;
        }

        // tithingPaid can't be below zero
        if (tithingPaid < 0) {
            return -1;
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

    public int starvedPopulation(int currentPopulation, int feedPopulation, int wheatInStore) {
        //Hayden
        int totalWheatNeeded = currentPopulation * 20;
        int starvedPopulation;

        if (feedPopulation < 0 || feedPopulation > wheatInStore) {
            return -1;
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
