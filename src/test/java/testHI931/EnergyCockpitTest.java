package testHI931;

import org.sikuli.slides.api.SlideExecutionException;
import testFramework.Connection;
import testFramework.Driver;
import testFramework.GUIElement;

import java.net.Socket;

public class EnergyCockpitTest {

    Driver driver;
    Connection connect;
    GUIElement guielem;

    public EnergyCockpitTest(){
        driver = new Driver();
        connect = new Connection();
        guielem = new GUIElement();
    }

    public boolean checkSchema(Socket socket, String msg, String screen) throws Exception {
        boolean result = false;
        driver.goToEnergyCockpit();
        connect.sendMessageToHI(socket, msg);
        if(guielem.checkIfExist(screen)){
            result = true;
        }else throw new SlideExecutionException();
        return result;
    }
}
