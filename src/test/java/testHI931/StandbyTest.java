package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.ScreenContainer;
import automatedTestFramework.GUIElement;

public class StandbyTest {

    BasicFunctions basicFunction;
    GUIElement guielem;

    public StandbyTest(){
        basicFunction = new BasicFunctions();
        guielem = new GUIElement();
    }

    public boolean check2minutesStandby(){
        boolean result = false;
        basicFunction.goToMainMenu();
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
