package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.ScreenContainer;

public class DhwTest {

    BasicFunctions basicFunction;

    public DhwTest(){
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
        if (basicFunction.checkIfExist(ScreenContainer.Screens.DHW_MENU_HEADER.toString()) &&
                                        basicFunction.checkIfExist(ScreenContainer.Pages.DHW_MENU_ITEMS.toString())){
            result = true;
        }
        return result;
    }
}