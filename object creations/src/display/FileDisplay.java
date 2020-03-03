package display;

import java.io.IOException;
import DAO.FileIO;
import business_logic.Computation;

public class FileDisplay {

	public static void main(String[] args) throws IOException {
		
		FileIO fileIO = new FileIO();
		fileIO.getPrint200("zipCode_info.xlsx");
		Computation file1 = new Computation("zipCode_info.xlsx");
		for (String a : file1.printAllNameAndZipCode()) {
			System.out.println(a);
		}
	}
}
