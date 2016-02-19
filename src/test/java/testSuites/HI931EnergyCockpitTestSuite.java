package testSuites;

import org.testng.Assert;
import org.testng.annotations.*;
import testFramework.Connection;
import testFramework.Constants;
import testFramework.Driver;
import testFramework.ScreenContainer;
import testHI931.EnergyCockpitTest;
import java.net.Socket;


public class HI931EnergyCockpitTestSuite {

    Connection connect;
    Socket socket;
    EnergyCockpitTest ect;
    Driver driver;

    public HI931EnergyCockpitTestSuite(){
        connect = new Connection("localhost", 8899);
        driver = new Driver();
        ect = new EnergyCockpitTest(connect);
    }

    @DataProvider(name = "energyCockpitProvider")
    public Object[][] getData(){
        return new Object[][]{
                {Constants.Boiler.VD333F, ScreenContainer.Screens.VD333F_ENERGY_COCKPIT.toString()},
                {Constants.Boiler.VD343, ScreenContainer.Screens.VD343_ENERGY_COCKPIT.toString()},
                {Constants.Boiler.VITOSOLAR_300F, ScreenContainer.Screens.VITOSOLAR300F_ENERGY_COCKPIT.toString()},
                {Constants.Boiler.VD300, ScreenContainer.Screens.VD300_CUVC_ENERGY_COCKPIT.toString()},
                {Constants.Cylinder.DUAL, ScreenContainer.Screens.VD300_DUAL_ENERGY_COCKPIT.toString()}
        };
    }

    @BeforeClass
    public void setUpTest(){
        socket = connect.openSocket();
        driver.goToEnergyCockpit();
    }

    @Test(dataProvider = "energyCockpitProvider")
    public void checkEnergyCockpit(String s1, String s2) throws Exception {
        boolean result = ect.checkSchema(socket, s1, s2);
        if(!result){
            driver.getScreenShoot(Constants.FILE_PATH, s2);
        }
        Assert.assertTrue(result);
    }

    @AfterClass
    public void endTest(){
        connect.closeSocket(socket);
    }

}
