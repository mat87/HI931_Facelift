package testsHI931;
import java.util.ArrayList;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;


public class OperatingProgramTest {
	

	String separator = "----------------------------------------------------------------------------------------------------------------------------";
	
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();
	
	/*
	 * Check if Operating Program screen contains proper Header as in GUI spec. 
	 */
	public boolean checkOperatingProgramHeader(){
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkOperatingProgramHeader() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		
		basicFunction.goToMainMenu();
		
		String[] buttonsInMainMenu = {"OperatingProgramStandby.jpg",
				"OperatingProgramDHW.JPG",
				"OperatingProgramHeatingDHW.JPG"};
				
		ArrayList<Target> targetsInMainMenu = basicFunction.mapTargets(buttonsInMainMenu);
		ArrayList<ScreenRegion> regionsInMainMenu = basicFunction.mapRegions(targetsInMainMenu);
		
		if (regionsInMainMenu.get(0) != null || regionsInMainMenu.get(1) != null || regionsInMainMenu.get(2) != null){
			for (int i=0; i<regionsInMainMenu.size(); i++) {
				if (regionsInMainMenu.get(i) != null){
					basicFunction.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),2);
					break;
				}
			}
		}
		
		if (basicFunction.checkIfExist("HC1OperatingProgramHeader.JPG")){
			result = true;
			System.out.println("Found Operating Program header");			
			System.out.println("Test: Success" + '\n' + separator);
		}else{
			System.out.println("Operating Program header has not been found.");
			System.out.println("Test: Fail" + '\n' + separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
	
	/*
	 * Check if Operating Program screen contains proper Footer as in GUI specification. 
	 */
	public boolean checkOperatingProgramFooter(){
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkOperatingProgramFooter() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		
		basicFunction.goToMainMenu();
		
		//Array of buttons in operating program
		String[] buttonsInMainMenu = {"OperatingProgramStandby.jpg",
				"OperatingProgramDHW.JPG",
				"OperatingProgramHeatingDHW.JPG"};
				
		ArrayList<Target> targetsInMainMenu = basicFunction.mapTargets(buttonsInMainMenu);
		ArrayList<ScreenRegion> regionsInMainMenu = basicFunction.mapRegions(targetsInMainMenu);
				
		if (regionsInMainMenu.get(0) != null || regionsInMainMenu.get(1) != null || regionsInMainMenu.get(2) != null){
			for (int i=0; i<regionsInMainMenu.size(); i++) {
				if (regionsInMainMenu.get(i) != null){
					basicFunction.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),2);
					break;
				}
			}
		}
		if (basicFunction.checkIfExist("HC1OperatingProgramFooter.JPG")){
			result = true;
			System.out.println("Found Operating Program footer");			
			System.out.println("Test: Success" + '\n' + separator);
		}else{
			System.out.println("Operating Program footer has not been found.");
			System.out.println("Test: Fail" + '\n' + separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}	
	
	/*
	 * Set Operating Program and check if selected correctly.
	 */
	public boolean setOperatingProgram(){
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++ setOperatingProgram() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(separator);
		boolean result = false;
		long startTest = System.currentTimeMillis();
		
		//Array of buttons in main menu
		String[] buttonsInMainMenu = {"OperatingProgramStandby.jpg",
				"OperatingProgramDHW.JPG",
				"OperatingProgramHeatingDHW.JPG"};
				
		ArrayList<Target> targetsInMainMenu = basicFunction.mapTargets(buttonsInMainMenu);
		ArrayList<ScreenRegion> regionsInMainMenu = basicFunction.mapRegions(targetsInMainMenu);
		
		if (regionsInMainMenu.get(0) != null || regionsInMainMenu.get(1) != null || regionsInMainMenu.get(2) != null){
			for (int i=0; i<regionsInMainMenu.size(); i++) {
				if (regionsInMainMenu.get(i) != null){
					basicFunction.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),2);
					break;
				}
			}
			//Array of buttons in operating program
			String[] buttonsInoperatingModeMenu = {"StandbyMode.jpg",
					"DHWOnly.JPG",
					"HeatingAndDHW.JPG",
					"OK.JPG",
					"Back.JPG"};

			ArrayList<Target> targetsInOperatingProgram = basicFunction.mapTargets(buttonsInoperatingModeMenu);
			ArrayList<ScreenRegion> regionsInOperatingProgram = basicFunction.mapRegions(targetsInOperatingProgram);
			
			//Test
			for(int i=0; i<3; i++){
				basicFunction.click(regionsInOperatingProgram.get(i) ,targetsInOperatingProgram.get(i),2);
				basicFunction.click(regionsInOperatingProgram.get(3) ,targetsInOperatingProgram.get(3),2);
					if (basicFunction.checkIfExist(buttonsInMainMenu[i])){
						result = true;
					}else{
						result = false;
						System.out.println("Setting operating mode works NOT fine.");
						System.out.println("Test: Fail" + '\n' 
								+ separator);	
						break;
					}
				basicFunction.click(regionsInMainMenu.get(2), targetsInMainMenu.get(2),2);
			}
			if (result == true){
				System.out.println("Setting operating mode works fine.");
				System.out.println("Test: Success" + '\n' 
						+ separator);	
			}
		}else{
			System.out.println("Operating Program buttons" + " " + buttonsInMainMenu[0] + buttonsInMainMenu[1] + buttonsInMainMenu[2] + " " + 
								"have not been found." + " " + regionsInMainMenu.get(0) + regionsInMainMenu.get(1) + regionsInMainMenu.get(2) + " " + "returned.");
			System.out.println("Test: Fail" + '\n' 
								+ separator);
		}
		
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
}