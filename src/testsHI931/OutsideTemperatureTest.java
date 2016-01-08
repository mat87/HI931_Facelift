package testsHI931;

import automatedTestFramework.BasicFunctions;

public class OutsideTemperatureTest {
	
	BasicFunctions basicFunction = new BasicFunctions();
	
	public boolean checkOutsideTemperature() throws InterruptedException{

		boolean result = false;
		
		basicFunction.goToMainMenu();
		
		if (basicFunction.checkIfExist("outsideTemperature12.JPG")){
			result = true;
		}
		return result;
	}
}
