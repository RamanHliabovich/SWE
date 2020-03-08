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

//Task2 : Solution-B (line 27-line36)
	private static FileIO instance = null;

	private FileIO() {
	}
	public static FileIO getInstance() {
		if(instance==null) {
			instance=new FileIO();
		}
		return instance;
	}

	// read .txt file, read data and save data in map
	public static void readFile(InputStream fis) throws IOException {
		try
		{
			//File f1 = new File(file); //creating a new file instance
			//FileInputStream fis = new FileInputStream(f1); //obtaining bytes from the file
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
						System.out.print(cell.getNumericCellValue() + "\t\t\t");
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
