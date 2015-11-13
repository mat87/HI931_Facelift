package automatedTestFramework;

import java.util.Arrays;

import testsHI931.*;
import testsVITOTROL300.*;

public class Suite {
	boolean[] results;
	OperatingProgramTest opt = new OperatingProgramTest();
	energyGasConsumptionTest energyGas = new energyGasConsumptionTest();
	
	BasicFunctions func = new BasicFunctions();
	
	public void executeSuite(String projectName, String suiteName){
		
		if(projectName.equals("HI931")){	
			switch (suiteName) {
		        case "REGRESSION": results = new boolean[]{
						opt.setOperatingProgram(),
						opt.checkOperatingProgramHeader(),
						opt.checkOperatingProgramFooter()
						};
		        		break;
		        case "SMOKE": results = new boolean[]{
		        		opt.checkOperatingProgramHeader(),
						opt.checkOperatingProgramFooter()
		        		};
		                 break;
		        default: break;
			}
		}else if(projectName.equals("VITOTROL300")){
			switch (suiteName){
		        case "REGRESSION": results = new boolean[]{
		        		energyGas.checkGas(),
		        		energyGas.checkEnergy()
						};
		        		break;
		        case "SMOKE": results = new boolean[]{
		        		energyGas.checkGas(),
		        		energyGas.checkEnergy()
		        		};
		                 break;
		        default: break;
			}
		}
			
		boolean[] trueList = func.generateTrueList(results.length);
		if(Arrays.equals(results, trueList)){
			System.out.printf("----------------------\n");
			System.out.printf("TEST RESULT: SUCCESS\n");
			System.out.printf("----------------------");
		}
		else{
			System.out.printf("----------------------\n");
			System.out.printf("TEST RESULT: FAIL\n");
			System.out.printf("----------------------");
		}
	}
}
