package testsHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;
import java.net.*;

public class PopupTest {
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();	
	
	public boolean checkPopup(Socket s){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkPopup() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		
		basicFunction.goToMainMenu();
		basicFunction.insertValueToHI931(s,Const.faultPopup);
		if (basicFunction.checkIfExist("FaultPopup.JPG")){
			result = true;
			System.out.println("Fault popup is correct.");			
			System.out.println("Test: Success" + '\n' + log.separator);
		}else{
			System.out.println("Fault popup is not correct.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
}
