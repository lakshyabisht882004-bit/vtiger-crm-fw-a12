package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class datadriven {
	 public static void main (String[]args) throws IOException {
		 //get the java representation object of the physucal file
		 FileInputStream fis = new  FileInputStream("./src/test/resources/demo.properties");
		 //use the load method of propeeties class 
           Properties pobj = new Properties();
           pobj.load(fis);
		 // use get property method and pass the keys and you will gethe value 
      System.out.println( pobj.getProperty("url"));
      System.out.println ( pobj.getProperty("bro"));
      System.out.println  ( pobj.getProperty("un"));
      System.out.println   (pobj.getProperty("pwd"));
           
	 }

}
