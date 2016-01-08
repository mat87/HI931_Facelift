package testsHI931;

import automatedTestFramework.BasicFunctions;


public class CleanScreenTest {
	BasicFunctions basicFunction = new BasicFunctions();
	
	public boolean checkClearScreen(){
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
		}
		return result;
	}
	
	
	
}
