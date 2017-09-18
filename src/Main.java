import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 * Created by stagiaire on 14/09/2017.
 */
public class Main {

    public static void main(String[] args){
        ServerSocket socket;
        try{
            socket = new ServerSocket(2009, 2000, InetAddress.getByName("172.16.100.12"));
            Thread t = new Thread(new AcceptClient(socket));
            t.start();
            System.out.println("Mes employeurs sont prêts !");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
