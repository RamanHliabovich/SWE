package display;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;

import DAO.FileIO;
import business_logic.Computation;

public class FileDisplay {

	static InputStream input = null;
   
	public static void main(String[] args) throws IOException 
	{
	try
	{
		// Get excel file into InputStream object
		input = FileDisplay.class.getResourceAsStream("zipCode_info.xlsx");
		//URL url = FileDisplay.class.getResourceAsStream("zipCode_info.xlsx");
		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//excelFile = new File(url.getPath());
	}catch(Exception e)
	{
		System.out.print(e);
	}
		
	// Run Singleton
	SingletonRead(input);
			
		//Computation file1 = new Computation("Jan27-Jan31-input-sample.txt");
		//for (String a : file1.printAllNameAndZipCode()) {
			//System.out.println(a);
		//}
	}
	public static void SingletonRead(InputStream input)
	{
		FileIO singleton = FileIO.getInstance();
		try {
			singleton.readFile(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
