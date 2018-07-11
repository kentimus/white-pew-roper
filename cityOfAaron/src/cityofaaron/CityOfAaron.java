/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron;

import cityofaaron.model.Game;
//import cityofaaron.model.Player;
import cityofaaron.view.StartProgramView;
import cityofaaron.view.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/**
 *
 * @author kent
 */
public class CityOfAaron {

    // keep a copy of the current game in the main class
    public static Game currentGame = null;

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game game) {
        currentGame = game;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CityOfAaron.inFile = new BufferedReader(new InputStreamReader(System.in));
            CityOfAaron.outFile = new PrintWriter(System.out, true);
            
            View startProgramView = new StartProgramView();
            startProgramView.displayView();
        } catch (Throwable te) {
            System.out.println("Something went horrible wrong, so sorry, try again.");
            System.out.println(te.getMessage());
            te.printStackTrace();
            return;
        }
        finally {
            try {
            if (CityOfAaron.inFile != null)   
            CityOfAaron.inFile.close();
            
            if (CityOfAaron.outFile != null)
            CityOfAaron.outFile.close();
        
            }
            catch(IOException ex) {
                System.out.println("file not closed correctly");
                return;
            }
        }
    }
            

    public static PrintWriter getOutFile() {
        return outFile;

    }

    public static void setOutFile(PrintWriter outFile) {
        CityOfAaron.outFile = outFile;

    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        CityOfAaron.inFile = inFile;
    }
}
