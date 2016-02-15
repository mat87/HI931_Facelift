package testSuites;

import org.testng.Assert;
import org.testng.annotations.Test;
import testHI931.BoilerTemperatureTest;
import testHI931.OperatingProgramTest;
import testHI931.OutsideTemperatureTest;
import testHI931.RoomTemperatureTest;

public class HI931BasicTestSuite {

    BoilerTemperatureTest btt;
    RoomTemperatureTest rtt;
    OperatingProgramTest opt;
    OutsideTemperatureTest ott;

    public HI931BasicTestSuite(){
        btt = new BoilerTemperatureTest();
        rtt = new RoomTemperatureTest();
        opt = new OperatingProgramTest();
        ott = new OutsideTemperatureTest();
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
}
