
package cityofaaron.view;

import java.util.Scanner;

/**
 *
 * @author pewst
 */
public abstract class ViewBase implements View{
    
    
    /** 
     * Constructor
     */
    public ViewBase(){
    }
    
    /**
    *get the view content, this will allow the view to have dynamic content(it can change each time the message is displayed) 
    */
    protected abstract String getMessage();
    
    /**get the inputs from the user
    *@return 
    */
    
    protected abstract String[] getInputs();
    
    /**
     * perform the action indicated by the users input
     * 
     * @param inputs
     * @return
     * true if the view should repeat itself and false if the view should exit and return to the previous view
     */

    public abstract boolean doAction(String[] inputs);
    
    /**
     * control this views display/prompt/action loop until the user chooses an action that causes this view to close
     */

    public void displayView(){
        boolean keepGoing = true;
        
        while(keepGoing == true){
            //get the message that should be displayed
            //only print it if it is none null
            String message = getMessage();
            if(message !=null){
                System.out.println(getMessage());
                        
            }
            String[] inputs = getInputs();
            keepGoing = doAction(inputs);
        }    
    }
    /**
     * get the users input keep prompting them until they enter it in
     * @param prompt
     * @param allowEmpty-determine weather the user can enter no value(just a return key)
     * @return
     */
    
    protected String getUserInput(String prompt, boolean allowEmpty){
        
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        boolean inputReceived = false;
        
        while(inputReceived == false){
            
            System.out.println(prompt);
            input = keyboard.nextLine();
            
            // Make sure we avoid a null-pointer error.
            if (input == null){
                input = "";
            }
            
            // Trim any trailing whitespace, including the carriage return.
            input = input.trim();
            
            if (input.equals("") == false || allowEmpty == true){
                inputReceived = true;
            }
        }
        
        return input;
    }
        /**
         * an overloaded version of getUserInput that sets allowEmpty to false so we dont have to type it ourselves
         * @paramPrompt
         * @return
         */
        protected String getUserInput(String prompt){
        return getUserInput(prompt, false);
    }
        //pause the program for a specific number of miliseconds
        protected static void pause(int milliseconds){
            try {
                Thread.sleep(milliseconds);
            } catch(InterruptedException exception){
                //do nothing
            }
        } 
} 


