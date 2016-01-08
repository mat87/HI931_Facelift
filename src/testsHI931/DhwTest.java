package testsHI931;

import automatedTestFramework.BasicFunctions;

public class DhwTest {
	BasicFunctions basicFunction = new BasicFunctions();
	
	public boolean SetDhwTemperatureTest(){
		boolean result = true;
		
		basicFunction.goToMainMenu();

		//to be developed

		return result;
	}
	
	public boolean checkDhwMenu(){
		boolean result = false;
		
		basicFunction.goToMainMenu();
		basicFunction.goToDhwMenu();
		if (basicFunction.checkIfExist("DhwMenuHeader.JPG") && basicFunction.checkIfExist("DhwMenuItems.JPG")){
			result = true;
		}
		return result;
	}
}
