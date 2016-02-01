package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.ScreenContainer;
import automatedTestFramework.GUIElement;

public class CleanScreenTest{

    GUIElement guielem;
    BasicFunctions basicFunction;

    public CleanScreenTest(){
        guielem = new GUIElement();
        basicFunction = new BasicFunctions();
    }

    public boolean checkClearScreen(){
        boolean result = false;
        basicFunction.goToSettingsMenu();
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
