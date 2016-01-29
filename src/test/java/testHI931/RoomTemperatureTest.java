package testHI931;

import java.util.ArrayList;

import automatedTestFramework.ScreenContainer;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import automatedTestFramework.BasicFunctions;

public class RoomTemperatureTest {

    BasicFunctions basicFunction;

    public RoomTemperatureTest(){
        basicFunction = new BasicFunctions();
    }

    String filePath = "C:\\Workspace\\Viessmann.HI931.Automated.Tests\\images\\capturedScreens\\";

    String[] buttonsInRoomTemperatureMenu = {ScreenContainer.Buttons.OK.toString(),
                                            ScreenContainer.Buttons.PLUS.toString(),
                                            ScreenContainer.Buttons.MINUS.toString()};

    ArrayList<Target> targetsInRoomTemperatureMenu = basicFunction.mapTargets(buttonsInRoomTemperatureMenu);

    //-------------------------------------------------------------------------------------------------------
    public boolean setRoomTemperatureHighest() throws InterruptedException{
        boolean result = false;
        String testName = "setRoomTemperatureHighest.jpg";

        if(basicFunction.clickIfExist(ScreenContainer.Buttons.PLUS.toString())){
            ArrayList<ScreenRegion> regionsInRoomTemperatureMenu = basicFunction.mapRegions(targetsInRoomTemperatureMenu);
            if (regionsInRoomTemperatureMenu.get(0) != null && regionsInRoomTemperatureMenu.get(1) != null && regionsInRoomTemperatureMenu.get(2) != null){
                for(int i = 0; i < 3; i++){
                    basicFunction.click(regionsInRoomTemperatureMenu.get(1), targetsInRoomTemperatureMenu.get(1),0);
                }
                basicFunction.click(regionsInRoomTemperatureMenu.get(0), targetsInRoomTemperatureMenu.get(0),0);
                if(basicFunction.checkIfExist(ScreenContainer.Screens.ROOM_TEMPERATURE_MAIN_MENU_HIGHEST.toString())){
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
        String testName = "SetRoomTemperatureLowest.jpg";

        if(basicFunction.clickIfExist(ScreenContainer.Buttons.MINUS.toString())){
            ArrayList<ScreenRegion> regionsInRoomTemperatureMenu = basicFunction.mapRegions(targetsInRoomTemperatureMenu);
            if (regionsInRoomTemperatureMenu.get(0) != null && regionsInRoomTemperatureMenu.get(1) != null && regionsInRoomTemperatureMenu.get(2) != null){
                for(int i = 0; i < 5; i++){
                    basicFunction.click(regionsInRoomTemperatureMenu.get(2), targetsInRoomTemperatureMenu.get(2),0);
                }
                basicFunction.click(regionsInRoomTemperatureMenu.get(0), targetsInRoomTemperatureMenu.get(0),0);

                if(basicFunction.checkIfExist(ScreenContainer.Screens.ROOM_TEMPERATURE_MAIN_MENU_LOWEST.toString())){
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
        String testName = "CheckRoomTemperatureHeader";

        basicFunction.clickIfExist(ScreenContainer.Buttons.MINUS.toString());
        if (basicFunction.checkIfExist(ScreenContainer.Screens.ROOM_TEMPERATURE_HEADER.toString())){
            result = true;
        }
        else{
            basicFunction.getScreenShoot(filePath, testName);
        }
        return result;
    }
}
