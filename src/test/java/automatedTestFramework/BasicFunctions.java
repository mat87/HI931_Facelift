package automatedTestFramework;
import java.io.File;
import java.io.IOException;
import automatedTestFramework.Const;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.image.BufferedImage;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;

public class BasicFunctions{
    public static final double HIGH_MINSCORE = 0.95;
    public static final double DEFAULT_MINSCORE = 0.9;
    public static final double LOWER_MINSCORE = 0.85;

    Mouse mouse = new DesktopMouse();
    Robot robot;

    public BasicFunctions(){
        try{
            robot = new Robot();
        }catch(AWTException e){
            e.printStackTrace();
        }
    }
    /****************************************************************************************
     * Find target button on the screen.
     *
     * @param name	full path and name of application
     * @return File  	desired image
     */
    public File findButtonByName(String name){
        return(new File("images/screens/" + name));
    }
    /****************************************************************************************
     * Find target icon on the screen.
     *
     * @param name	full path and name of application
     * @return File  	desired image
     */
    public File findIconByName(String name){
        return(new File("images/screens/" + name));
    }
    /****************************************************************************************
     * Find target image on the screen.
     *
     * @param name		full path and name of application
     * @return File  	desired image
     */
    public File findImageByName(String name){
        return(new File("images/screens/" + name));
    }
    /****************************************************************************************
     * Click on region.
     *
     * @param region	Region which will be clicked
     * @param target    Target which will be clicked
     * @param delay     delay when clicking
     */
    public void click(ScreenRegion region, Target target, int delay){
        Mouse mouse = new DesktopMouse();
        mouse.move(region.getCenter());
        region.wait(target, delay);
        mouse.press();
        region.wait(target, delay);
        mouse.release();
        region.wait(target, delay);
    }
    /****************************************************************************************
     * Generate list of targets from list of targets.
     *
     * @param buttons	List of patterns to generate list of targets
     *
     * @return list of targets
     */
    public ArrayList<Target> mapTargets(String[] buttons){
        ArrayList<Target> targetList = new ArrayList<Target>();
        for(int i=0; i<buttons.length; i++){
            Target target = new ImageTarget(findButtonByName(buttons[i]));
            targetList.add(target);
            targetList.get(i).setMinScore(Const.DEFAULT_MINSCORE);
        }
        return targetList;
    }
    /****************************************************************************************
     * Generate list of regions from list of patterns.
     *
     * @param targetList	List of targets to generate list of regions
     *
     * @return list of regions
     */
    public ArrayList<ScreenRegion> mapRegions(ArrayList<Target> targetList){
        ScreenRegion region = new DesktopScreenRegion();
        ArrayList<ScreenRegion> regions = new ArrayList<ScreenRegion>();
        for(int i=0; i<targetList.size(); i++){
            ScreenRegion r = region.find(targetList.get(i));
            regions.add(r);
        }
        return regions;
    }
    /****************************************************************************************
     * Check if pattern occurs in display.
     *
     * @param pattern	pattern which will be checked if exists
     *
     * @return true if pattern exists
     */
    public boolean checkIfExist(String pattern){
        String patterns[] = {pattern};
        ArrayList<Target> targets = mapTargets(patterns);
        ArrayList<ScreenRegion> regions = mapRegions(targets);
        if(targets.get(0)!= null && regions.get(0)!= null)
            return true;
        else
            return false;
    }
    /****************************************************************************************
     * If pattern exists click on it.
     *
     * @param pattern	pattern which will be checked if exists
     *
     * @return true if pattern exist and was clicked
     */
    public boolean clickIfExist(String pattern){
        String patterns[] = {pattern};
        ArrayList<Target> targets = mapTargets(patterns);
        ArrayList<ScreenRegion> regions = mapRegions(targets);
        if(targets.get(0)!= null && regions.get(0)!= null){
            click(regions.get(0),targets.get(0),0);
            return true;
        }else{
            System.out.println(pattern + " " + "not found.");
            return false;
        }
    }
    /****************************************************************************************
     * Go to main menu.
     */
    public void goToMainMenu() {
        String[] buttons = {"Home.JPG"};
        ArrayList<Target> targets = mapTargets(buttons);
        ArrayList<ScreenRegion> regions = mapRegions(targets);
        if (targets.get(0)!= null && regions.get(0) != null)
            click(regions.get(0),targets.get(0),2);
    }
    /****************************************************************************************
     * Go to DHW menu.
     */
    public void goToDhwMenu() {
        goToMainMenu();
        clickIfExist("Menu.JPG");
        clickIfExist("DhwMenu.JPG");
    }
    /****************************************************************************************
     * Go to Settings menu.
     */
    public void goToSettingsMenu() {
        goToMainMenu();
        clickIfExist("Menu.JPG");
        clickIfExist("SettingsButton.JPG");
    }
    /****************************************************************************************
     * Go to Favourites menu.
     */
    public void goToFavouritesMenu() {
        goToMainMenu();
        clickIfExist("Left.JPG");
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