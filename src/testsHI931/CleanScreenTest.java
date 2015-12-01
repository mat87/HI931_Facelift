package testsHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;


public class CleanScreenTest {
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();
	
	public boolean checkClearScreen(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkClearScreen() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		basicFunction.goToSettingsMenu();
		basicFunction.clickIfExist("Right.JPG");
		basicFunction.clickIfExist("CleanScreenButton.JPG");
		basicFunction.clickIfExist("CleanScreen.JPG");
		try{
			Thread.sleep(70000);
		}catch (Exception e)
			{System.out.println("Something went wrong while waiting");
		};
		if (basicFunction.checkIfExist("CleanScreenMenu.JPG")){
				result = true;
				System.out.println("Clean screen works correctly.");			
				System.out.println("Test: Success" + '\n' + log.separator);
		}else{
			System.out.println("Clean screen works not correctly.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
	
	
	
}
