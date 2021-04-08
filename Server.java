import java.io.*;
import java.net.*;
import java.util.*;
public class Server{
    public static void main(String[] args){
        try{
            Scanner kbd = new Scanner(System.in);
            ServerSocket ss = new ServerSocket(9999);
            Socket s = ss.accept();
            DataOutputStream  dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            String str = (String) din.readUTF();

            //send message to client 
            while (!str.equals("stop")){
                
                System.out.println("Message from client: "+str);
                dout.writeUTF(kbd.nextLine());//sent message
                dout.flush();
                str = (String) din.readUTF();
            }
            ss.close();
            s.close();
            dout.close(); 
            din.close();
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}