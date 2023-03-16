import java.net.*;
import java.io.*;

public class TCPServer {
    
    public static void main(String[] args) throws IOException {
        
        //Creating a server socket
        ServerSocket welcomeSocket = new ServerSocket(883);
        System.out.println("Server is listening on port 883");
        
        while (true) {
            //Creating a connectionSocket for the client to connect
            Socket ConnectionSocket = welcomeSocket.accept();
            System.out.println("New client connected");
            
            //Creating input and output streams
            InputStream input = ConnectionSocket.getInputStream();
            OutputStream output = ConnectionSocket.getOutputStream();
            
            //Reading the input from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String inputLine = reader.readLine();
            
            //Parsing the input and calculate the result
            String[] inputs = inputLine.split(",");
            int num1 = Integer.parseInt(inputs[0].trim());
            int num2 = Integer.parseInt(inputs[1].trim());
            int result = num1 + num2;
            
            //Sending the result back to the client
            String outputLine = String.valueOf(result);
            output.write(outputLine.getBytes());
            
            ConnectionSocket.close();
            welcomeSocket.close();
        }
    }
}