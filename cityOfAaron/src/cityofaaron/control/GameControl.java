/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;
import cityofaaron.model.Game;
/**
 *
 * @author willi
 */
public class GameControl {

public int newPopulation (){
    //Kent
}

public int pricePerAcre(){
    //kent
}

/*public int feedPopulation(){
    //will
    We dont need this either. the user will be defining this and it will only 
be needed in the starvedPopulation method
}*/

public int sellAcres(){
    //will
}

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

public int acresPlanted(){
    //will
}

/*public int offeringPercentage(int wheatInStore){
    //hayden
   Not sure we need this since the offering percentage will be 
    coming from the view layer  
}*/

public int wheatHarvested(){
//Will
}

/*public int wheatFromOffering(){
    //hayden
we dont need this either, the bonus or penalty from offerings will be calculated 
inside the wheatHarvested Method
    
}*/

public int wheatEatenByRats(){
//Kent    
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