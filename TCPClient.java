import java.net.*;
import java.io.*;

public class TCPClient {
    
    public static void main(String[] args) throws IOException {
        
        //Creating a client socket for connecting with the server at port 883
        Socket clientSocket = new Socket("localhost", 883);
        System.out.println("Connected to server");
        
        //Creating input and output streams
        InputStream input = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();
        
        //Reading the input from the user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter two numbers to add (separate them using a comma):");
        String inputLine = reader.readLine();
        
        //Sending the recieved request from the user to the server
        String request = inputLine + "\n";
        output.write(request.getBytes());
        
        //Reading the response from the server
        BufferedReader serverReader = new BufferedReader(new InputStreamReader(input));
        String response = serverReader.readLine();
        System.out.println("Result of addition is : " + response);

        clientSocket.close();
    }
}