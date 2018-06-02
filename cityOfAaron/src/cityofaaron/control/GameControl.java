/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;
import cityofaaron.model.Game;
import java.util.Random;


/**
 *
 * @author willi
 */
public class GameControl {

    public int newPopulation (int currentPopulation){
        //Kent
        int addedPopulation;
        int newPopulation;
        
        //currentPopulation needs to be greater than zero
        if(currentPopulation <= 0){
            return -1;
        }
    
        Random rand = new Random(0);
        // get randomNumber between 1 and 5, inclusive
        int randomNum = rand.nextInt(5) + 1;
        addedPopulation = (currentPopulation * randomNum) / 100;
        newPopulation = addedPopulation + currentPopulation;
        return newPopulation;
}

   
    
    public int pricePerAcre(){
        //kent
        Random rand = new Random();
        // get randomNumber between 17 and 27, inclusive
        int pricePerAcre = rand.nextInt(11) + 17;
        return pricePerAcre;
    }



/*public int sellAcres(){
    //will
}
    */

public int buyAcres(int acresRequested, int pricePerAcre, int wheatInStore){
//group
                
	if (acresRequested < 0) {
		return -1;
        }

	// get request cost
	int cost = (acresRequested * pricePerAcre);
	if (cost > wheatInStore) {
		//not enough wheat in store
		return -1;
        }
        else{ int acresBought = acresRequested;
		return acresBought;
            }
}

/*public int acresPlanted(){
    //will
}
*/

/*public int offeringPercentage(int wheatInStore){
    //hayden
   Not sure we need this since the offering percentage will be 
    coming from the view layer  
}*/

/*public int wheatHarvested(){
//Will
//public int wheatHarvested(int acresPlanted, int randNum){
//Will
//import.java.util.Random;
//int n = rand.nextInt(acresPlanted) + 1
//    if (randNum > acresPlanted OR randNum < 1) {
//        return -1;
//        }
//    else{ // randNum is between 1 and acres planted
//            return randNum;
//        }

//        }

}
*/


    // argument "rando" temporary for testing
    public double wheatEatenByRats(int wheatInStore, double tithingPaid, int rando){
        //Kent
        int percentEaten = 0;
        int bushelsEaten;
        
        // wheatInStore can't be below zero
	if(wheatInStore  < 0){
            return -1;
        }
        
        // tithingPaid can't be below zero
	if(tithingPaid < 0){
            return -1;
        }
        // create instance of Random class
        Random rand = new Random(5);
        //int randomNum = rand.nextInt(100);
        
        //temporary line, for testing
        int randomNum = rando;
	if(randomNum  < 30){
            if(tithingPaid < .08){
                // Generate random percent between 6% and 10%
                percentEaten =  rand.nextInt(5) + 6;
            }
            if(tithingPaid > .12){
                // Generate randome percent between 3% and 5%
                percentEaten = rand.nextInt(3) + 3;
            }
            if(tithingPaid >= .08 && tithingPaid <= .12){
                // tithingPaid between 8% and 12%, inclusive
                // Generate random percent between 3% and 7%
                percentEaten = rand.nextInt(5) + 3;
            }		
        } 
		
        else{ // randomNum not less than 30
            percentEaten = 0;
        }
	bushelsEaten = (percentEaten * wheatInStore) /100;
	return bushelsEaten;
    }

public int starvedPopulation(int currentPopulation, int feedPopulation, int wheatInStore){
//Hayden
    int totalWheatNeeded = currentPopulation * 20;
    int starvedPopulation = currentPopulation - (feedPopulation/20) ;

    if (feedPopulation < 0 || feedPopulation > wheatInStore) {
        return -1;
        }
    else if (totalWheatNeeded > wheatInStore){
       return starvedPopulation; 
    }
    else starvedPopulation = 0;
        return starvedPopulation;
}
    
}
