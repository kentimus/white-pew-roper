/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;
import cityofaaron.model.Map;
import cityofaaron.model.Location;
import cityofaaron.model.Point;

/**
 *
 * @author willi
 */
public class MapControl {

    private static Location[][] createLocations(int rows,
            int columns)
    
    private static void Hints()   

    private static void assignHintsToLocations(Question[] questions,
            Scene[] scenes)

    private static void assignItemsToScenes(InventoryItem[] items,
            Scene[] scenes)

    private static void assignScenesToLocations(
            Scene[] scenes,
            Location[][] locations)
            
        /*
    public static Map createMap( int noOfRows, int noOfColumns){
        // create point for map and save the map to the game
        Point point = new Point();
        point.setColumn(0);
        point.setRow(0);
        
        Map map = new Map();
        map.setCurrentLocation(point);
     */   
    }

    
    
    public int[] newLocation(int row, int column){
        // Kent
        
        int location[] = {0,0};
        
        //row has to be between 1 and 5
        if(row < 1 || row > 5){
            location[0] = -1;
            return location;
        }
        
        // column has to be between 1 and 5
        if(column < 1 || column > 5){
            location[0] = -1;
            return location;
        }
        
        location[0] = row;
        location[1] = column;
        return location;
    } 
}
