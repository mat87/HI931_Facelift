package testHI931;

import testFramework.Connection;
import testFramework.GUIElement;

import java.net.Socket;

public class EnergyCockpitTest {

    Connection connect;
    GUIElement guielem;

    public EnergyCockpitTest(){
        connect = new Connection();
        guielem = new GUIElement();
    }

    public boolean checkSchema(Socket socket, String msg, String screen) {
        boolean result = false;
        connect.sendMessageToHI(socket, msg);
        if(guielem.checkIfExist(screen)){
            result = true;
        }
        return result;
    }
}
