package Client;

import java.io.*;
import UI.*;

public class ClientConsole
{
  //Class variables *************************************************
  
  /**
   * The default port to connect on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Instance variables **********************************************
  
  /**
   * The instance of the client that created this ConsoleChat.
   */
  static ChatClient client;

  
  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  public ClientConsole(String host, int port) 
  {
    try 
    {
      client= new ChatClient(host, port);
    } 
    catch(IOException exception) 
    {
    	exception.printStackTrace();
      System.out.println("Error: Can't setup connection!"
                + " Terminating client.");
      System.exit(1);
    }
  }

  
  //Instance methods ************************************************
  
  /**
   * This method waits for input from the console.  Once it is 
   * received, it sends it to the client's message handler.
   */
  public void accept() 
  {
    try
    {
      BufferedReader fromConsole = 
        new BufferedReader(new InputStreamReader(System.in));
      String message;

      while (true) 
      {
        message = fromConsole.readLine();
        client.handleMessageFromClientUI(message);
      }
    } 
    catch (Exception ex) 
    {
      System.out.println
        ("Unexpected error while reading from console!");
    }
  }



  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of the Client UI.
   *
   * @param args[0] The host to connect to.
   */
  public static void main(String[] args) 
  {
    String host = "";
    int port = 8888;  //The port number

    try
    {
      host = args[0];
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      host = "127.0.0.1";
    }
    ClientConsole chat = new ClientConsole("127.0.0.1", 8888);
    UI_login login = new UI_login(client);
    login.setVisible(true);
    System.out.println("console created");
    //chat.accept();  //Wait for console data
  }
}
//End of ConsoleChat class
