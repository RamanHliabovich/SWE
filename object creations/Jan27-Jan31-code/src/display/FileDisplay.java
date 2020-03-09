package display;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import DAO.FileIO;
import business_logic.Computation;

public class FileDisplay {

	static InputStream input = null;
	
	static Map<String,String> zipCodeMap = new HashMap<String,String>();
   
	public static void main(String[] args) throws IOException 
	{
		try
		{
			// Get excel file into InputStream object
			input = FileDisplay.class.getResourceAsStream("zipCode_info.xlsx");
			
			// Use these if we need to get excel file path or file object
			//URL url = FileDisplay.class.getResourceAsStream("zipCode_info.xlsx");
			//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			//excelFile = new File(url.getPath());
		} catch (Exception e) {
			System.out.print(e);
		}
		
		System.out.println("RUNNING SINGLETON PART 1... \n");
		// Run Singleton 
		SingletonRead(input);
		
		System.out.println("\nRUNNING FACTORY METHOD PART 2... \n");
		// Run Factory Method
		FactoryRead();
				
		// Computation code that was here before
		//Computation file1 = new Computation("Jan27-Jan31-input-sample.txt");
		//for (String a : file1.printAllNameAndZipCode()) {
			//System.out.println(a);
		//}
	}

	public static void SingletonRead(InputStream input)
	{
		FileIO singleton = FileIO.getInstance();
		zipCodeMap = new HashMap<String,String>();
		try {
			zipCodeMap = singleton.storeExcelFile(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void FactoryRead()
	{
		// 1. read text file in
		// 2. iterate through each person and call PersonFactory
		//	  when the type is found (incorrect/correct)
		// 3. output results and test with own text info
	}	
}
