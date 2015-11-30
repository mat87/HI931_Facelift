package testsVITOTROL300;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;

public class energyGasConsumptionTest {
	String separator = "----------------------------------------------------------------------------------------------------------------------------";
	
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();

	
	public boolean checkGas(){
							
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkGas() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(separator);
							
		boolean result = false;
		try {
			Thread.sleep(2000);
		}catch (Exception e){}
		
		result = basicFunction.checkIfExist("VitotrolMain.JPG");
		return result;
	}
		
	
	public boolean checkEnergy(){
			
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkEnergy() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(separator);
				
		boolean result = false;
		result = basicFunction.checkIfExist("VitotrolMain.JPG");
		return result;
	}
}
	
	
	
	