package testsHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Constants;

import java.net.*;


public class PopupTest {
	
	BasicFunctions basicFunction = new BasicFunctions();
	
	/****************************************************************************************
	 * Send Fault Pop-up to HI931 and check if occurred
	 * 
	 * @param s			Socket to HI931  
	 * @return result	result of test case 
	 */
	public boolean checkFaultPopup(Socket s){
		boolean result = false;
		basicFunction.goToMainMenu();
		basicFunction.insertValueToHI931(s,Constants.FAULT_POPUP);
		if (basicFunction.checkIfExist("FaultPopup.JPG")){
			basicFunction.clickIfExist("ConfirmButton.JPG");
			result = true;
		}
		return result;
	}
	/****************************************************************************************
	 * Send message to HI931 (pop-up) and check if pop-up window is visible
	 * 
	 * @param s				 		Socket to HI931
	 * @param popup			 		message send to HI931 to display proper pop-up window  
	 * @param chcheckScreen	 		screen image (pop-up) which should be disappeared after send pop-up message
	 * @param confirmBtn 	 		confirm button (e.g Confirm, OK)
	 * @param screenAfterConfirmed	screen which should be available after pop-up confirmed
	 * @return result		 		result of test case
	 */
	public boolean checkPopup(Socket s, String popup, String checkScreen, String confirmBtn, String screenAfterConfirmed){
		boolean result = false;
		basicFunction.goToMainMenu();
		basicFunction.insertValueToHI931(s, popup);
		if(basicFunction.checkIfExist(checkScreen)){
			basicFunction.clickIfExist(confirmBtn);
			if(basicFunction.checkIfExist(screenAfterConfirmed)){
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
		basicFunction.goToMainMenu();
		basicFunction.insertValueToHI931(s, popup);
		if(basicFunction.checkIfExist(chcheckScreen)){
			Thread.sleep(timeout);
			if(basicFunction.checkIfExist(screenAfterTimeout)){
				result = true;
			}
		}
		return result;
	}
}
