package testFramework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.image.BufferedImage;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;

public class Driver {

    Mouse mouse;
    Robot robot;
    GUIElement guielem;

    public Driver(){
        mouse = new DesktopMouse();
        guielem = new GUIElement();
        try{
            robot = new Robot();
        }catch(AWTException e){
            e.printStackTrace();
        }
    }
    /****************************************************************************************
     * Go to main menu.
     */
    public void goToMainMenu() {
        String[] buttons = {ScreenContainer.Buttons.HOME.toString()};
        ArrayList<Target> targets = guielem.mapTargets(buttons);
        ArrayList<ScreenRegion> regions = guielem.mapRegions(targets);
        if (targets.get(0)!= null && regions.get(0) != null)
            guielem.click(regions.get(0),targets.get(0),2);
    }
    /****************************************************************************************
     * Go to DHW menu.
     */
    public void goToDhwMenu() {
        goToMainMenu();
        guielem.clickIfExist(ScreenContainer.Buttons.MENU.toString());
        guielem.clickIfExist(ScreenContainer.Buttons.DHW_MENU.toString());
    }
    /****************************************************************************************
     * Go to Settings menu page 1.
     */
    public void goToSettingsMenu1() {
        goToMainMenu();
        guielem.clickIfExist(ScreenContainer.Buttons.MENU.toString());
        guielem.clickIfExist(ScreenContainer.Buttons.SETTINGS_MENU.toString());
    }
    /****************************************************************************************
     * Go to Settings menu page 1.
     */
    public void goToSettingsMenu2(){
        guielem.clickIfExist(ScreenContainer.Buttons.MENU.toString());
        guielem.clickIfExist(ScreenContainer.Buttons.SETTINGS_MENU.toString());
        guielem.clickIfExist(ScreenContainer.Buttons.RIGHT.toString());
    }
    /****************************************************************************************
     * Go to Energy cockpit.
     */
    public void goToEnergyCockpit(){
        goToMainMenu();
        guielem.clickIfExist(ScreenContainer.Buttons.ENERGY_COCKPIT.toString());
    }
    /****************************************************************************************
     * Go to Favourites menu.
     */
    public void goToFavouritesMenu() {
        goToMainMenu();
        guielem.clickIfExist(ScreenContainer.Buttons.LEFT.toString());
    }
    /****************************************************************************************
     * Run target application (process).
     *
     * @param path	path to target application
     * @param app	name of application
     *
     * @return true if app successfully started
     */
    public boolean runApplication(String path, String app) throws IOException {
        boolean result = false;
        try {
            ProcessBuilder p = new ProcessBuilder();
            String fullPath = path + app;
            p.command(fullPath);
            p.start();
            result = true;
            System.out.println(fullPath + " " + "successfully oppened.");
        } catch (IOException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }
    /****************************************************************************************
     * Kill target application (process).
     *
     * @param app	application (process) to be killed.
     */
    public void killApplication(String app) throws IOException {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM " + app);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /****************************************************************************************
     * Generates list of true to compare after test execution.
     *
     * @parram Length of list
     *
     * @return trueList list of true
     */
    public boolean[] generateTrueList(int length){
        boolean[] trueList = new boolean[length];
        for (int i=0; i<length;i++){
            trueList[i]= true;
        };
        return trueList;
    }
    /****************************************************************************************
     * @param filePath	path where jpg file will be saved
     * @param fileName	name of jpg file
     *
     * Make a screen shoot in case of test fails
     */
    public void getScreenShoot(String filePath, String fileName){
        String fullPath = filePath + fileName;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rec = new Rectangle(dim);
        BufferedImage screen = robot.createScreenCapture(rec);
        try{
            ImageIO.write(screen, "jpg", new File(fullPath));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}