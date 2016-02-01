package testSuites;

import java.net.Socket;
import automatedTestFramework.Const;
import automatedTestFramework.ScreenContainer;
import org.testng.Assert;
import org.testng.annotations.Test;
import automatedTestFramework.Connection;
import automatedTestFramework.BasicFunctions;
import testHI931.PopupTest;


public class HI931PopupsTestSuite {

    PopupTest popt;
    BasicFunctions basicFunctions;
    Connection connect;
    Socket socket;

    public HI931PopupsTestSuite(){
        popt = new PopupTest();
        basicFunctions = new BasicFunctions();
        connect = new Connection("localhost", 8899);
    }

    @Test
    public void popupsTest(){
        socket = connect.openSocket();
        Assert.assertTrue(faultPopupTest());
        //Assert.assertTrue(servicePopupTest());
        //Assert.assertTrue(burnerFaultPopupTest());
        //Assert.assertTrue(operationPopupTest());
        connect.closeSocket(socket);
    }

    public boolean faultPopupTest(){
        boolean result = popt.checkPopup(socket,
                                        Const.Popup.FAULT_POPUP,
                                        ScreenContainer.Popups.FAULT_2.toString(),
                                        ScreenContainer.Buttons.CONFIRM_BUTTON.toString(),
                                        ScreenContainer.Screens.PLUS_MINUS_ON_HOME_SCRREN.toString());
        return result;
    }

    public boolean servicePopupTest(){
        boolean result = popt.checkPopup(socket,
                                        Const.Popup.SERVICE_POPUP,
                                        ScreenContainer.Popups.SERVICE.toString(),
                                        ScreenContainer.Buttons.CONFIRM_BUTTON.toString(),
                                        ScreenContainer.Screens.PLUS_MINUS_ON_HOME_SCRREN.toString());
        return result;
    }

    public boolean burnerFaultPopupTest(){
        boolean result = popt.checkPopup(socket,
                                        Const.Popup.BURNER_FAULT_POPUP,
                                        ScreenContainer.Popups.BURNER_FAULT.toString(),
                                        ScreenContainer.Buttons.CONFIRM_OK_BUTTON.toString(),
                                        ScreenContainer.Screens.PLUS_MINUS_ON_HOME_SCRREN.toString());
        return result;
    }

    public boolean operationPopupTest(){
        boolean result = popt.checkPopup(socket,
                                        Const.Popup.TEST_OPERATION_POPUP,
                                        ScreenContainer.Popups.TEST_OPERATION.toString(),
                                        ScreenContainer.Buttons.OFF.toString(),
                                        ScreenContainer.Pages.MAIN_MENU_1.toString());
        return result;
    }
}
