package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.ScreenContainer;

public class SettingsTest {
    BasicFunctions basicFunction = new BasicFunctions();

    public boolean checkSettingsHeader(){
        boolean result = false;

        basicFunction.goToMainMenu();
        basicFunction.goToSettingsMenu();
        if (basicFunction.checkIfExist(ScreenContainer.Screens.SETTING_HEADER.toString())){
            result = true;
        }
        return result;
    }

    public boolean checkSettingsMenuItems(){
        boolean result = false;
        basicFunction.goToMainMenu();
        basicFunction.goToSettingsMenu();
        if (basicFunction.checkIfExist(ScreenContainer.Pages.SETTINGS_MENU_1.toString())){
            basicFunction.clickIfExist(ScreenContainer.Buttons.RIGHT.toString());
            if(basicFunction.checkIfExist(ScreenContainer.Pages.SETTINGS_MENU_2.toString())){
                result = true;
            }
        }
        return result;
    }
}

