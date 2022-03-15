import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerThread extends Thread {

    public static List<String> userList = Collections.synchronizedList(new ArrayList<>());
    public static List<String> history = Collections.synchronizedList(new ArrayList<>(100));

    private Socket socket;
    private ArrayList<ServerThread> clientList;
    private BufferedReader in;
    private PrintWriter out;
    private String forbidden = "bad";
    private String a = "";
    private String b;
    private String username;
    private char c;
    private char[] arr;
    private String[] splited;

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
                System.out.println(fromClient);
                if (fromClient.startsWith(">")) {
                    fromClient = fromClient.substring(1);
                    System.out.println(fromClient);
                    if(fromClient.contains("bad")) {
                        b = "";
                        splited = fromClient.split("\\s+");
                        for (String s : splited) {
                            if(s.contains("bad")) {
                                arr = s.toCharArray();
                                for (int i = 1; i < arr.length - 1; i++) {
                                    arr[i] = '*';
                                }
                                s = String.valueOf(arr);
                            }
                            b += s + " ";
                        }
                        fromClient = b;
                    }
                    System.out.println("history: " + fromClient);
                    history.add(username + ": " + fromClient);
                    System.out.println("Current history: " + history);
                    for (ServerThread st : clientList) {
                        st.out.println(java.time.LocalDateTime.now() + " - " + username + ": " + fromClient );
                    }
                } else {
                    while (userList.contains(fromClient)) {
                        out.println("ERROR- Username already exists. Please enter new username: ");
                        fromClient = in.readLine();
                        if (fromClient.startsWith(">")) {
                            fromClient = fromClient.substring(1);
                        }
                    }
                    username = fromClient;
                    userList.add(fromClient);
                    System.out.println("Current users: " + userList);
                    for (ServerThread st : clientList) {
                        st.out.println(fromClient + " joined the server");
                    }
                    out.println("Welcome to public chat room!");
                    if(history.size() > 100){
                        history.remove(0);
                    }
                    for (String i : history) {
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