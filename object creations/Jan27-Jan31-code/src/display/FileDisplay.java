package display;
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;


import DAO.FileIO;
import DAO.Person;
import DAO.PersonCache;

import business_logic.Computation;

public class FileDisplay {
	//
	public static void main(String[] args) throws IOException  {	
		System.out.println("RUNNING SINGLETON PART 1... \n");
		// Run Singleton 
		SingletonRead();
		
		System.out.println("\n\nRUNNING FACTORY METHOD PART 2... \n");
		// Run Factory that reads text file and builds person objects and prints results
		FactoryRead();
		
		System.out.println("\n\nRUNNING PROTOTYPE METHOD PART 3... \n");
		RunPrototype();

		// Computation code that was here before
		//Computation file1 = new Computation("Jan27-Jan31-input-sample.txt");
		//for (String a : file1.printAllNameAndZipCode()) {
		//	System.out.println(a);
		//}
	}
	
	//
	public static void SingletonRead() {
		try {
			// this initiates FileIO and stores excel file in map
			FileIO singleton = FileIO.getInstance();
			// Use this to output results of storing excel file
			singleton.outputExcelFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 1. Read text file in
	// 2. Find name, state, and zip code for each person
	// 3. Call PersonFactory and build new person with these paramaters
	// 4. Output results and test with own text info
	private static void FactoryRead() {
		try {
			Computation computation = new Computation();
			List<Person> personList = computation.ReadFileAndBuildPeople();
			for(Person person : personList) {
				person.displayInfo();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	//
	private static void RunPrototype()
	{
		try {
			// Initiate computation and retrieve the person list to clone and get political demographic
			Computation computation = new Computation();
			List<Person> personList = computation.ReadFileAndBuildPeople();
			List<Person> newPersonList = new ArrayList<Person>();
			PersonCache personCache = new PersonCache();
			personCache.LoadCache(personList);
			Person clonedPerson = null;
			for(Person person : personList) {
				clonedPerson = personCache.getClonedPerson(person.getName());
				clonedPerson.displayInfo();
				newPersonList.add(clonedPerson);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Ignore this it was just to test code for the factory
	//public static void CreateNewPerson(String name, String state, String zipCode)
	//{
	//	Person person = null;
	//	String zipCodeRange = (String)zipCodeMap.get(state);
	//	String zipCodeMin = zipCodeRange.substring(0,4);
	//	String zipCodeMax = zipCodeRange.substring(6,10);
	//	int zipCodeMinInt = Integer.parseInt(zipCodeMin);
	//	int zipCodeMaxInt = Integer.parseInt(zipCodeMax);
	//	int zipCodeInt = Integer.parseInt(zipCode);
	//	if(zipCodeInt > zipCodeMinInt && zipCodeInt < zipCodeMaxInt) {
	//		person = new CorrectPerson(name, state, zipCode);
	//	}
	//	else  {
	//		person = new IncorrectPerson(name, state, zipCode);
	//	}
	//}
}