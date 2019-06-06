// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package Server;

import java.io.*;

import Information.*;
import Tools.*;
import User.*;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
    super(port);
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
    System.out.println("Message received: " + msg + " from " + client);
    this.sendToAllClients(msg);
  }
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args) 
  {
    int port = 8888; //Port to listen on
	Board brd = null;
	UserListData ud = null;
	
	
    
    EchoServer sv = new EchoServer(port);
    //read the Data from File, and set to server.
    try {
		brd = board_load();
	} catch (ClassNotFoundException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    try {
		ud = list_load();
	} catch (ClassNotFoundException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    
    //System.out.println(brd.getNoticeList().get(0).getTitle());
    //System.out.println(ud.getUlist().get(3).getName());

    sv.setBrd(brd);
    sv.setUd(ud);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
    	ex.printStackTrace();
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
  
  public static Board board_load() throws FileNotFoundException, IOException, ClassNotFoundException
  {
	Board brd = null;
  	ObjectInputStream oos = null;
  	try {
  		oos = new  ObjectInputStream(new FileInputStream("Board.dat"));
  		brd = (Board) oos.readObject();
  		oos.close();
  	}
  	catch(FileNotFoundException e) {
  		System.out.println("ERROR - File not found_Board.dat");
  	}
  	
  	return brd;
  }
  
  public static UserListData list_load() throws FileNotFoundException, IOException, ClassNotFoundException
  {
	UserListData ud = null;
  	ObjectInputStream oos = null;
  	try {
  		oos = new  ObjectInputStream(new FileInputStream("Accounts.dat"));
  		ud = (UserListData) oos.readObject();
  		oos.close();
  	}
  	catch(FileNotFoundException e) {
  		System.out.println("ERROR - File not found_Account.dat");
  	}
  	
  	return ud;
  }
}

//End of EchoServer class













