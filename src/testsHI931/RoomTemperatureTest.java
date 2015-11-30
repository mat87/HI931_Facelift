package testsHI931;

import java.util.ArrayList;

import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;

public class RoomTemperatureTest {
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();
	
	public boolean SetRoomTemperatureTest(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ SetRoomTemperature() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		
		basicFunction.goToMainMenu();
		if (basicFunction.clickIfExist("RoomTemperatureMainMenu.JPG")){
			String[] buttonsInRoomTemperatureMenu = {"OK.jpg",
					"Plus.JPG",
					"Minus.JPG"};
					
			ArrayList<Target> targetsInRoomTemperatureMenu = basicFunction.mapTargets(buttonsInRoomTemperatureMenu);
			ArrayList<ScreenRegion> regionsInRoomTemperatureMenu = basicFunction.mapRegions(targetsInRoomTemperatureMenu);
			
			if (regionsInRoomTemperatureMenu.get(0) != null || regionsInRoomTemperatureMenu.get(1) != null || regionsInRoomTemperatureMenu.get(2) != null){
				basicFunction.click(regionsInRoomTemperatureMenu.get(1), targetsInRoomTemperatureMenu.get(1),0);
				basicFunction.click(regionsInRoomTemperatureMenu.get(1), targetsInRoomTemperatureMenu.get(1),0);
				basicFunction.click(regionsInRoomTemperatureMenu.get(0), targetsInRoomTemperatureMenu.get(0),1);
				if(basicFunction.checkIfExist("RoomTemperatureMainMenu34.JPG")||basicFunction.checkIfExist("RoomTemperatureMainMenu34.JPG"))
					result = true;
				else{
					result = false;
					System.out.println("Test: Fail" + '\n' + log.separator);
				}
				basicFunction.clickIfExist("RoomTemperatureMainMenu34.JPG");
				basicFunction.click(regionsInRoomTemperatureMenu.get(2), targetsInRoomTemperatureMenu.get(2),0);
				basicFunction.click(regionsInRoomTemperatureMenu.get(2), targetsInRoomTemperatureMenu.get(2),0);
				basicFunction.click(regionsInRoomTemperatureMenu.get(2), targetsInRoomTemperatureMenu.get(2),0);
				basicFunction.click(regionsInRoomTemperatureMenu.get(2), targetsInRoomTemperatureMenu.get(2),0);
				basicFunction.click(regionsInRoomTemperatureMenu.get(0), targetsInRoomTemperatureMenu.get(0),1);
				if(basicFunction.checkIfExist("RoomTemperatureMainMenu6.JPG")){
					result = true;
					System.out.println("Test: Success" + '\n' + log.separator);
				}else{
					result = false;
					System.out.println("Test: Fail" + '\n' + log.separator);
				}
			}
		}else{
			System.out.println("Impossible to get into room temperature menu.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
	
	public boolean checkRoomTemperatureHeader(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkRoomTemperatureHeader() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(log.separator);
		long startTest = System.currentTimeMillis();
		boolean result = false;
		
		basicFunction.goToMainMenu();
		basicFunction.clickIfExist("RoomTemperatureMainMenu.JPG");
		if (basicFunction.checkIfExist("RoomTemperatureHeader.JPG")){
			result = true;
			System.out.println("Room temperature header is correct.");			
			System.out.println("Test: Success" + '\n' + log.separator);
		}else{
			System.out.println("Room temperature header is not correct.");
			System.out.println("Test: Fail" + '\n' + log.separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
}
