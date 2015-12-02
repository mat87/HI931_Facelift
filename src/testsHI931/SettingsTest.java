package testsHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;

public class SettingsTest {
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();
	
	public boolean checkSettingsHeader(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkSettingsHeader() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		
		basicFunction.goToMainMenu();
		basicFunction.goToSettingsMenu();
		if (basicFunction.checkIfExist("SettingsHeader.JPG")){
			result = true;
			System.out.println("Settings header is correct.");			
			System.out.println("Test: Success" + '\n' + log.separator);
		}else{
			System.out.println("Settings header is not correct.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
	
	public boolean checkSettingsMenuItems(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkSettingsMenuItems() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		basicFunction.goToMainMenu();
		basicFunction.goToSettingsMenu();
		if (basicFunction.checkIfExist("SettingsMenu1.JPG")){
			basicFunction.clickIfExist("Right.JPG");
			if(basicFunction.checkIfExist("SettingsMenu2.JPG")){
				result = true;
				System.out.println("Settings Menu is correct.");			
				System.out.println("Test: Success" + '\n' + log.separator);
			}else{
				System.out.println("Settings Menu is not correct.");
				System.out.println("Test: Fail" + '\n' + log.separator);
			}
		}else{
			System.out.println("Settings Menu is not correct.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
}
