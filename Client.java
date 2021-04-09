import java.io.*;
import java.net.*;
public class Client{
        public static void main(String[] args){
            try{
                BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
                Socket s = new Socket("localhost",9999);
                DataOutputStream dout = new DataOutputStream (s.getOutputStream());
                String str="", msg =kbd.readLine();
                DataInputStream din = new DataInputStream(s.getInputStream());
                dout.writeUTF(msg);
                dout.flush();//clear the message
                while(!msg.equals("stop")){
                    dout.writeUTF(msg);
                    dout.flush();//clear the message
                    str = (String) din.readUTF();
                    System.out.println("Message from Server: "+str); 
                    msg=kbd.readLine();   
                }
                dout.close();
                s.close();                    
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}