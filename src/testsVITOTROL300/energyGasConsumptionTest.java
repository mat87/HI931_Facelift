package testsVITOTROL300;

import automatedTestFramework.BasicFunctions;

public class energyGasConsumptionTest {
	
	BasicFunctions basicFunction = new BasicFunctions();;

	public boolean checkGas(){					
		boolean result = false;
		try {
			Thread.sleep(2000);
		}catch (Exception e){}
		
		result = basicFunction.checkIfExist("VitotrolMain.JPG");
		return result;
	}
		
	
	public boolean checkEnergy(){		
		boolean result = false;
		result = basicFunction.checkIfExist("VitotrolMain.JPG");
		return result;
	}
}
	
	
	
	