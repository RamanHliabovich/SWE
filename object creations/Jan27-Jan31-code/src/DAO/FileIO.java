package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileIO {

	private static Map<String, String> map = new HashMap<String, String>();

	private static FileIO instance = null;

	// Constructor
	private FileIO() {
		
	}
	
	// Enables singleton
	public static FileIO getInstance() {
		if(instance==null) {
			instance=new FileIO();
		}
		return instance;
	}

	// Read excel file return data in map
	public static Map<String,String> storeExcelFile(InputStream fis) throws IOException {
		Map<String,String> map = new HashMap<String,String>();
		int rowCount = 0;
		int colCount = 0;	
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); //creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); //iterating over excel file
			while(itr.hasNext())
			{
				rowCount++;
				colCount = 0;
				String state = null;
				String zipCodeStart = null;
				String zipCodeEnd = null;
				String zipCode = null;
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext())
				{
					colCount++;
					Cell cell = cellIterator.next();				
					if(rowCount > 1)
					{
						if(colCount > 2)
						{
							switch(cell.getCellType())
							{
							case Cell.CELL_TYPE_STRING:
								if(colCount == 3)
									state = cell.getStringCellValue();
								else if(colCount == 4)
									zipCodeStart = cell.getStringCellValue();
								else if(colCount == 5)
									zipCodeEnd = cell.getStringCellValue();
								break;
							case Cell.CELL_TYPE_NUMERIC:
								Double doubleValue = cell.getNumericCellValue();
								int intValue = doubleValue.intValue();
								if(colCount == 4)
									zipCodeStart = Integer.toString(intValue);
								else if(colCount == 5)
									zipCodeEnd = Integer.toString(intValue);
								break;	
							}	
						}
					}
					if(state != null && zipCodeStart != null && zipCodeEnd != null)
					{
						zipCode = zipCodeStart + " " + zipCodeEnd; 
						map.put(state, zipCode);	
					}
				}
			}
		}catch(Exception e)
		{
			System.out.print(e);
		}
		return map;
	}
	
	
	// Use this to output excel file to console after it's read
	public static void outputExcelFile(InputStream fis) throws IOException {
		try
		{
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); //creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); //iterating over excel file
			while(itr.hasNext())
			{
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					switch(cell.getCellType())
					{
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						Double value = cell.getNumericCellValue();
						System.out.print(value.intValue() + "\t\t\t");
						break;
					}
				}
				System.out.println("");
			}
		}catch(Exception e)
		{
			System.out.print(e);
		}
		
		// Read excel file from geeks4geeks
		
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		String st;
//		List<String> tempList = new ArrayList<String>();
//		while ((st = br.readLine()) != null) {
//			tempList.add(st.trim().toString());
//		}
//		for (int i = 0; i < tempList.size(); i++) {
//			if (tempList.get(i).toString().contains("name:")) {
//				map.put(tempList.get(i).trim().substring(6).toString(), tempList.get(i + 1).substring(9).toString());
//			}
//		}
//		br.close();
	}

	// return map information
	public Map<String, String> getMap(String file) throws IOException {
		//readFile(file);
		return map;
	}
}
