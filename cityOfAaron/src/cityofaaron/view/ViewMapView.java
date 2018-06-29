package cityofaaron.view;
import cityofaaron.CityOfAaron;
import cityofaaron.model.Location;
import cityofaaron.model.Game;
import cityofaaron.model.Map;

/**
 *
 * @author hpew
 */
public class ViewMapView extends ViewBase {

    /**
     * Constructor
     */
    public ViewMapView() {
        super();
    }

    @Override
    protected String getMessage() {
        Game game = CityOfAaron.getCurrentGame();
        Map map = game.getTheMap();
        Location[][] l = map.getLocations();
        
        String mapDisplay = "\nHere's the Map!\n"
                + "    1   2   3   4   5\n"
                + "  |-------------------|\n"
                + "1 | " + l[0][0].gMS()  + " | " + l[0][1].gMS()  + " | " 
                        + l[0][2].gMS()  + " | " + l[0][3].gMS()  + " | " 
                        + l[0][4].gMS()   + " |     W = Wheat field\n"
                + "  |-------------------|     R = River\n"
                
                + "2 | " + l[1][0].gMS()  + " | " + l[1][1].gMS()  + " | " 
                        + l[1][2].gMS()  + " | " + l[1][3].gMS()  + " | " 
                        + l[1][4].gMS()   + " |     L = Lamanite border\n"
                + "  |-------------------|     V = Village\n"
                
                + "3 | " + l[2][0].gMS()  + " | " + l[2][1].gMS()  + " | " 
                        + l[2][2].gMS()  + " | " + l[2][3].gMS()  + " | " 
                        + l[2][4].gMS()   + " |     U = Undeveloped land\n"
                + "  |-------------------|     G = Granary/Storehouse\n"
                
                + "4 | " + l[3][0].gMS()  + " | " + l[3][1].gMS()  + " | " 
                        + l[3][2].gMS()  + " | " + l[3][3].gMS()  + " | " 
                        + l[3][4].gMS()   + " |     C = Ruler's Court\n"
                + "  |-------------------|     T = Temple\n"
            
                + "5 | " + l[4][0].gMS()  + " | " + l[4][1].gMS()  + " | " 
                        + l[4][2].gMS()  + " | " + l[4][3].gMS()  + " | " 
                        + l[4][4].gMS()   + " |\n"    
                + "  |-------------------|\n";
                
        
        return mapDisplay;
    }

    /**
     * Get the set of inputs from the user.
     *
     * @return
     */
    @Override
    public String[] getInputs() {

        //no inputs from this view, just diplay the map and return to the GameView
        return null;
    }

    /**
     * Perform the action indicated by the user's input.
     *
     * @param inputs
     * @return true if the view should repeat itself, and false if the view
     * should exit and return to the previous view.
     */
    @Override
    public boolean doAction(String[] inputs) {
        // no action jusr dispaly the map

        startGameMenuView();

        return false;
    }

    // Define your action handlers here. These are the methods that your doAction()
    // method will call based on the user's input. We don't want to do a lot of 
    // complex game stuff in our doAction() method. It will get messy very quickly.
    private void startGameMenuView(){ 
    //pause the program for a specific number of miliseconds
            try {
            Thread.sleep(4000);
        } catch (InterruptedException exception) {
            //do nothing
        }
    }
    
}
    
        //pause for a few seconds and return to Game Menu
    
