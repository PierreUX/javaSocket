import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by stagiaire on 14/09/2017.
 */
public class AcceptClient implements Runnable {
    private ServerSocket socketServer;
    private Socket socket;
    private int nbrclient = 1;

    public AcceptClient(ServerSocket s){
        socketServer = s;
    }

    @Override
    public void run(){
        try{
            while(true){
                socket = socketServer.accept();
                System.out.println("Le client numéro "+nbrclient+" est connecté!");
                InputStream inStream = socket.getInputStream();
                byte[] b = new byte[4096];
                int command = inStream.read(b);
                String result = new String(b,0, command);
                System.out.println(result);
                OutputStream outStream = socket.getOutputStream();
                outStream.write("respond from server".getBytes());
                outStream.flush();
                nbrclient++;
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
