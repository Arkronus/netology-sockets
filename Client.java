import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.*;

public class Client {

    public static void main(String[] args) {
        try {
            client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void client() throws IOException {
        String host = "netology.homework";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            String resp = in.readLine();
            System.out.println("Server: " + resp);
            out.println("Artem");
            resp = in.readLine();
            System.out.println("Server: " + resp);
            out.println("no");
            resp = in.readLine();
            System.out.println("Server: " + resp);
        }
    }
}
