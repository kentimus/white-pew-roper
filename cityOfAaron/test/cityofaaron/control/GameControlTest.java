/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pewst
 */
public class GameControlTest {
    
    public GameControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of newPopulation method, of class GameControl.
     
    @Test
    public void testNewPopulation() {
        System.out.println("newPopulation");
        GameControl instance = new GameControl();
        int expResult = 0;
        int result = instance.newPopulation();
        assertEquals(expResult, result);
        
    }*/

    /**
     * Test of pricePerAcre method, of class GameControl.
     
    @Test
    public void testPricePerAcre() {
        System.out.println("pricePerAcre");
        GameControl instance = new GameControl();
        int expResult = 0;
        int result = instance.pricePerAcre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of sellAcres method, of class GameControl.
     
    @Test
    public void testSellAcres() {
        System.out.println("sellAcres");
        GameControl instance = new GameControl();
        int expResult = 0;
        int result = instance.sellAcres();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of buyAcres method, of class GameControl.
     */
    @Test
    public void testBuyAcres() {
        System.out.println("buyAcres test 1");
        int acresRequested = 20;
        int pricePerAcre = 20;
        int wheatInStore = 1000;
        GameControl instance = new GameControl();
        int expResult = 20;
        int result = instance.buyAcres(acresRequested, pricePerAcre, wheatInStore);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of acresPlanted method, of class GameControl.
     
    @Test
    public void testAcresPlanted() {
        System.out.println("acresPlanted");
        GameControl instance = new GameControl();
        int expResult = 0;
        int result = instance.acresPlanted();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of wheatHarvested method, of class GameControl.
     
    @Test
    public void testWheatHarvested() {
        System.out.println("wheatHarvested");
        GameControl instance = new GameControl();
        int expResult = 0;
        int result = instance.wheatHarvested();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of wheatEatenByRats method, of class GameControl.
     
    @Test
    public void testWheatEatenByRats() {
        System.out.println("wheatEatenByRats");
        GameControl instance = new GameControl();
        int expResult = 0;
        int result = instance.wheatEatenByRats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of starvedPopulation method, of class GameControl.
     */
    @Test
    public void testStarvedPopulation() {
        System.out.println("starvedPopulation");
        int currentPopulation = 0;
        int feedPopulation = 0;
        int wheatInStore = 0;
        GameControl instance = new GameControl();
        int expResult = 0;
        int result = instance.starvedPopulation(currentPopulation, feedPopulation, wheatInStore);
        assertEquals(expResult, result);
       
    }
    
}
