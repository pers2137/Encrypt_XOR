/*
 * Author: Pers2137.
 * Version: 1.0
 */
package Main;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;


/**
 *
 * @author pers
 */
public class Encrypt_XOR {

   
    public static void main(String[] args) {
       
       
        
   
        //cheking arguments list
        if(args.length != 2) 
        {
            System.out.println("Wrong arguments.");
            System.out.println("java -jar Encrypt_XOR path_file password");
            System.exit(0);
            
        }
        
        File file = new File(args[0]);
        
        //checking if the file exists
        if(!file.exists() || file.isDirectory())
        {
             System.out.println("This file doesnt exist or is directory.");
             
             System.exit(0);
        }
                
                
        ArrayList<Integer> tablica = new ArrayList<>();
        int ch,xorCh;
        int index = 0;
        
              
        //READ FILE + ENCODING.
        try(FileInputStream buf = new FileInputStream(file))
        {
           while( (ch = buf.read()) != -1 )
           {    
               if(index >= args[1].length()) index = 0;
               
               xorCh = ch^args[1].charAt(index);             
               tablica.add(xorCh);
               index++;
               
           }
           
        }
        catch(Exception e)
        {
            System.out.println("Error. " + e.toString());
            System.exit(0);
        }
        
       
        
        //WRITE ENCODING FILE.
        try(FileOutputStream wr = new FileOutputStream(file);)
        { 
            for(int i=0;i<tablica.size();i++)
                  wr.write(tablica.get(i)); 
        }
        catch(Exception e)
        {
            System.out.println("Error. " + e.toString());
            System.exit(0);
        }
        
        
        //WELL DONE :)
        System.out.println("File encrypting succesful.");
            
    }
    
}
