import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread implements Runnable {

    public static boolean flag = false;
    //private boolean flag = false;
    private Socket socket;
    private BufferedReader in, in2;
    private PrintWriter out;
    private String newUser;

    public boolean isFlag() {
        return flag;
    }

    public ClientThread(Socket s){
        this.socket = s;
        try {
            this.in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            this.in2 = new BufferedReader(new InputStreamReader(System.in));
            this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while(true) {
                String response = in.readLine();/*
                if (response.startsWith("ERROR")) {
                    flag = true;
                }*/
                System.out.println(response);

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