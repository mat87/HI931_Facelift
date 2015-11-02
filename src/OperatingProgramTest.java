import java.util.ArrayList;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;


public class OperatingProgramTest {
	
	public static double DEFAULT_MINSCORE = 0.8;
	String separator = "----------------------------------------------------------------------------------------------------------------------------";
	
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();
	
	/*
	 * Check if Operating Program screen contains proper buttons. 
	 */
	public boolean checkOperatingProgramButton(){
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkOperatingProgramButton() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(separator);
		long startTest = System.currentTimeMillis();
		
		boolean result = false;
		
		String[] buttons = {"StandbyMode.jpg",
							"DHWOnly.JPG",
							"HeatingAndDHW.JPG"};
	
		ScreenRegion region = new DesktopScreenRegion();
		Target target1 = new ImageTarget(basicFunction.findButtonByName(buttons[0]));
		Target target2 = new ImageTarget(basicFunction.findButtonByName(buttons[1]));
		Target target3 = new ImageTarget(basicFunction.findButtonByName(buttons[2]));
		
		target1.setMinScore(DEFAULT_MINSCORE);
		target2.setMinScore(DEFAULT_MINSCORE);
		target3.setMinScore(DEFAULT_MINSCORE);

		ScreenRegion r1 = region.find(target1);
		ScreenRegion r2 = region.find(target2);
		ScreenRegion r3 = region.find(target3);
		
		ScreenRegion[] regions = {r1, r2, r3};
		
		if(r1 != null && r2 != null && r3 != null){
			result = true;
			for(int i = 0, j = 0 ; i < regions.length && j < buttons.length ; i++, j++)
			{
				System.out.printf("Found button: " + regions[i] + buttons[j] + "\n");
			}	
			System.out.println("Test: Success" + '\n' 
								+ separator);
		}
		else{
			for(int i = 0, j = 0 ; i < buttons.length && j < regions.length ; i++, j++){
				System.out.printf("Button" + " " + buttons[i] + " " + "has not been found. " + regions[j] + " " + "returned.\n");
			}
			System.out.println("Test: Fail" + '\n' 
								+ separator);
		}	
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
	
	/*
	 * Check if Operating Program screen contains proper Header as in GUI spec. 
	 */
	public boolean checkOperatingProgramHeader(){
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkOperatingProgramHeader() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(separator);
		long startTest = System.currentTimeMillis();
		
		boolean result = false;
		
		String operatingProgramHeader = "HC1OperatingProgramHeader.JPG";
		
		ScreenRegion region = new DesktopScreenRegion();
		Target target = new ImageTarget(basicFunction.findImageByName(operatingProgramHeader));
		target.setMinScore(DEFAULT_MINSCORE);
		ScreenRegion r = region.find(target);
		
		if(r != null){
			result = true;
			System.out.println("Found Operating Program header" + " " + r + operatingProgramHeader);
			System.out.println("Test: Success" + '\n' 
								+ separator);
		}
		else{
			System.out.println("Operating Program header" + " " + operatingProgramHeader + " " + "has not been found." + " " + r + " " + "returned.");
			System.out.println("Test: Fail" + '\n' 
								+ separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
	
	/*
	 * Check if Operating Program screen contains proper Footer as in GUI specification. 
	 */
	public boolean checkOperatingProgramFooter(){
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++ checkOperatingProgramFooter() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(separator);
		long startTest = System.currentTimeMillis();
		
		boolean result = false;
		
		String operatingProgramFooter = "HC1OperatingProgramFooter.JPG";
		
		ScreenRegion region = new DesktopScreenRegion();
		Target target = new ImageTarget(basicFunction.findImageByName(operatingProgramFooter));
		target.setMinScore(DEFAULT_MINSCORE);
		ScreenRegion r = region.find(target);
		
		if(r != null){
			result = true;
			System.out.println("Found Operating Program footer" + " " + r + operatingProgramFooter);			
			System.out.println("Test: Success" + '\n' 
								+ separator);
			return result;
		} 
		else{
			System.out.println("Operating Program footer" + " " + operatingProgramFooter + " " + "has not been found." + " " + r + " " + "returned.");
			System.out.println("Test: Fail" + '\n' 
								+ separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}	
	
	/*
	 * Set Operating Program and check if selected correctly.
	 */
	public boolean setOperatingProgram(){
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++ setOperatingProgram() test ++++++++++++++++++++++++++++++++++++++++");
		System.out.println(separator);
		boolean result = false;
		long startTest = System.currentTimeMillis();
		
		ArrayList<String> buttonList = new ArrayList<String>();
		buttonList.add("OperatingProgramStandby.JPG");
		buttonList.add("OperatingProgramDHW.JPG");
		buttonList.add("OperatingProgramHeatingDHW.JPG");
		
		ScreenRegion region = new DesktopScreenRegion();
		Target target1 = new ImageTarget(basicFunction.findButtonByName(buttonList.get(0)));
		Target target2 = new ImageTarget(basicFunction.findButtonByName(buttonList.get(1)));
		Target target3 = new ImageTarget(basicFunction.findButtonByName(buttonList.get(2)));
		ArrayList<Target> targetList = new ArrayList<Target>();
		targetList.add(target1);
		targetList.add(target2);
		targetList.add(target3);
		
		for(int idx = 0; idx < 3; idx++){
			targetList.get(idx).setMinScore(DEFAULT_MINSCORE);
		}
		
		ScreenRegion r1 = region.find(targetList.get(0));
		//ScreenRegion r2 = region.find(targetList.get(1));
		//ScreenRegion r3 = region.find(targetList.get(2));
		System.out.println(r1);
		//System.out.println(r2);
		//System.out.println(r3);
		System.out.println("-----------------------------------------------------------------");
		
		if(r1 == null){
			result = true;
			basicFunction.click(r1, targetList.get(1),2);
			System.out.println("Found Operating Program button" + " " + r1 + buttonList.get(1));			
			System.out.println("Test: Success" + '\n' 
								+ separator);
		}
		/*else if(r2 != null){
			result = true;
			basicFunction.click(r2, targetList.get(1),2);
			System.out.println("Found Operating Program button" + " " + r2 + buttonList.get(1));			
			System.out.println("Test: Success" + '\n' 
								+ separator);
		}
		else if(r1 != null){
			result = true;
			basicFunction.click(r1, targetList.get(0),2);
			System.out.println("Found Operating Program button" + " " + r1 + buttonList.get(2));			
			System.out.println("Test: Success" + '\n' 
								+ separator);
		}*/
		else{
			System.out.println("Operating Program buttons" + " " + /*buttonList.get(0) + buttonList.get(1) +*/ buttonList.get(2) + " " + 
								"have not been found." + " " + /*r1 + */r1  + " " + "returned.");
			System.out.println("Test: Fail" + '\n' 
								+ separator);
		}
		long endTest = System.currentTimeMillis();
		log.testExecutedInMs(startTest, endTest);
		return result;
	}
}