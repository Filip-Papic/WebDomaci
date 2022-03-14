import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int PORT = 9001;
    //public static List<ServerThread> clientList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ArrayList<ServerThread> clientList = new ArrayList<>();
        ServerSocket serversocket = new ServerSocket(PORT);

        try {
            while(true) {
                Socket socket = serversocket.accept();
                ServerThread serverThread = new ServerThread(socket, clientList);
                clientList.add(serverThread);
                serverThread.start();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}

/*
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Main {

    public static final int PORT = 9001;
    public static List<ServerThread> clientList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(Main.PORT);
            ServerThread st = null;
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("NEW CONNECTION");

                st = new ServerThread(socket);
                clientList.add(st);
                Thread serverThread = new Thread(st);
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
