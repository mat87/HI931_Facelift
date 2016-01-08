package testsHI931;

import automatedTestFramework.BasicFunctions;
import java.net.*;


public class BoilerTemperatureTest{
	BasicFunctions basicFunction = new BasicFunctions();
	
	public boolean checkBoilerTemperature() throws InterruptedException{
		boolean result = false;
		
		basicFunction.goToMainMenu();
		if (basicFunction.checkIfExist("boilerTemperature47.JPG")){
			result = true;
		}
		return result;
	}
	
	public boolean checkChangeBoilerTemperature(Socket s){
		boolean result = false;
		
		basicFunction.goToMainMenu();
		basicFunction.insertValueToHI931(s,Const.boilerTemp5);
		if (basicFunction.checkIfExist("boilerTemperature5.JPG")){
			result = true;
		}
		return result;
	}
}
