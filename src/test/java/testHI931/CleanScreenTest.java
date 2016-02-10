package testHI931;

import testFramework.Driver;
import testFramework.ScreenContainer;
import testFramework.GUIElement;

public class CleanScreenTest{

    GUIElement guielem;
    Driver driver;

    public CleanScreenTest(){
        guielem = new GUIElement();
        driver = new Driver();
    }

    public boolean checkClearScreen(){
        boolean result = false;
        driver.goToSettingsMenu();
        guielem.clickIfExist(ScreenContainer.Buttons.RIGHT.toString());
        guielem.clickIfExist(ScreenContainer.Buttons.CLEAN_SCREEN.toString());
        guielem.clickIfExist(ScreenContainer.Screens.CLEAN_SCRREN.toString());
        try{
            Thread.sleep(70000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (guielem.checkIfExist(ScreenContainer.Pages.CLEAN_SCREEN.toString())){
            result = true;
        }
        return result;
    }
}
