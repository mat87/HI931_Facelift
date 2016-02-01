package automatedTestFramework;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import java.io.File;
import java.util.ArrayList;

public class GUIElement {

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
}
