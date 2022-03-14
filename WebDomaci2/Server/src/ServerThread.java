import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerThread extends Thread {

    public static List<String> userList = Collections.synchronizedList(new ArrayList<>());
    public static List<String> history = Collections.synchronizedList(new ArrayList<>());
    private Socket socket;
    private ArrayList<ServerThread> clientList;
    BufferedReader in;
    private PrintWriter out;

    public ServerThread(Socket socket, ArrayList<ServerThread> clientList) {
        this.socket = socket;
        this.clientList = clientList;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);

            while(true) {
                String fromClient = in.readLine();

                if (fromClient.startsWith(">")) {
                    history.add(fromClient);
                    System.out.println("Current history: " + history);
                    for (ServerThread st : clientList) {
                        st.out.println(fromClient);
                    }
                } else {
                    while (userList.contains(fromClient)) {
                        out.println("ERROR- Username already exists. Please enter new username: ");
                        fromClient = in.readLine();
                    }
                    userList.add(fromClient);
                    System.out.println("Current users: " + userList);
                    for (ServerThread st : clientList) {
                        st.out.println(fromClient + " joined the server");
                    }
                    for(String i : history) {
                        out.println(i);
                    }
                }
                System.out.println("Server received new client");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;

public class ServerThread implements Runnable {

    public static List<String> history = Collections.synchronizedList(new ArrayList<>());
    public static List<String> userList = Collections.synchronizedList(new ArrayList<>());
    public static PrintWriter out;
    public static String username;
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    */
/*private PrintWriter out;

    public PrintWriter getOut() {
        return out;
    }*//*


    @Override
    public void run() {
        BufferedReader in = null;
        //PrintWriter out = null;
        String msg, fullMsg, input;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            username = in.readLine();
            if (username == null) {
                return;
            }

            while(userList.contains(username)) {
                out.println("ERROR: Username already exists - '" + username + "'. Please enter new username: ");
                username = in.readLine();
            }
            out.println("Welcome:" + username);
            userList.add(username);

            while (true) {
                    msg = in.readLine();
                    while(msg != null) {
                        System.out.println(username + ": " + msg);
                        history.add(msg);
                        for(ServerThread st: Main.clientList) {
                            st.out.println(msg);
                        }
                        msg = in.readLine();
                }
            }

        } catch (SocketException s){
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
            }
            if (this.socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
*/
