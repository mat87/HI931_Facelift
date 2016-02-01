package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.ScreenContainer;
import automatedTestFramework.GUIElement;

public class SettingsTest {

    BasicFunctions basicFunction;
    GUIElement guielem;

    public SettingsTest(){
        basicFunction = new BasicFunctions();
        guielem = new GUIElement();
    }

    public boolean checkSettingsHeader(){
        boolean result = false;

        basicFunction.goToMainMenu();
        basicFunction.goToSettingsMenu();
        if (guielem.checkIfExist(ScreenContainer.Screens.SETTING_HEADER.toString())){
            result = true;
        }
        return result;
    }

    public boolean checkSettingsMenuItems(){
        boolean result = false;
        basicFunction.goToMainMenu();
        basicFunction.goToSettingsMenu();
        if (guielem.checkIfExist(ScreenContainer.Pages.SETTINGS_MENU_1.toString())){
            guielem.clickIfExist(ScreenContainer.Buttons.RIGHT.toString());
            if(guielem.checkIfExist(ScreenContainer.Pages.SETTINGS_MENU_2.toString())){
                result = true;
            }
        }
        return result;
    }
}

