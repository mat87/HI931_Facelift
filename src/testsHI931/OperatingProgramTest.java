package testsHI931;
import java.util.ArrayList;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import automatedTestFramework.BasicFunctions;


public class OperatingProgramTest {
	
	String filePath = "C:\\Workspace\\Viessmann.HI931.Automated.Tests\\images\\capturedScreens\\";
	BasicFunctions basicFunction = new BasicFunctions();
	
	/*
	 * Check if Operating Program screen contains proper Header as in GUI spec. 
	 */
	public boolean checkOperatingProgramHeader() throws InterruptedException{
		
		boolean result = false;
		String testName = Thread.currentThread().getStackTrace()[0].getMethodName();
		
		basicFunction.goToMainMenu();
		
		String[] buttonsInMainMenu = {"OperatingProgramStandby.jpg",
				"OperatingProgramDHW.JPG",
				"OperatingProgramHeatingDHW.JPG"};
				
		ArrayList<Target> targetsInMainMenu = basicFunction.mapTargets(buttonsInMainMenu);
		ArrayList<ScreenRegion> regionsInMainMenu = basicFunction.mapRegions(targetsInMainMenu);
		
		if (regionsInMainMenu.get(0) != null || regionsInMainMenu.get(1) != null || regionsInMainMenu.get(2) != null){
			for (int i=0; i<regionsInMainMenu.size(); i++) {
				if (regionsInMainMenu.get(i) != null){
					basicFunction.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),0);
					break;
				}else{
					basicFunction.getScreenShoot(filePath, testName);
				}
			}
		}else{
			basicFunction.getScreenShoot(filePath, testName);
		}
		if (basicFunction.checkIfExist("HC1OperatingProgramHeader.JPG")){
			result = true;
		}else{
			basicFunction.getScreenShoot(filePath, testName);
		}
		return result;
	}
	
	/*
	 * Check if Operating Program screen contains proper Footer as in GUI specification. 
	 */

	public boolean checkOperatingProgramFooter() throws InterruptedException{
		
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
					basicFunction.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),0);
					break;
				}
			}
		}
		if (basicFunction.checkIfExist("HC1OperatingProgramFooter.JPG")){
			result = true;
		}
	 	basicFunction.goToMainMenu();
		return result;
	}	
	
	/*
	 * Set Operating Program and check if selected correctly.
	 */
	public boolean setOperatingProgram() throws InterruptedException{
		
		boolean result = false;
		//Array of operating program buttons in operating program
		String[] buttonsInOperatingModeMenu = {"StandbyMode.JPG",
												"OnlyDHW.JPG",
												"HeatingAndDHW.JPG",
												"OK.JPG",
												"Back.JPG"};
		
		//Array of operating program buttons in main screen
		String[] buttonsInMainMenu = {"OperatingProgramStandby.JPG",
										"OperatingProgramDHW.JPG",
										"OperatingProgramHeatingDHW.JPG"};
		
		ArrayList<Target> targetsInMainMenu = basicFunction.mapTargets(buttonsInMainMenu);
		ArrayList<ScreenRegion> regionsInMainMenu = basicFunction.mapRegions(targetsInMainMenu);
		
		if (regionsInMainMenu.get(0) != null || regionsInMainMenu.get(1) != null || regionsInMainMenu.get(2) != null){
			for (int i=0; i<regionsInMainMenu.size(); i++) {
				if (regionsInMainMenu.get(i) != null){
					basicFunction.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),0);
					break;					
				}
			}
			ArrayList<Target> targetsInOperatingProgram = basicFunction.mapTargets(buttonsInOperatingModeMenu);
			ArrayList<ScreenRegion> regionsInOperatingProgram = basicFunction.mapRegions(targetsInOperatingProgram);
			//Test
			for(int i=0; i<3; i++){
				basicFunction.click(regionsInOperatingProgram.get(i) ,targetsInOperatingProgram.get(i),0);
				basicFunction.click(regionsInOperatingProgram.get(3) ,targetsInOperatingProgram.get(3),0);
					if (basicFunction.checkIfExist(buttonsInMainMenu[i])){
						basicFunction.click(regionsInMainMenu.get(2), targetsInMainMenu.get(2),0);
						result = true;
					}
			}
		}
		basicFunction.goToMainMenu();
		return result;
	}
}