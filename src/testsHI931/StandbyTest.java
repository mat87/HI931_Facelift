package testsHI931;

import automatedTestFramework.BasicFunctions;

public class StandbyTest {
	BasicFunctions basicFunction = new BasicFunctions();
	
	public boolean check2minutesStandby(){
		boolean result = false;
		basicFunction.goToMainMenu();
		try{
			Thread.sleep(250000);
		}catch (Exception e)
			{System.out.println("Something went wrong while waiting");
		};
		if (basicFunction.checkIfExist("StandbyScreen1.JPG")){
			result = true;
			basicFunction.clickIfExist("StandbyScreen1.JPG");
		}
		return result;
	}
}
