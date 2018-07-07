/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;

import cityofaaron.model.Map;
import cityofaaron.model.Location;
import cityofaaron.exceptions.MapControlException;

/**
 *
 * @author willi
 */
public class MapControl {

    public static Map createMap() throws MapControlException {
        Map map = new Map();
        
        try{
            
            Location[][] locations = createLocations();
            map.setLocations(locations);

            
        } catch (Throwable te) {
            throw new MapControlException("--- Map not created ---\n");
        }
        return map;
    }

    public static Location[][] createLocations() throws MapControlException {
        try {
        // list of hints
        String wheatHint = "Wheat is yummy. Each Citizen needs 20 Bushels per Year.";
        String riverHint = "Praying the rats drown in the river? Paying tithing makes that more likely.";
        String undevelopedHint = "Buying more land lets you plant more wheat. Smart people buy when the price "
                + "is around 17 bushels per acre.";
        String lamaniteHint = "It's nice we aren't at war with the Lamanites right now. It's bad enough "
                + "dealing with rats.";
        String courtHint = "Think carefully before living out each year. Your rule will be cut short if you "
                + "make poor choices.";
        String villageHint = "You can sell some of your land. Smart people sell when the price is near 27"
                + " bushels per acre.";
        String granaryHint = "Smart rulers don't spend all their wheat, just in cases of a poor harvest.";
        String templeHint = "You can pay more than 10% tithing to get extra blessings, but paying more than"
                + " 13% doesn't give you additional value. Be a wise steward.";

        //List of locations 
        Location[][] locations = new Location[5][5];

        locations[0][0] = new Location("Wheat", "Wheat Field", "W", wheatHint);
        locations[0][1] = new Location("River", "The Great River Sidon", "R", riverHint);
        locations[0][2] = new Location("Undeveloped Land", "Not much here.", "U", undevelopedHint);
        locations[0][3] = new Location("Undeveloped Land", "Not much here.", "U", undevelopedHint);
        locations[0][4] = new Location("Lamanite Border", "Lamanites live just beyond that fence.", "L", lamaniteHint);

        locations[1][0] = new Location("Wheat", "Wheat Field", "W", wheatHint);
        locations[1][1] = new Location("Wheat", "Wheat Field", "W", wheatHint);
        locations[1][2] = new Location("River", "The Great River Sidon", "R", riverHint);
        locations[1][3] = new Location("Undeveloped Land", "Not much here.", "U", undevelopedHint);
        locations[1][4] = new Location("Lamanite Border", "Lamanites live just beyond that fence.", "L", lamaniteHint);

        locations[2][0] = new Location("Wheat", "Wheat Field", "W", wheatHint);
        locations[2][1] = new Location("Rulers Court", "Nice palace you have there!", "C", courtHint);
        locations[2][2] = new Location("Temple", "Don't forget your recommend!", "T", templeHint);
        locations[2][3] = new Location("River", "The Great River Sidon", "R", riverHint);
        locations[2][4] = new Location("Lamanite Border", "Lamanites live just beyond that fence.", "L", lamaniteHint);

        locations[3][0] = new Location("Wheat", "Wheat Field", "W", wheatHint);
        locations[3][1] = new Location("Village", "Well, technically a city", "V", villageHint);
        locations[3][2] = new Location("Granary", "... and Storehouse", "G", granaryHint);
        locations[3][3] = new Location("River", "The Great River Sidon", "R", riverHint);
        locations[3][4] = new Location("Lamanite Border", "Lamanites live just beyond that fence.", "L", lamaniteHint);

        locations[4][0] = new Location("Wheat", "Wheat Field", "W", wheatHint);
        locations[4][1] = new Location("Wheat", "Wheat Field", "W", wheatHint);
        locations[4][2] = new Location("Wheat", "Wheat Field", "W", wheatHint);
        locations[4][3] = new Location("River", "The Great River Sidon", "R", riverHint);
        locations[4][4] = new Location("Lamanite Border", "Lamanites live just beyond that fence.", "L", lamaniteHint); 

        return locations;
        } catch (Throwable te){
            throw new MapControlException("--- Locations not assigned to the map ---\n");
        }
    }

}
