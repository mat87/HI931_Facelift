package testsHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;

public class DhwTest {
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();
	
	public boolean SetDhwTemperatureTest(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ SetDhwTemperatureTest() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = true;
		
		basicFunction.goToMainMenu();

		//to be developed
		
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
	
	public boolean checkDhwMenu(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkDhwMenu() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		
		basicFunction.goToMainMenu();
		basicFunction.goToDhwMenu();
		if (basicFunction.checkIfExist("DhwMenuHeader.JPG") && basicFunction.checkIfExist("DhwMenuItems.JPG")){
			result = true;
			System.out.println("DHW Menu is correct.");			
			System.out.println("Test: Success" + '\n' + log.separator);
		}else{
			System.out.println("DHW Menu is not correct.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
}
