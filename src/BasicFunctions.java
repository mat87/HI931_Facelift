import java.io.File;
import java.io.IOException;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;

public class BasicFunctions{
	
	/**
	 * Find target Button on the screen.
	 *  
	 * @param name	full path and name of application
	 */
	public File findButtonByName(String name){
		return(new File("images/buttons/" + name));
	}
	
	public File findIconByName(String name){
		return(new File("images/icons/" + name));
	}
	
	public File findImageByName(String name){
		return(new File("images/others/" + name));
	}
	
	public void click(ScreenRegion region, Target target, int delay){
		Mouse mouse = new DesktopMouse();	
		mouse.move(region.getCenter());
		region.wait(target, delay);
		mouse.press();
		region.wait(target, delay);
		mouse.release();
		region.wait(target, delay);
	}
	
	/**
	 * Run target application (process).
	 *  
	 * @param path	path to target application
	 * @param app	name of application
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
	
	/**
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
	
	/**
	 * Generates list of true to compare after test execution. 
	 * 
	 */
	public boolean[] generateTrueList(int length){
		boolean[] trueList = new boolean[length];
		for (int i=0; i<length;i++){
		trueList[i]= true;
		};
		return trueList;
	}
}
