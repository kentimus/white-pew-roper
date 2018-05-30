/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;
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

public int feedPopulation(){
    //will
}

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
	if (cost < wheatInStore) {
		//not enough wheat in store
		Return -1;
        }
        else{ // no error conditions met, so proceed
            game.setAcresOwned = (acresRequested + game.getAcresOwned);
                        }
}

public int acresPlanted(){
    //will
}

public int offeringPercentage(){
    //hayden
}

public int wheatHarvested(){
//Will
}

public int wheatFromOffering(){
    //hayden
}

public int wheatEatenByRats(){
//Kent    
}

public int starvedPopulation(){
//Hayden
}
    
}

