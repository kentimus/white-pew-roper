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
 * @author kent
 */
public class MapControlTest {
    
    public MapControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of newLocation method, of class MapControl.
     */
    @Test
    public void testNewLocation1() {
        System.out.println("newLocation1");
        int row = 1;
        int column = 1;
        MapControl instance = new MapControl();
        int[] expResult = {1,1};
        int[] result = instance.newLocation(row, column);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testNewLocation2() {
        System.out.println("newLocation2");
        int row = 0;
        int column = 1;
        MapControl instance = new MapControl();
        int[] expResult = {-1,0};
        int[] result = instance.newLocation(row, column);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testNewLocation3() {
        System.out.println("newLocation3");
        int row = 1;
        int column = 6;
        MapControl instance = new MapControl();
        int[] expResult = {-1,0};
        int[] result = instance.newLocation(row, column);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testNewLocation4() {
        System.out.println("newLocation4");
        int row = 1;
        int column = 5;
        MapControl instance = new MapControl();
        int[] expResult = {1,5};
        int[] result = instance.newLocation(row, column);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testNewLocation5() {
        System.out.println("newLocation5");
        int row = 5;
        int column = 1;
        MapControl instance = new MapControl();
        int[] expResult = {5,1};
        int[] result = instance.newLocation(row, column);
        assertArrayEquals(expResult, result);
    }
    
}
