package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.ScreenContainer;
import automatedTestFramework.GUIElement;

public class OutsideTemperatureTest {

    BasicFunctions basicFunction;
    GUIElement guielem;

    public OutsideTemperatureTest(){
        guielem = new GUIElement();
        basicFunction = new BasicFunctions();
    }

    public boolean checkOutsideTemperature() throws InterruptedException{
        boolean result = false;
        basicFunction.goToMainMenu();
        if (guielem.checkIfExist(ScreenContainer.Screens.OUTSIDE_TEMPERATURE_12.toString())){
            result = true;
        }
        return result;
    }
}
