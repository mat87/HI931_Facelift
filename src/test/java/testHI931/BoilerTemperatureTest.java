package testHI931;

import testFramework.*;
import java.net.*;

public class BoilerTemperatureTest{

    Driver driver;
    GUIElement guielem;
    Connection connect;

    public BoilerTemperatureTest(){
        driver = new Driver();
        connect = new Connection();
        guielem = new GUIElement();
    }

    public boolean checkBoilerTemperature() throws InterruptedException{
        boolean result = false;
        driver.goToMainMenu();
        if (guielem.checkIfExist(ScreenContainer.Screens.BOILER_TEMPERATURE_47.toString())){
            result = true;
        }
        return result;
    }

    public boolean checkChangeBoilerTemperature(Socket s){
        boolean result = false;
        driver.goToMainMenu();
        connect.sendMessageToHI(s, Constants.BOILER_TEMP_5);
        if (guielem.checkIfExist(ScreenContainer.Screens.BOILER_TEMPEARTURE_5.toString())){
            result = true;
        }
        return result;
    }
}
