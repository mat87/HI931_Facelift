package testHI931;

import testFramework.Driver;
import testFramework.ScreenContainer;
import testFramework.GUIElement;

public class StandbyTest {

    Driver driver;
    GUIElement guielem;

    public StandbyTest(){
        driver = new Driver();
        guielem = new GUIElement();
    }

    public boolean check2minutesStandby(){
        boolean result = false;
        driver.goToMainMenu();
        try{
            Thread.sleep(250000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (guielem.checkIfExist(ScreenContainer.Pages.STANDBY_SCREEN_1.toString())){
            result = true;
            guielem.clickIfExist(ScreenContainer.Pages.STANDBY_SCREEN_1.toString());
        }
        return result;
    }
}
