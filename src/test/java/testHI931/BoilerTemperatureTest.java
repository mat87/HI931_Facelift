package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Const;
import automatedTestFramework.Connection;
import automatedTestFramework.ScreenContainer;
import java.net.*;

public class BoilerTemperatureTest{

    BasicFunctions basicFunction;
    Connection connect;

    public BoilerTemperatureTest(){
        basicFunction = new BasicFunctions();
        connect = new Connection();
    }

    public boolean checkBoilerTemperature() throws InterruptedException{
        boolean result = false;
        basicFunction.goToMainMenu();
        if (basicFunction.checkIfExist(ScreenContainer.Screens.BOILER_TEMPERATURE_47.toString())){
            result = true;
        }
        return result;
    }

    public boolean checkChangeBoilerTemperature(Socket s){
        boolean result = false;
        basicFunction.goToMainMenu();
        connect.sendMessageToHI(s, Const.BOILER_TEMP_5);
        if (basicFunction.checkIfExist(ScreenContainer.Screens.BOILER_TEMPEARTURE_5.toString())){
            result = true;
        }
        return result;
    }
}
