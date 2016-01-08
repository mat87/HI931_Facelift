package testsHI931;

import java.util.ArrayList;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import automatedTestFramework.BasicFunctions;

public class RoomTemperatureTest {
	
	BasicFunctions basicFunction = new BasicFunctions();
	String filePath = "C:\\Workspace\\Viessmann.HI931.Automated.Tests\\images\\capturedScreens\\";
	String[] buttonsInRoomTemperatureMenu = {"OK.jpg",
											"Plus.JPG",
											"Minus.JPG"};
	
	ArrayList<Target> targetsInRoomTemperatureMenu = basicFunction.mapTargets(buttonsInRoomTemperatureMenu);
	
	//-------------------------------------------------------------------------------------------------------
	public boolean setRoomTemperatureHighest() throws InterruptedException{
		boolean result = false;
		String testName = "setRoomTemperatureHighest.jpg";
		
		if(basicFunction.clickIfExist("Plus.JPG")){
			ArrayList<ScreenRegion> regionsInRoomTemperatureMenu = basicFunction.mapRegions(targetsInRoomTemperatureMenu);
			if (regionsInRoomTemperatureMenu.get(0) != null && regionsInRoomTemperatureMenu.get(1) != null && regionsInRoomTemperatureMenu.get(2) != null){
				for(int i = 0; i < 3; i++){
					basicFunction.click(regionsInRoomTemperatureMenu.get(1), targetsInRoomTemperatureMenu.get(1),0);
				}
				basicFunction.click(regionsInRoomTemperatureMenu.get(0), targetsInRoomTemperatureMenu.get(0),0);
				if(basicFunction.checkIfExist("RoomTemperatureMainMenuHighest.JPG")){
					result = true;
				}
				else{
					basicFunction.getScreenShoot(filePath, testName);
				}
			}	
		}
		return result;
	}
	//-------------------------------------------------------------------------------------------------------
	public boolean setRoomTemperatureLowest() throws InterruptedException{
		boolean result = false;
		String testName = "setRoomTemperatureLowest.jpg";
		
		if(basicFunction.clickIfExist("Minus.JPG")){
			ArrayList<ScreenRegion> regionsInRoomTemperatureMenu = basicFunction.mapRegions(targetsInRoomTemperatureMenu);
			if (regionsInRoomTemperatureMenu.get(0) != null && regionsInRoomTemperatureMenu.get(1) != null && regionsInRoomTemperatureMenu.get(2) != null){
				for(int i = 0; i < 5; i++){
					basicFunction.click(regionsInRoomTemperatureMenu.get(2), targetsInRoomTemperatureMenu.get(2),0);
				}
				basicFunction.click(regionsInRoomTemperatureMenu.get(0), targetsInRoomTemperatureMenu.get(0),0);
				
				if(basicFunction.checkIfExist("RoomTemperatureMainMenuLowest.JPG")){
					result = true;
				}
				else{
					basicFunction.getScreenShoot(filePath, testName);
				}
			}	
		}
		return result;
	}
	//-------------------------------------------------------------------------------------------------------
	public boolean checkRoomTemperatureHeader() throws InterruptedException{
		boolean result = false;
		String testName = "checkRoomTemperatureHeader";
		
		basicFunction.clickIfExist("Minus.JPG");
		if (basicFunction.checkIfExist("RoomTemperatureHeader.JPG")){
			result = true;
		}
		else{
			basicFunction.getScreenShoot(filePath, testName);
		}
		return result;
	}
}
