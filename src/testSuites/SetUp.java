package testSuites;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import automatedTestFramework.BasicFunctions;

public class SetUp {
	
	BasicFunctions func = new BasicFunctions();
	
	String path = "C:\\Workspace\\viessmann-hi-931\\build\\bin\\";
	String app = "simulator.exe";
	
	
	@BeforeTest
	public void setUp() throws FileNotFoundException, IOException, InterruptedException{
		func.runApplication(path, app);
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown() throws IOException{
		func.killApplication(app);
	}
}
