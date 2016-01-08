package testsHI931;

import automatedTestFramework.BasicFunctions;

public class SettingsTest {
	BasicFunctions basicFunction = new BasicFunctions();
	
	public boolean checkSettingsHeader(){
		boolean result = false;
		
		basicFunction.goToMainMenu();
		basicFunction.goToSettingsMenu();
		if (basicFunction.checkIfExist("SettingsHeader.JPG")){
			result = true;
		}
		return result;
	}
	
	public boolean checkSettingsMenuItems(){
		boolean result = false;
		basicFunction.goToMainMenu();
		basicFunction.goToSettingsMenu();
		if (basicFunction.checkIfExist("SettingsMenu1.JPG")){
			basicFunction.clickIfExist("Right.JPG");
			if(basicFunction.checkIfExist("SettingsMenu2.JPG")){
				result = true;
			}
		}
		return result;
	}
}
