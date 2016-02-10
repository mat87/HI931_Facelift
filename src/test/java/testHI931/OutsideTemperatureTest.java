package testHI931;

import testFramework.Driver;
import testFramework.ScreenContainer;
import testFramework.GUIElement;

public class OutsideTemperatureTest {

    Driver driver;
    GUIElement guielem;

    public OutsideTemperatureTest(){
        guielem = new GUIElement();
        driver = new Driver();
    }

    public boolean checkOutsideTemperature() throws InterruptedException{
        boolean result = false;
        driver.goToMainMenu();
        if (guielem.checkIfExist(ScreenContainer.Screens.OUTSIDE_TEMPERATURE_12.toString())){
            result = true;
        }
        return result;
    }
}
