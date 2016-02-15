package testFramework;

import org.sikuli.api.*;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import java.io.File;
import java.util.ArrayList;

public class GUIElement {

    Mouse mouse;

    public GUIElement(){
        mouse = new DesktopMouse();
    }
    /****************************************************************************************
     * Find target object on the screen.
     *
     * @param name	    name of the object from images path
     * @return File  	desired image
     */
    public File findByName(String name){
        if(name == null) {
            throw new IllegalArgumentException("Cannot find elements when name text is null.");
        }else {
            return(new File("images/screens/" + name));
        }
    }
    /****************************************************************************************
     * Click on region.
     *
     * @param region	Region which will be clicked
     * @param target    Target which will be clicked
     * @param delay     delay when clicking
     */
    public void click(ScreenRegion region, Target target, int delay){
        if(region == null && target == null){
            throw new IllegalArgumentException("Cannot click on elements when region and target are null.");
        }else {
            mouse.move(region.getCenter());
            region.wait(target, delay);
            mouse.press();
            region.wait(target, delay);
            mouse.release();
            region.wait(target, delay);
        }
    }
    /****************************************************************************************
     * Click on target region.
     *
     * @param region	Region which will be clicked
     * @param target    Target which will be clicked
     * @param loc       Location where mouse pointer should be moved
     * @param delay     delay when clicking
     */
    public void clickOnTargetLoacation(ScreenRegion region, Target target, int loc, int delay){
        //Array of target region locations. Select the proper one where mouse pointer should be moved and the cliked.
        ScreenLocation[] locations = {
            region.getLowerLeftCorner(),    //0
            region.getUpperRightCorner(),   //1
            region.getCenter(),             //2
            region.getLowerRightCorner(),   //3
            region.getUpperLeftCorner()     //4
        };
        if(region == null && target == null){
            throw new IllegalArgumentException("Cannot click on elements when region and target are null.");
        }else {
            mouse.move(locations[loc]);
            region.wait(target, delay);
            mouse.press();
            region.wait(target, delay);
            mouse.release();
            region.wait(target, delay);
        }
    }
    /****************************************************************************************
     * Generate list of targets from list of targets.
     *
     * @param image	List of patterns to generate list of targets
     *
     * @return list of targets
     */
    public ArrayList<Target> mapTargets(String[] image){
        ArrayList<Target> targetList = new ArrayList<Target>();
        for(int i=0; i<image.length; i++){
            Target target = new ImageTarget(findByName(image[i]));
            targetList.add(target);
            targetList.get(i).setMinScore(Constants.DEFAULT_MINSCORE);
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

    public boolean clickIfExist(String pattern, int loc){
        String patterns[] = {pattern};
        ArrayList<Target> targets = mapTargets(patterns);
        ArrayList<ScreenRegion> regions = mapRegions(targets);
        if(targets.get(0)!= null && regions.get(0)!= null){
            clickOnTargetLoacation(regions.get(0),targets.get(0), loc, 0);
            return true;
        }else{
            System.out.println(pattern + " " + "not found.");
            return false;
        }
    }

}
