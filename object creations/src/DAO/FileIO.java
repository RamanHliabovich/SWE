package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import display.FileDisplay;

public class FileIO {
	// Singleton instance being created
	private static FileIO instance = null;
	
	// Enables singleton
	public static FileIO getInstance() {
		if(instance==null) {
			instance=new FileIO();
		}
		return instance;
	}
	
	// Hash map construction for zip codes
	private static Map<String, String> zipCodeMap = new HashMap<String, String>();

	// Constructor that calls function to store excel file in map
	private FileIO() {
		try {
			zipCodeMap = storeExcelFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Read excel file return data in map
	@SuppressWarnings("deprecation")
	public Map<String,String> storeExcelFile() throws IOException {
		Map<String,String> map = new HashMap<String,String>();
		int rowCount = 0;
		int colCount = 0;	
		try {
			// Get excel file into InputStream object
			InputStream input = FileDisplay.class.getResourceAsStream("zipCode_info.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sheet = wb.getSheetAt(0); // Creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); // Iterating over excel file
			while(itr.hasNext()) {
				rowCount++;
				colCount = 0;
				String state = null;
				String zipCodeStart = null;
				String zipCodeEnd = null;
				String zipCode = null;
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					colCount++;
					Cell cell = cellIterator.next();				
					if(rowCount > 1) {
						if(colCount > 2) {
							switch(cell.getCellType()) {
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
				}
				if(state != null && zipCodeStart != null && zipCodeEnd != null) {
					zipCode = zipCodeStart + " " + zipCodeEnd; 
					map.put(state, zipCode);	
				}
			}
			wb.close();
		} catch(Exception e) {
			System.out.print(e);
		}
		return map;
	}
	
	// Use this to output excel file to console after it's read
	@SuppressWarnings("deprecation")
	public void outputExcelFile() throws IOException {
		try {
			// Get excel file into InputStream object
			InputStream input = FileDisplay.class.getResourceAsStream("zipCode_info.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sheet = wb.getSheetAt(0); // Creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); // Iterating over excel file
			while(itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch(cell.getCellType())	{
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
			wb.close();
		} catch(Exception e) {
			System.out.print(e);
		}
	}

	// Return map information
	public static Map<String, String> getMap() throws IOException {
		return zipCodeMap;
	}
}