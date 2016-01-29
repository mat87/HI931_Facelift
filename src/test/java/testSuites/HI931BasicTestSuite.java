package testSuites;

import org.testng.Assert;
import org.testng.annotations.Test;
import automatedTestFramework.BasicFunctions;
import testHI931.BoilerTemperatureTest;
import testHI931.OperatingProgramTest;
import testHI931.OutsideTemperatureTest;
import testHI931.RoomTemperatureTest;

public class HI931BasicTestSuite {

    BoilerTemperatureTest btt = new BoilerTemperatureTest();
    RoomTemperatureTest rtt = new RoomTemperatureTest();
    OperatingProgramTest opt = new OperatingProgramTest();
    OutsideTemperatureTest ott = new OutsideTemperatureTest();
    BasicFunctions func = new BasicFunctions();

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
}
