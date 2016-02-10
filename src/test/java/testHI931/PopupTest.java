package testHI931;

import testFramework.Driver;
import testFramework.Connection;
import testFramework.GUIElement;
import java.net.*;


public class PopupTest {

    Driver driver;
    Connection connect;
    GUIElement guielem;

    public PopupTest(){
        driver = new Driver();
        connect = new Connection();
        guielem = new GUIElement();
    }

    /****************************************************************************************
     * Send message to HI931 (pop-up) and check if pop-up window is visible
     *
     * @param s				 		Socket to HI931
     * @param popup			 		message send to HI931 to display proper pop-up window
     * @param checkScreen	 		screen image (pop-up) which should be disappeared after send pop-up message
     * @param confirmBtn 	 		confirm button (e.g Confirm, OK)
     * @param screenAfterConfirmed	screen which should be available after pop-up confirmed
     * @return result		 		result of test case
     */
    public boolean checkPopup(Socket s, String popup, String checkScreen, String confirmBtn, String screenAfterConfirmed){
        boolean result = false;
        driver.goToMainMenu();
        connect.sendMessageToHI(s,popup);
        if(guielem.checkIfExist(checkScreen)){
            guielem.clickIfExist(confirmBtn);
            if(guielem.checkIfExist(screenAfterConfirmed)){
                result = true;
            }
        }
        return result;
    }
    /****************************************************************************************
     * Check if will disappears after specified timeout
     *
     * @param s						Socket to HI931
     * @param popup					message send to HI931 to display proper pop-up window
     * @param chcheckScreen	 		screen image (pop-up) which should be disappeared after send popup message
     * @param screenAfterTimeout	screen which should be visible after popup timeout
     * @param timeout				time after what popup will disappears
     * @return result				result of test case
     * */
    public boolean checkPopupTimeout(Socket s, String popup, String chcheckScreen, String screenAfterTimeout, long timeout) throws InterruptedException{
        boolean result = false;
        driver.goToMainMenu();
        connect.sendMessageToHI(s, popup);
        if(guielem.checkIfExist(chcheckScreen)){
            Thread.sleep(timeout);
            if(guielem.checkIfExist(screenAfterTimeout)){
                result = true;
            }
        }
        return result;
    }
}