import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8010);
            System.out.println("Server started. Waiting for client connections...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Receive principal, rate of interest, and number of years from client
            double principal = Double.parseDouble(in.readLine());
            double rate = Double.parseDouble(in.readLine());
            int years = Integer.parseInt(in.readLine());

            // Calculate simple interest
            double interest = (principal * rate * years) / 100;

            // Send result to client
            out.println("Simple Interest: " + interest);

            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
