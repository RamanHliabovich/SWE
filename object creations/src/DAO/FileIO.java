package DAO;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileIO {

	private static Map<String, String> map = new HashMap<String, String>();

//Task2 : Solution-A ( line16-line 24)
	private static FileIO instance = new FileIO();

	public FileIO() {

	}

	public static FileIO getInstance() {
		return instance;
	}

//Task2 : Solution-B (line 27-line36)
//	private static FileIO instance;
//
//	private FileIO() {
//	}
//	public static FileIO getInstance() {
//		if(instance==null) {
//			instance=new FileIO();
//		}
//		return instance;
//	}
	
	//XSSFSheet sheet = wb.getSheetAt(0);
	
	public void getPrint200(String f) throws IOException {
		readFile2(f);
	}
	
	@SuppressWarnings("deprecation")
	public static void readFile2(String file) throws IOException {
		try {
			File f1 = new File("zipCode_info.xlsx");
			FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t\t\t");
						break;
					}
				}
			System.out.println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	// read .txt file, read data and save data in map
//	private static void readFile(String file) throws IOException {
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
//	}
//
//	// return map information
//	public Map<String, String> getMap(String file) throws IOException {
//		readFile(file);
//		return map;
//	}
}
