package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.ScreenContainer;

public class OutsideTemperatureTest {

    BasicFunctions basicFunction;

    public OutsideTemperatureTest(){
        basicFunction = new BasicFunctions();
    }

    public boolean checkOutsideTemperature() throws InterruptedException{
        boolean result = false;
        basicFunction.goToMainMenu();
        if (basicFunction.checkIfExist(ScreenContainer.Screens.OUTSIDE_TEMPERATURE_12.toString())){
            result = true;
        }
        return result;
    }
}
