package testHI931;

import testFramework.Driver;
import testFramework.ScreenContainer;
import testFramework.GUIElement;

public class DhwTest {

    Driver driver;
    GUIElement guielem;

    public DhwTest(){
        guielem = new GUIElement();
        driver = new Driver();
    }

    public boolean SetDhwTemperatureTest(){
        boolean result = true;

        driver.goToMainMenu();

        //to be developed

        return result;
    }

    public boolean checkDhwMenu(){
        boolean result = false;

        driver.goToMainMenu();
        driver.goToDhwMenu();
        if (guielem.checkIfExist(ScreenContainer.Screens.DHW_MENU_HEADER.toString()) &&
                                guielem.checkIfExist(ScreenContainer.Pages.DHW_MENU_ITEMS.toString())){
            result = true;
        }
        return result;
    }
}