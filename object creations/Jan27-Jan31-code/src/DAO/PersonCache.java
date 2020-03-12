package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import display.FileDisplay;

public class PersonCache {
	
	Map<String, String> stateMap = new HashMap<String, String>();
	
	Map<String, Person> personMap = new HashMap<String, Person>();

	public void LoadCache(List<Person> personList)
	{
		FileIO fileIO = FileIO.getInstance();
		// Read excel file return data in map
		Person newPerson = null;
		
		try
		{
			// Get excel file into InputStream object
			InputStream input = FileDisplay.class.getResourceAsStream("states_info.xlsx");
			
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sheet = wb.getSheetAt(0); //creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); //iterating over excel file
			int rowCount = 0;
			int colCount = 0;
			String stateName = null;
			String stateType = null;
			while(itr.hasNext())
			{
				colCount = 0;
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					
					if(colCount == 0)
					{
						stateName = cell.getStringCellValue();
					}
					else if(colCount == 1)
					{
						stateType = cell.getStringCellValue();
					}
					colCount++;
				}
				stateMap.put(stateName, stateType);
				rowCount++;
			}
			wb.close();
		}catch(Exception e)
		{
			System.out.print(e);
		}
		
		String stateColor;
		for(Person person : personList)
		{
			stateColor = stateMap.get(person.getState());
			if(stateColor.contains("RED"))
			{
				newPerson = new RedPerson(PersonType.RED, person.getName(), person.getState(), person.getZipCode());
				personMap.put(person.getName(), newPerson);
			}
			else if (stateColor.contains("BLUE"))
			{
				newPerson = new RedPerson(PersonType.BLUE, person.getName(), person.getState(), person.getZipCode());
				personMap.put(person.getName(), newPerson);
			}
		}
	}
	
	public Person getClonedPerson(String name)
	{
		Person cachedPerson = personMap.get(name);
		return (Person) cachedPerson.getClone();
	}
}
