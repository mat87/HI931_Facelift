package testHI931;

import java.util.ArrayList;

import testFramework.Constants;
import testFramework.ScreenContainer;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import testFramework.Driver;
import testFramework.GUIElement;


public class OperatingProgramTest {

    GUIElement guielem;
    Driver driver;

    public OperatingProgramTest(){
        driver = new Driver();
        guielem = new GUIElement();
    }
    /*
     * Check if Operating Program screen contains proper Header as in GUI spec.
     */
    public boolean checkOperatingProgramHeader() throws InterruptedException{

        boolean result = false;
        String testName = Thread.currentThread().getStackTrace()[0].getMethodName();

        driver.goToMainMenu();

        String[] buttonsInMainMenu = {ScreenContainer.Screens.OPERATING_PROGRAM_STAND_BY.toString(),
                                    ScreenContainer.Screens.OPERATING_PROGRAM_DHW.toString(),
                                    ScreenContainer.Screens.OPERATING_PROGRAM_HEATING_DHW.toString()};

        ArrayList<Target> targetsInMainMenu = guielem.mapTargets(buttonsInMainMenu);
        ArrayList<ScreenRegion> regionsInMainMenu = guielem.mapRegions(targetsInMainMenu);

        if (regionsInMainMenu.get(0) != null || regionsInMainMenu.get(1) != null || regionsInMainMenu.get(2) != null){
            for (int i=0; i<regionsInMainMenu.size(); i++) {
                if (regionsInMainMenu.get(i) != null){
                    guielem.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),0);
                    break;
                }else{
                    driver.getScreenShoot(Constants.FILE_PATH, testName);}
            }
        }else{
            driver.getScreenShoot(Constants.FILE_PATH, testName);}
        if (guielem.checkIfExist(ScreenContainer.Screens.HC1_OPERATING_PROGRAM_HEADER.toString())){
            result = true;}
        else{
            driver.getScreenShoot(Constants.FILE_PATH, testName);}
        return result;
    }

	/*
	 * Check if Operating Program screen contains proper Footer as in GUI specification.
	 */
    public boolean checkOperatingProgramFooter() throws InterruptedException{
        boolean result = false;
        driver.goToMainMenu();
        //Array of buttons in operating program
        String[] buttonsInMainMenu = {ScreenContainer.Screens.OPERATING_PROGRAM_STAND_BY.toString(),
                                    ScreenContainer.Screens.OPERATING_PROGRAM_DHW.toString(),
                                    ScreenContainer.Screens.OPERATING_PROGRAM_HEATING_DHW.toString()};

        ArrayList<Target> targetsInMainMenu = guielem.mapTargets(buttonsInMainMenu);
        ArrayList<ScreenRegion> regionsInMainMenu = guielem.mapRegions(targetsInMainMenu);

        if (regionsInMainMenu.get(0) != null || regionsInMainMenu.get(1) != null || regionsInMainMenu.get(2) != null){
            for (int i=0; i<regionsInMainMenu.size(); i++) {
                if (regionsInMainMenu.get(i) != null){
                    guielem.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),0);
                    break;
                }
            }
        }
        if (guielem.checkIfExist(ScreenContainer.Screens.HC1_OPERATING_PROGRAM_FOOTER.toString())){
            result = true;
        }
        driver.goToMainMenu();
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

        ArrayList<Target> targetsInMainMenu = guielem.mapTargets(buttonsInMainMenu);
        ArrayList<ScreenRegion> regionsInMainMenu = guielem.mapRegions(targetsInMainMenu);

        if (regionsInMainMenu.get(0) != null || regionsInMainMenu.get(1) != null || regionsInMainMenu.get(2) != null){
            for (int i=0; i<regionsInMainMenu.size(); i++) {
                if (regionsInMainMenu.get(i) != null){
                    guielem.click(regionsInMainMenu.get(i), targetsInMainMenu.get(i),0);
                    break;
                }
            }
            ArrayList<Target> targetsInOperatingProgram = guielem.mapTargets(buttonsInOperatingModeMenu);
            ArrayList<ScreenRegion> regionsInOperatingProgram = guielem.mapRegions(targetsInOperatingProgram);
            //Test
            for(int i=0; i<3; i++){
                guielem.click(regionsInOperatingProgram.get(i) ,targetsInOperatingProgram.get(i),0);
                guielem.click(regionsInOperatingProgram.get(3) ,targetsInOperatingProgram.get(3),0);
                if (guielem.checkIfExist(buttonsInMainMenu[i])){
                    guielem.click(regionsInMainMenu.get(2), targetsInMainMenu.get(2),0);
                    result = true;
                }
            }
        }
        driver.goToMainMenu();
        return result;
    }
}