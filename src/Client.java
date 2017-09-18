import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by stagiaire on 14/09/2017.
 */
public class Client {
    private ServerSocket socketServer = null;

    public static void main(String[] args){
        Socket socket;

        try{
            socket = new Socket("172.16.100.12", 2009);
            OutputStream outStream = socket.getOutputStream();
            outStream.write("data send to server".getBytes());
            outStream.flush();
            InputStream inStream = socket.getInputStream();
            byte[] b = new byte[4096];
            int command = inStream.read(b);
            String result = new String(b,0, command);
            System.out.println(result);
            socket.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
