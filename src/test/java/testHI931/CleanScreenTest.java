package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.ScreenContainer;

public class CleanScreenTest {

    BasicFunctions basicFunction;

    public CleanScreenTest(){
        basicFunction = new BasicFunctions();
    }

    public boolean checkClearScreen(){
        boolean result = false;
        basicFunction.goToSettingsMenu();
        basicFunction.clickIfExist(ScreenContainer.Buttons.RIGHT.toString());
        basicFunction.clickIfExist(ScreenContainer.Buttons.CLEAN_SCREEN.toString());
        basicFunction.clickIfExist(ScreenContainer.Screens.CLEAN_SCRREN.toString());
        try{
            Thread.sleep(70000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (basicFunction.checkIfExist(ScreenContainer.Pages.CLEAN_SCREEN.toString())){
            result = true;
        }
        return result;
    }



}
