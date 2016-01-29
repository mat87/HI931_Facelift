package testHI931;

import java.util.ArrayList;
import automatedTestFramework.ScreenContainer;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import automatedTestFramework.BasicFunctions;


public class OperatingProgramTest {

    String filePath = "C:\\Workspace\\Viessmann.HI931.Automated.Tests\\images\\capturedScreens\\";
    BasicFunctions basicFunction;

    public OperatingProgramTest(){
        basicFunction = new BasicFunctions();
    }
    /*
     * Check if Operating Program screen contains proper Header as in GUI spec.
     */
    public boolean checkOperatingProgramHeader() throws InterruptedException{

        boolean result = false;
        String testName = Thread.currentThread().getStackTrace()[0].getMethodName();

        basicFunction.goToMainMenu();

        String[] buttonsInMainMenu = {ScreenContainer.Screens.OPERATING_PROGRAM_STAND_BY.toString(),
                                    ScreenContainer.Screens.OPERATING_PROGRAM_DHW.toString(),
                                    ScreenContainer.Screens.OPERATING_PROGRAM_HEATING_DHW.toString()};

        ArrayList<Target> targetsInMainMenu = basicFunction.mapTargets(buttonsInMainMenu);
        ArrayList<ScreenRegion> regionsInMainMenu = basicFunction.mapRegions(targetsInMainMenu);

        if (regionsInMainMenu.get(0) != null || regionsInMainMenu.get(1) != null || regionsInMainMenu.get(2) != null){
            for (int i=0; i<regionsInMainMenu.size(); i++) {
                if (regionsInMainMenu.get(i) != null){
                    basicFunction.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),0);
                    break;
                }else{
                    basicFunction.getScreenShoot(filePath, testName);}
            }
        }else{
            basicFunction.getScreenShoot(filePath, testName);}
        if (basicFunction.checkIfExist(ScreenContainer.Screens.HC1_OPERATING_PROGRAM_HEADER.toString())){
            result = true;}
        else{
            basicFunction.getScreenShoot(filePath, testName);}
        return result;
    }

	/*
	 * Check if Operating Program screen contains proper Footer as in GUI specification.
	 */
    public boolean checkOperatingProgramFooter() throws InterruptedException{
        boolean result = false;
        basicFunction.goToMainMenu();
        //Array of buttons in operating program
        String[] buttonsInMainMenu = {ScreenContainer.Screens.OPERATING_PROGRAM_STAND_BY.toString(),
                                    ScreenContainer.Screens.OPERATING_PROGRAM_DHW.toString(),
                                    ScreenContainer.Screens.OPERATING_PROGRAM_HEATING_DHW.toString()};

        ArrayList<Target> targetsInMainMenu = basicFunction.mapTargets(buttonsInMainMenu);
        ArrayList<ScreenRegion> regionsInMainMenu = basicFunction.mapRegions(targetsInMainMenu);

        if (regionsInMainMenu.get(0) != null || regionsInMainMenu.get(1) != null || regionsInMainMenu.get(2) != null){
            for (int i=0; i<regionsInMainMenu.size(); i++) {
                if (regionsInMainMenu.get(i) != null){
                    basicFunction.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),0);
                    break;
                }
            }
        }
        if (basicFunction.checkIfExist(ScreenContainer.Screens.HC1_OPERATING_PROGRAM_FOOTER.toString())){
            result = true;
        }
        basicFunction.goToMainMenu();
        return result;
    }

    /*
     * Set Operating Program and check if selected correctly.
     */
    public boolean setOperatingProgram() throws InterruptedException{
        boolean result = false;
        //Array of operating program buttons in operating program
        String[] buttonsInOperatingModeMenu = {ScreenContainer.Screens.STAND_BY_MODE.toString(),
                                            ScreenContainer.Screens.ONLY_DHW.toString(),
                                            ScreenContainer.Screens.HEATING_AND_DHW.toString(),
                                            ScreenContainer.Buttons.OK.toString(),
                                            ScreenContainer.Buttons.BACK.toString()};

        //Array of operating program buttons in main screen
        String[] buttonsInMainMenu = {ScreenContainer.Screens.OPERATING_PROGRAM_STAND_BY.toString(),
                                    ScreenContainer.Screens.OPERATING_PROGRAM_DHW.toString(),
                                    ScreenContainer.Screens.OPERATING_PROGRAM_HEATING_DHW.toString()};

        ArrayList<Target> targetsInMainMenu = basicFunction.mapTargets(buttonsInMainMenu);
        ArrayList<ScreenRegion> regionsInMainMenu = basicFunction.mapRegions(targetsInMainMenu);

        if (regionsInMainMenu.get(0) != null || regionsInMainMenu.get(1) != null || regionsInMainMenu.get(2) != null){
            for (int i=0; i<regionsInMainMenu.size(); i++) {
                if (regionsInMainMenu.get(i) != null){
                    basicFunction.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),0);
                    break;
                }
            }
            ArrayList<Target> targetsInOperatingProgram = basicFunction.mapTargets(buttonsInOperatingModeMenu);
            ArrayList<ScreenRegion> regionsInOperatingProgram = basicFunction.mapRegions(targetsInOperatingProgram);
            //Test
            for(int i=0; i<3; i++){
                basicFunction.click(regionsInOperatingProgram.get(i) ,targetsInOperatingProgram.get(i),0);
                basicFunction.click(regionsInOperatingProgram.get(3) ,targetsInOperatingProgram.get(3),0);
                if (basicFunction.checkIfExist(buttonsInMainMenu[i])){
                    basicFunction.click(regionsInMainMenu.get(2), targetsInMainMenu.get(2),0);
                    result = true;
                }
            }
        }
        basicFunction.goToMainMenu();
        return result;
    }
}