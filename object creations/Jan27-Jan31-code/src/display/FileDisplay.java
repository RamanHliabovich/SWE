package display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.FileIO;
import DAO.Person;
import DAO.PersonFactory;
import business_logic.Computation;

public class FileDisplay {
	
	public static void main(String[] args) throws IOException 
	{	
		System.out.println("RUNNING SINGLETON PART 1... \n");
		// Run Singleton 
		//SingletonRead();
		
		System.out.println("\nRUNNING FACTORY METHOD PART 2... \n");
		// Run Factory that reads text file and builds person objects and prints results
		FactoryRead();
				
		// Computation code that was here before
		//Computation file1 = new Computation("Jan27-Jan31-input-sample.txt");
		//for (String a : file1.printAllNameAndZipCode()) {
			//System.out.println(a);
		//}
	}

	public static void SingletonRead()
	{
		FileIO singleton = FileIO.getInstance();
		try {
			singleton.storeExcelFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 1. read text file in
	// 2. find name, state, and zip code for each person
	// 3. Call PersonFactory and build new person with these paramaters
	// 4. output results and test with own text info	
	private static void FactoryRead()
	{
		FileIO singleton = FileIO.getInstance();
		List<Person> personList = singleton.ReadFileAndBuildPeople();
    }
	
	//public static void CreateNewPerson(String name, String state, String zipCode)
	//{
	//	Person person = null;
	//	String zipCodeRange = (String)zipCodeMap.get(state);
	//	String zipCodeMin = zipCodeRange.substring(0,4);
	//	String zipCodeMax = zipCodeRange.substring(6,10);
	//	int zipCodeMinInt = Integer.parseInt(zipCodeMin);
	//	int zipCodeMaxInt = Integer.parseInt(zipCodeMax);
	//	int zipCodeInt = Integer.parseInt(zipCode);
	//	if(zipCodeInt > zipCodeMinInt && zipCodeInt < zipCodeMaxInt)
	//	{
	//		person = new CorrectPerson(name, state, zipCode);
	//	}
	//	else 
	//	{
	//		person = new IncorrectPerson(name, state, zipCode);
	//	}
	//}
}
