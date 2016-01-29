package automatedTestFramework;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {

    String host;
    int port;
    Socket socket = null;

    public Connection(){}
    public Connection(String host, int port){
        this.host = host;
        this.port = port;
    }

    /****************************************************************************************
     * Open socket to HI931.
     *
     * @return socket to HI931
     */
    public Socket openSocket(){
        try{
            socket = new Socket(host, port);
        }catch(IOException e){
            e.printStackTrace();
        }
        return socket;
    }
    /****************************************************************************************
     * Close opened socket to HI931.
     *
     * @param socket	close socket to HI931 simulator
     */
    public void closeSocket(Socket socket){
        try{
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /****************************************************************************************
     * Insert data point values to HI931.
     *
     * @param socket	open socket to HI931 simulator
     * @param code value which we want to send, taken from Const.java file
     */
    public void sendMessageToHI(Socket socket, String code){
        DataOutputStream os;
        try{
            os = new DataOutputStream(socket.getOutputStream());
            os.writeBytes(code);
            try{
                Thread.sleep(2000);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
