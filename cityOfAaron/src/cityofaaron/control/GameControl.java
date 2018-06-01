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

/*public int newPopulation (){
    //Kent
}
*/
   
    
/*public int pricePerAcre(){
    //kent
}
*/
    
/*public int feedPopulation(){
    //will
    We dont need this either. the user will be defining this and it will only 
be needed in the starvedPopulation method
}*/

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
}
*/

/*public int wheatFromOffering(){
    //hayden
we dont need this either, the bonus or penalty from offerings will be calculated 
inside the wheatHarvested Method
    
}*/

    public double wheatEatenByRats(int wheatInStore, double tithingPaid){
        //Kent
        double percentEaten;
        double bushelsEaten;
        
        // wheatInStore can't be below zero
	if(wheatInStore  < 0){
            return -1;
        }
        
        // tithingPaid can't be below zero
	if(tithingPaid < 0){
            return -1;
        }
        // create instance of Random class
        Random rand = new Random();
        int randomNum = rand.nextInt(100);
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
	bushelsEaten = percentEaten * wheatInStore;
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