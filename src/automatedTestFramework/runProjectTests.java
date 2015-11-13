package automatedTestFramework;

import java.io.IOException;

public class runProjectTests {
	
	public static void main(String[] args) throws IOException 
	{
		String projectName = args[0];
		String suiteType = args[1];
		String specificTestNames = args[2];
		String path = "";
		String app = "";
		Suite suite = new Suite();
		Tests tests = new Tests();
		BasicFunctions func = new BasicFunctions();
		
		if(projectName.equals("HI931")){	
			path = "C:\\Workspace\\viessmann-hi-931\\build\\bin\\";
			app = "simulator.exe";
		}else if(projectName.equals("VITOTROL300")){
			path = "C:\\Workspace\\viessmann-hi-931\\build\\bin\\";
			app = "simulator.exe";
		}
		
		if(func.runApplication(path, app)){
			if (args[2] == null){
				tests.executeTests(projectName, specificTestNames);
			}else{
				suite.executeSuite(projectName, suiteType);
			}
			func.killApplication(app);
		}
		else{
			System.out.printf("Tests not executed");
		}
	}
}

