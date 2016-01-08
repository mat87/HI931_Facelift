package testsHI931;

import automatedTestFramework.BasicFunctions;
import java.net.*;

public class PopupTest {
	BasicFunctions basicFunction = new BasicFunctions();
	
	public boolean checkPopup(Socket s){
		boolean result = false;
		
		basicFunction.goToMainMenu();
		basicFunction.insertValueToHI931(s,Const.faultPopup);
		if (basicFunction.checkIfExist("FaultPopup.JPG")){
			basicFunction.clickIfExist("ConfirmButton.JPG");
			result = true;
			
		}
		return result;
	}
}
