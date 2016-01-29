package testHI931;

import automatedTestFramework.BasicFunctions;
import automatedTestFramework.ScreenContainer;

public class StandbyTest {
    BasicFunctions basicFunction = new BasicFunctions();

    public boolean check2minutesStandby(){
        boolean result = false;
        basicFunction.goToMainMenu();
        try{
            Thread.sleep(250000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (basicFunction.checkIfExist(ScreenContainer.Pages.STANDBY_SCREEN_1.toString())){
            result = true;
            basicFunction.clickIfExist(ScreenContainer.Pages.STANDBY_SCREEN_1.toString());
        }
        return result;
    }
}
