import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8010);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Input principal, rate of interest, and number of years
            System.out.print("Enter principal amount: ");
            double principal = Double.parseDouble(userInput.readLine());
            System.out.print("Enter rate of interest: ");
            double rate = Double.parseDouble(userInput.readLine());
            System.out.print("Enter number of years: ");
            int years = Integer.parseInt(userInput.readLine());

            // Send principal, rate of interest, and number of years to server
            out.println(principal);
            out.println(rate);
            out.println(years);

            // Receive and display result from server
            String result = in.readLine();
            System.out.println("Result received from server: " + result);

            in.close();
            out.close();
            userInput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
