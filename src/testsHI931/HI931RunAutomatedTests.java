package testsHI931;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import automatedTestFramework.BasicFunctions;
import testsHI931.OperatingProgramTest;
import testsHI931.RoomTemperatureTest;

public class HI931RunAutomatedTests {
	
	BasicFunctions basicFunc = new BasicFunctions();
	BoilerTemperatureTest btt = new BoilerTemperatureTest();
	RoomTemperatureTest rtt = new RoomTemperatureTest();
	OperatingProgramTest opt = new OperatingProgramTest();
	OutsideTemperatureTest ott = new OutsideTemperatureTest();
	BasicFunctions func = new BasicFunctions();
	
	String path = "C:\\Workspace\\viessmann-hi-931\\build\\bin\\";
	String app = "simulator.exe";
	
	@BeforeClass
	public void startUp() throws FileNotFoundException, IOException, InterruptedException{
		func.runApplication(path, app);
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void testCheckOperatingProgramHeader() throws InterruptedException{
		boolean result = opt.checkOperatingProgramHeader();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 2)
	public void testCheckOperatingProgramFooter() throws InterruptedException{
		boolean result = opt.checkOperatingProgramFooter();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 3)
	public void testSetOperatingProgram() throws InterruptedException{
		boolean result = opt.setOperatingProgram();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 4)
	public void testSetRoomTemperatureHighest() throws InterruptedException{
		boolean result = rtt.setRoomTemperatureHighest();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 5)
	public void testSetRoomTemperatureLowest() throws InterruptedException{
		boolean result = rtt.setRoomTemperatureLowest();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 6)
	public void testCheckRoomTemperatureHeader() throws InterruptedException{
		boolean result = rtt.checkRoomTemperatureHeader();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 7)
	public void testCheckOutsideTemperature() throws InterruptedException{
		boolean result = ott.checkOutsideTemperature();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 8)
	public void testCheckBoilerTemperature() throws InterruptedException{
		boolean result = btt.checkBoilerTemperature();
		Assert.assertEquals(result, true);
	}
	
	@AfterClass
	public void endTest() throws IOException{
		func.killApplication(app);
	}
}
