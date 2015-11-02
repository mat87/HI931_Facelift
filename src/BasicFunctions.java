import java.io.File;
import java.io.IOException;

import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;

public class BasicFunctions{
	
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
	
	public boolean isObjectAvailable(){
		boolean result = false;
		
		
		
		
		
		return result;
	}
}
