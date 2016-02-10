package testSuites;

import java.net.Socket;
import testFramework.Constants;
import testFramework.ScreenContainer;
import org.testng.Assert;
import org.testng.annotations.*;
import testFramework.Connection;
import testFramework.Driver;
import testHI931.PopupTest;


public class HI931PopupsTestSuite {

    PopupTest popt;
    Driver driver;
    Connection connect;
    Socket socket;

    public HI931PopupsTestSuite(){
        popt = new PopupTest();
        driver = new Driver();
        connect = new Connection("localhost", 8899);
    }

    @DataProvider(name = "popupsProvider")
    public Object[][] getData(){
        return new Object[][]{
                {Constants.Popup.FAULT_POPUP, ScreenContainer.Popups.FAULT_2.toString(), ScreenContainer.Buttons.CONFIRM_BUTTON.toString(),  ScreenContainer.Screens.PLUS_MINUS_ON_HOME_SCRREN.toString()},
                {Constants.Popup.SERVICE_POPUP, ScreenContainer.Popups.SERVICE.toString(), ScreenContainer.Buttons.CONFIRM_BUTTON.toString(), ScreenContainer.Screens.PLUS_MINUS_ON_HOME_SCRREN.toString()},
                {Constants.Popup.BURNER_FAULT_POPUP, ScreenContainer.Popups.BURNER_FAULT.toString(), ScreenContainer.Buttons.CONFIRM_OK_BUTTON.toString(), ScreenContainer.Screens.PLUS_MINUS_ON_HOME_SCRREN.toString()},
                {Constants.Popup.TEST_OPERATION_POPUP, ScreenContainer.Popups.TEST_OPERATION.toString(), ScreenContainer.Buttons.OFF.toString(), ScreenContainer.Pages.MAIN_MENU_1.toString()},
        };
    }

    @BeforeClass
    public void startConnect(){
        socket = connect.openSocket();
    }

    @Test(dataProvider = "popupsProvider")
    public void checkPopup(String s1, String s2, String s3, String s4){
        boolean result = popt.checkPopup(socket, s1, s2 ,s3 ,s4);
        if(!result){
            driver.getScreenShoot(Constants.FILE_PATH, s2);
        }
        Assert.assertTrue(result);
    }

    @AfterClass
    public void endConnect(){
        connect.closeSocket(socket);
    }
}
