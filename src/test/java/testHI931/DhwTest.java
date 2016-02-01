package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.ScreenContainer;
import automatedTestFramework.GUIElement;

public class DhwTest {

    BasicFunctions basicFunction;
    GUIElement guielem;

    public DhwTest(){
        guielem = new GUIElement();
        basicFunction = new BasicFunctions();
    }

    public boolean SetDhwTemperatureTest(){
        boolean result = true;

        basicFunction.goToMainMenu();

        //to be developed

        return result;
    }

    public boolean checkDhwMenu(){
        boolean result = false;

        basicFunction.goToMainMenu();
        basicFunction.goToDhwMenu();
        if (guielem.checkIfExist(ScreenContainer.Screens.DHW_MENU_HEADER.toString()) &&
                                guielem.checkIfExist(ScreenContainer.Pages.DHW_MENU_ITEMS.toString())){
            result = true;
        }
        return result;
    }
}