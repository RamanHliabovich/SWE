package business_logic;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import DAO.FileIO;
import DAO.Person;
import DAO.PersonFactory;
import display.FileDisplay;

public class Computation {
	//
	public int counter = 0;
	
	//
	private Map<String, String> zipCodeMap;

	//
	public Computation() throws IOException {
		FileIO f = FileIO.getInstance();
		zipCodeMap = f.getMap();
	}
	
	//
	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
	
	//
	public List<Person> ReadFileAndBuildPeople() {
		List<Person> personList = new ArrayList<Person>();
        String strLine = "";
        try {
        	 URL url = FileDisplay.class.getResource("input_sample2.txt");
        	 String path = url.getPath();
        	 String newPath = path.replace("%20", " ");
             BufferedReader br = new BufferedReader(new FileReader(newPath));
             String name = null;
             String[] address = null; // use this to get just zip code and state of address then split them
             String state = null;
             String zipCode = null;
             boolean nameFlag = false;
             boolean addressFlag = false;
             while (strLine != null) { 
                if(strLine.contains("name")) {
                	name = strLine.replace("name: ", "");
                	nameFlag = true;
                }
                else if(strLine.contains("address")) {
                	address = strLine.split(",");
                	// Adjust for different amount of commas in these name addresses
                	if(name.contains("Carlos Thompson") || name.contains("Christopher Turner")) {
                		state = address[3].substring(1,3);
                    	zipCode = address[4].substring(1,address[4].length());
                	}
                	else if(name.contains("Tammy Simmons") || name.contains("Gregory White")) {
                		state = address[1].substring(1,3);
                    	zipCode = address[2].substring(1,address[2].length());
                	}
                	else {
                    	state = address[2].substring(1,3);
                    	zipCode = address[3].substring(1,address[3].length());	
                	}
                	nameFlag = true;
                	addressFlag = true;
                }
                if(nameFlag == true && addressFlag == true) {
                	// Build new person once name, state, and zipcode are found
                	personList.add(PersonFactory.buildPerson(name, state, zipCode));
                	name = null;
                	state = null;
                	zipCode = null;
                	nameFlag = false;
                	addressFlag = false;
                }
                strLine = br.readLine();
             }             
             br.close();
        } catch (FileNotFoundException e) {
            //System.err.println("File not found");
        } catch (IOException e) {
            //System.err.println("Unable to read the file.");
        }        
        return personList;
	}
}