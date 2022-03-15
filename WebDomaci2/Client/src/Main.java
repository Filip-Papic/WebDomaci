import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static final int PORT = 9001;

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        java.util.Date date = new java.util.Date();

        try {
            socket = new Socket("localhost", PORT);
            String username = "";
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String input, a, b;
            Scanner scanner = new Scanner(System.in);

            ClientThread clientRun = new ClientThread(socket);
            Thread thread = new Thread(clientRun);
            thread.start();

            while (true) {
                if (username.length() < 1) {
                    System.out.println("Enter your username: ");
                    input = scanner.nextLine();
                    while (input.length() < 1) {
                        System.out.println("Username cant be blank");
                        input = scanner.nextLine();
                    }
                    username = input;
                    out.println(input);
                } else {
                    input = scanner.nextLine();
                    while (input.length() < 1) {
                        input = scanner.nextLine();
                    }
                    out.println(">" + input);
                }
            }
        } catch (Exception e) {
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

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/*
import java.io.*;
import java.net.Socket;
import java.util.*;

public class Main {

    public static final int PORT = 9001;
    public static List<String> msgs = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {

        BufferedReader in = null;
        BufferedReader stdIn = null;
        Socket socket = new Socket("127.0.0.1", PORT);;
        PrintWriter out = null;
        String msg, username, status, history, newUser, newUser2, newUser3, newUser4;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            stdIn = new BufferedReader(new InputStreamReader(System.in));

            ClientThread ct = new ClientThread(socket);
            Thread clientThread = new Thread(ct);
            clientThread.start();

            Scanner scanner = new Scanner(System.in);
            Scanner scannerServer = new Scanner(in);

            System.out.println("Enter your username: ");
            username = scanner.nextLine();

            out.println(username);

            while (true) {
                status = in.readLine();
                //System.out.println(status);
                if(status.startsWith("ERROR")) { //radi kad zakomentarisem poruke
                    System.out.println(status);
                    newUser = scanner.nextLine();
                    out.println(newUser);
                } else if(status.startsWith("NEW")) {
                    System.out.println(status);
                    continue;
                */
/*} else if(status.startsWith("HISTORY")) {
                    while(status != null) {
                        System.out.println(status);
                    }*//*

                */
/*} else if(status.startsWith("MESSAGE")) {
                    while ((status = in.readLine()) != null) {
                        out.println(status);
                        System.out.println(in.readLine());
                    }
                    System.out.println(status);*//*

                } else {
                    System.out.println("Enter message: ");
                    msg = stdIn.readLine();
                    while (msg != null) {
                        out.println(msg);
                        System.out.println(username + ": " + in.readLine());
                        msg = stdIn.readLine();
                    }
                }
            }
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

            if (socket != null) {
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
