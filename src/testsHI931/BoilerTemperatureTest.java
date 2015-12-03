package testsHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;
import java.net.*;


public class BoilerTemperatureTest{
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();
	
	public boolean checkBoilerTemperature(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkBoilerTemperature() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		
		basicFunction.goToMainMenu();
		if (basicFunction.checkIfExist("boilerTemperature47.JPG")){
			result = true;
			System.out.println("Found Boiler temperature is correct.");			
			System.out.println("Test: Success" + '\n' + log.separator);
		}else{
			System.out.println("Found Boiler temperature is not correct.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
	
	public boolean checkChangeBoilerTemperature(Socket s){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkChangeBoilerTemperature() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		
		basicFunction.goToMainMenu();
		basicFunction.insertValueToHI931(s,Const.boilerTemp5);
		if (basicFunction.checkIfExist("boilerTemperature5.JPG")){
			result = true;
			System.out.println("Changed Boiler temperature is correct.");			
			System.out.println("Test: Success" + '\n' + log.separator);
		}else{
			System.out.println("Changed Boiler temperature is not correct.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
}
