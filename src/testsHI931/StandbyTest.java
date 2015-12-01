package testsHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;

public class StandbyTest {
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();
	
	public boolean check2minutesStandby(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ check2minutesStandby() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		basicFunction.goToMainMenu();
		try{
			Thread.sleep(250000);
		}catch (Exception e)
			{System.out.println("Something went wrong while waiting");
		};
		if (basicFunction.checkIfExist("StandbyScreen1.JPG")){
				result = true;
				System.out.println("Standby screen works correctly.");			
				System.out.println("Test: Success" + '\n' + log.separator);
		}else{
			System.out.println("Standby screen works not correctly.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
}
