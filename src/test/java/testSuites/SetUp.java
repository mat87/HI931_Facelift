package testSuites;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import automatedTestFramework.BasicFunctions;

public class SetUp {

    BasicFunctions func;

    String path = "C:\\Workspace\\viessmann-hi-931\\build\\bin\\";
    String app = "simulator.exe";

    public SetUp() {
        func = new BasicFunctions();
    }

    @BeforeTest (alwaysRun = true)
    public void setUp() throws FileNotFoundException, IOException, InterruptedException{
        func.runApplication(path, app);
        Thread.sleep(3000);
    }

    @AfterTest (alwaysRun = true)
    public void tearDown() throws IOException{
        func.killApplication(app);
    }
}
