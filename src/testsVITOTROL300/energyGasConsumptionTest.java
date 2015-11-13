package testsVITOTROL300;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import automatedTestFramework.BasicFunctions;
import automatedTestFramework.Logger;

public class energyGasConsumptionTest {
	public static double HIGH_MINSCORE = 0.95;
	public static double DEFAULT_MINSCORE = 0.9;
	public static double LOWER_MINSCORE = 0.85;
	String separator = "----------------------------------------------------------------------------------------------------------------------------";
	
	BasicFunctions basicFunction = new BasicFunctions();
	Logger log = new Logger();

	
	public boolean checkGas(){
							
	System.out.println("++++++++++++++++++++++++++++++++++++++++ checkOperatingProgramHeader() test ++++++++++++++++++++++++++++++++++++++++");
	System.out.println(separator);
							
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
			return result;
		}
		
	
		public boolean checkEnergy(){
			
			System.out.println("++++++++++++++++++++++++++++++++++++++++ checkOperatingProgramFooter() test ++++++++++++++++++++++++++++++++++++++++");
			System.out.println(separator);
			
			boolean result = false;
			
			String operatingProgramFooter = "HC1OperatingProgramFooter.JPG";
			
			ScreenRegion region = new DesktopScreenRegion();
			Target target = new ImageTarget(basicFunction.findImageByName(operatingProgramFooter));
			target.setMinScore(LOWER_MINSCORE);
			ScreenRegion r = region.find(target);
			if(r != null){
				result = true;
				System.out.println("Found Operating Program footer" + " " + r + operatingProgramFooter);			
				System.out.println("Test: Success" + '\n' 
									+ separator);
			} 
			else{
				System.out.println("Operating Program footer" + " " + operatingProgramFooter + " " + "has not been found." + " " + r + " " + "returned.");
				System.out.println("Test: Fail" + '\n' 
									+ separator);
			}
			return result;
	}
}
	
	
	
	