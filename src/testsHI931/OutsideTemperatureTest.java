package testsHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;


public class OutsideTemperatureTest {
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();
	
	public boolean checkOutsideTemperature(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkOutsideTemperature() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		
		basicFunction.goToMainMenu();
		
		if (basicFunction.checkIfExist("outsideTemperature12.JPG")){
			result = true;
			System.out.println("Found Outside temperature is correct.");			
			System.out.println("Test: Success" + '\n' + log.separator);
		}else{
			System.out.println("Found Outside temperature is not correct.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
	
	
	
}
