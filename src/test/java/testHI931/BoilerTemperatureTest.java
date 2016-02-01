package testHI931;

import automatedTestFramework.*;
import java.net.*;

public class BoilerTemperatureTest{

    BasicFunctions basicFunction;
    GUIElement guielem;
    Connection connect;

    public BoilerTemperatureTest(){
        basicFunction = new BasicFunctions();
        connect = new Connection();
        guielem = new GUIElement();
    }

    public boolean checkBoilerTemperature() throws InterruptedException{
        boolean result = false;
        basicFunction.goToMainMenu();
        if (guielem.checkIfExist(ScreenContainer.Screens.BOILER_TEMPERATURE_47.toString())){
            result = true;
        }
        return result;
    }

    public boolean checkChangeBoilerTemperature(Socket s){
        boolean result = false;
        basicFunction.goToMainMenu();
        connect.sendMessageToHI(s, Const.BOILER_TEMP_5);
        if (guielem.checkIfExist(ScreenContainer.Screens.BOILER_TEMPEARTURE_5.toString())){
            result = true;
        }
        return result;
    }
}
