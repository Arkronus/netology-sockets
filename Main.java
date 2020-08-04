import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        server();
    }

    private static void server() throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Starting server");
        Socket clientSocket = serverSocket.accept();
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connection accepted");
            out.println("Write your name");
            final String name = in.readLine();
            out.println("Are you child?");
            final String isChild = in.readLine();
            if (isChild.equals("yes")){
                out.printf("Welcome to the kids area, %s! Let's play!%n", name);
            } else {
                out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name);
            }
//            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
        }
    }
}
