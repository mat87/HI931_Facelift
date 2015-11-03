import java.io.IOException;

public class ExecuteTests {
	
	public static void main(String[] args) throws IOException 
	{
		TestExecutor executor = new TestExecutor();
		BasicFunctions func = new BasicFunctions();
		String path = "C:\\Workspace\\viessmann-hi-931\\build\\bin\\";
		String app = "simulator.exe";

		if(func.runApplication(path, app)){
			executor.testToExecute();
			func.killApplication(app);
		}
		else{
			System.out.printf("Tests not executed");
		}
	}
}
