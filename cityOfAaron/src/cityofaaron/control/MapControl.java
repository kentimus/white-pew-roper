/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;
import cityofaaron.model.Map;
import cityofaaron.model.Location;

/**
 *
 * @author willi
 */
public class MapControl {
    public static Map createMap( int noOfRows, int noOfColumns){
        if(noOfRows < 0 || noOfColumns < 0){
            return null;
        }
        
        Map map = new Map();
        
        
        Location[][] map.locations = createLocations(noOfRows, noOfColumns, map);


//       locations = createLocations(noOfRows, noOfColumns)
//       Assign the locations array to the map

         return map;
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
