package testFramework;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetUp {

    Driver func;

    String path = "C:\\Workspace\\viessmann-hi-931\\build\\bin\\";
    String app = "simulator.exe";

    public SetUp() {
        func = new Driver();
    }

    @BeforeTest (alwaysRun = true)
    public void setUp() throws IOException, InterruptedException{
        func.runApplication(path, app);
        Thread.sleep(3000);
    }


    @AfterTest (alwaysRun = true)
    public void tearDown() throws IOException{
        func.killApplication(app);
    }
}
