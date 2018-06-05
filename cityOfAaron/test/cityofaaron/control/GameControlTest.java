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
    */
    @Test
    public void testNewPopulation1() {
        System.out.println("newPopulation test 1");
        GameControl instance = new GameControl();
        int currentPopulation = 1000;
        int expResult = 1010;
        int result = instance.newPopulation(currentPopulation);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNewPopulation2() {
        System.out.println("newPopulation test 2");
        GameControl instance = new GameControl();
        int currentPopulation = -1;
        int expResult = -1;
        int result = instance.newPopulation(currentPopulation);
        assertEquals(expResult, result);
    }
    
    public void testNewPopulation3() {
        System.out.println("newPopulation test 3");
        GameControl instance = new GameControl();
        int currentPopulation = 0;
        int expResult = -1;
        int result = instance.newPopulation(currentPopulation);
        assertEquals(expResult, result);
    }

    /**
     * Test of pricePerAcre method, of class GameControl.
    */
    @Test
    public void testPricePerAcre() {
        System.out.println("pricePerAcre");
        GameControl instance = new GameControl();
        int expResult = 0;
        int result = instance.pricePerAcre();
        System.out.println(result);
        System.out.println("");
        assertTrue(result >= 17 && result <= 27);
        
    }

    //test of sellAcres method, of class GameControl.
     
    @Test
    public void testSellAcres1() {
        System.out.println("sellAcres test 1");
        int acresToSell = 10;
        int pricePerAcre = 20;
        int acresOwned = 100;
        GameControl instance = new GameControl();
        int expResult = 200;
        int result = instance.sellAcres(acresToSell, pricePerAcre, acresOwned);
        assertEquals(expResult, result);
    }

        @Test
    public void testSellAcres2() {
        System.out.println("sellAcres test 2");
        int acresToSell = -1;
        int pricePerAcre = 20;
        int acresOwned = 100;
        GameControl instance = new GameControl();
        int expResult = -1;
        int result = instance.sellAcres(acresToSell, pricePerAcre, acresOwned);
        assertEquals(expResult, result);
    }
        @Test
    public void testSellAcres3() {
        System.out.println("sellAcres test 3");
        int acresToSell = 76;
        int pricePerAcre = 20;
        int acresOwned = 75;
        GameControl instance = new GameControl();
        int expResult = -1;
        int result = instance.sellAcres(acresToSell, pricePerAcre, acresOwned);
        assertEquals(expResult, result);
    }
        @Test
    public void testSellAcres4() {
        System.out.println("sellAcres test 4");
        int acresToSell = 100;
        int pricePerAcre = 20;
        int acresOwned = 100;
        GameControl instance = new GameControl();
        int expResult = 2000;
        int result = instance.sellAcres(acresToSell, pricePerAcre, acresOwned);
        assertEquals(expResult, result);
    }
        @Test
    public void testSellAcres5() {
        System.out.println("sellAcres test 5");
        int acresToSell = 0;
        int pricePerAcre = 20;
        int acresOwned = 100;
        GameControl instance = new GameControl();
        int expResult = 0;
        int result = instance.sellAcres(acresToSell, pricePerAcre, acresOwned);
        assertEquals(expResult, result);
    }
    
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

    @Test
    public void testBuyAcres2() {
        System.out.println("buyAcres test 2");
        int acresRequested = 20;
        int pricePerAcre = 20;
        int wheatInStore = 0;
        GameControl instance = new GameControl();
        int expResult = -1;
        int result = instance.buyAcres(acresRequested, pricePerAcre, wheatInStore);
        assertEquals(expResult, result);       
    }

    @Test
    public void testBuyAcres3() {
        System.out.println("buyAcres test 3");
        int acresRequested = -1;
        int pricePerAcre = 20;
        int wheatInStore = 1000;
        GameControl instance = new GameControl();
        int expResult = -1;
        int result = instance.buyAcres(acresRequested, pricePerAcre, wheatInStore);
        assertEquals(expResult, result);       
    }

    @Test
    public void testBuyAcres4() {
        System.out.println("buyAcres test 4");
        int acresRequested = 20;
        int pricePerAcre = 17;
        int wheatInStore = 1000;
        GameControl instance = new GameControl();
        int expResult = 20;
        int result = instance.buyAcres(acresRequested, pricePerAcre, wheatInStore);
        assertEquals(expResult, result);       
    }

    @Test
    public void testBuyAcres5() {
        System.out.println("buyAcres test 5");
        int acresRequested = 20;
        int pricePerAcre = 27;
        int wheatInStore = 1000;
        GameControl instance = new GameControl();
        int expResult = 20;
        int result = instance.buyAcres(acresRequested, pricePerAcre, wheatInStore);
        assertEquals(expResult, result);       
    }

    @Test
    public void testBuyAcres6() {
        System.out.println("buyAcres test 6");
        int acresRequested = 0;
        int pricePerAcre = 20;
        int wheatInStore = 1000;
        GameControl instance = new GameControl();
        int expResult = 0;
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

 // Test of wheatHarvested method, of class GameControl.
     
    /*@Test
    public void testWheatHarvested1() {
        System.out.println("wheatHarvested test 1");
        GameControl instance = new GameControl();
        int acresPlanted = 200;
        double tithingPaid = .08;

        double result = instance.wheatHarvested(acresPlanted, tithingPaid);
        assertThat(wheatHarvested.isBetween(400, 800));
    }
    */

    /**
     * Test of wheatEatenByRats method, of class GameControl.
    */
    @Test
    public void testWheatEatenByRats1() {
        System.out.println("wheatEatenByRats test 1");
        GameControl instance = new GameControl();
        int wheatInStore = 2000;
        double tithingPaid = .08;
        int rando = 20;
        double expResult = 100;
        double result = instance.wheatEatenByRats(wheatInStore, tithingPaid, rando);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testWheatEatenByRats2() {
        System.out.println("wheatEatenByRats test 2");
        GameControl instance = new GameControl();
        int wheatInStore = -1;
        double tithingPaid = .08;
        int rando = 20;
        double expResult = -1;
        double result = instance.wheatEatenByRats(wheatInStore, tithingPaid, rando);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testWheatEatenByRats3() {
        System.out.println("wheatEatenByRats test 3");
        GameControl instance = new GameControl();
        int wheatInStore = 2000;
        double tithingPaid;
        tithingPaid = -1;
        int rando = 20;
        double expResult = -1;
        double result = instance.wheatEatenByRats(wheatInStore, tithingPaid, rando);
        assertEquals(expResult, result, 0.0);
    }
    
        @Test
    public void testWheatEatenByRats4() {
        System.out.println("wheatEatenByRats test 4");
        GameControl instance = new GameControl();
        int wheatInStore = 2000;
        double tithingPaid = 0.08;
        int rando = 100;
        double expResult = 0;
        double result = instance.wheatEatenByRats(wheatInStore, tithingPaid, rando);
        assertEquals(expResult, result, 0.0);
    }
    
        @Test
    public void testWheatEatenByRats5() {
        System.out.println("wheatEatenByRats test 5");
        GameControl instance = new GameControl();
        int wheatInStore = 2000;
        double tithingPaid = 0.08;
        int rando = 1;
        double expResult = 100;
        double result = instance.wheatEatenByRats(wheatInStore, tithingPaid, rando);
        assertEquals(expResult, result, 0.0);
    }
    
        @Test
    public void testWheatEatenByRats6() {
        System.out.println("wheatEatenByRats test 6");
        GameControl instance = new GameControl();
        int wheatInStore = 2000;
        double tithingPaid = 0;
        int rando = 20;
        double expResult = 160;
        double result = instance.wheatEatenByRats(wheatInStore, tithingPaid, rando);
        assertEquals(expResult, result, 0.0);
    }
    
        @Test
    public void testWheatEatenByRats7() {
        System.out.println("wheatEatenByRats test 7");
        GameControl instance = new GameControl();
        int wheatInStore = 2000;
        double tithingPaid = 0.121;
        int rando = 20;
        double expResult = 100;
        double result = instance.wheatEatenByRats(wheatInStore, tithingPaid, rando);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of starvedPopulation method, of class GameControl.
     */
    @Test
    public void testStarvedPopulation1() {
        System.out.println("starvedPopulation 1");
        int currentPopulation = 108;
        int feedPopulation = 2000;
        int wheatInStore = 2800;
        GameControl instance = new GameControl();
        int expResult = 8;
        int result = instance.starvedPopulation(currentPopulation, feedPopulation, wheatInStore);
        assertEquals(expResult, result);       
    }
    
    @Test
    public void testStarvedPopulation2() {
        System.out.println("starvedPopulation 2");
        int currentPopulation = 100;
        int feedPopulation = -200;
        int wheatInStore = 2800;
        GameControl instance = new GameControl();
        int expResult = -1;
        int result = instance.starvedPopulation(currentPopulation, feedPopulation, wheatInStore);
        assertEquals(expResult, result);       
    }
    
    @Test
    public void testStarvedPopulation3() {
        System.out.println("starvedPopulation 3");
        int currentPopulation = 100;
        int feedPopulation = 3000;
        int wheatInStore = 2800;
        GameControl instance = new GameControl();
        int expResult = -1;
        int result = instance.starvedPopulation(currentPopulation, feedPopulation, wheatInStore);
        assertEquals(expResult, result);       
    }
    
    @Test
    public void testStarvedPopulation4() {
        System.out.println("starvedPopulation 4");
        int currentPopulation = 100;
        int feedPopulation = 0;
        int wheatInStore = 2800;
        GameControl instance = new GameControl();
        int expResult = 100;
        int result = instance.starvedPopulation(currentPopulation, feedPopulation, wheatInStore);
        assertEquals(expResult, result);       
    }
     @Test
    public void testStarvedPopulation5() {
        System.out.println("starvedPopulation 5");
        int currentPopulation = 140;
        int feedPopulation = 2800;
        int wheatInStore = 2800;
        GameControl instance = new GameControl();
        int expResult = 0;
        int result = instance.starvedPopulation(currentPopulation, feedPopulation, wheatInStore);
        assertEquals(expResult, result);       
    }
}
