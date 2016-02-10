package testHI931;

import testFramework.Driver;
import testFramework.ScreenContainer;
import testFramework.GUIElement;

public class SettingsTest {

    Driver driver;
    GUIElement guielem;

    public SettingsTest(){
        driver = new Driver();
        guielem = new GUIElement();
    }

    public boolean checkSettingsHeader(){
        boolean result = false;

        driver.goToMainMenu();
        driver.goToSettingsMenu();
        if (guielem.checkIfExist(ScreenContainer.Screens.SETTING_HEADER.toString())){
            result = true;
        }
        return result;
    }

    public boolean checkSettingsMenuItems(){
        boolean result = false;
        driver.goToMainMenu();
        driver.goToSettingsMenu();
        if (guielem.checkIfExist(ScreenContainer.Pages.SETTINGS_MENU_1.toString())){
            guielem.clickIfExist(ScreenContainer.Buttons.RIGHT.toString());
            if(guielem.checkIfExist(ScreenContainer.Pages.SETTINGS_MENU_2.toString())){
                result = true;
            }
        }
        return result;
    }
}

