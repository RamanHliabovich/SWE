package test_Jan27_Jan31_JUnitTest;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import DAO.FileIO;
import DAO.Person;
import DAO.PersonFactory;
import business_logic.Computation;

class Jan27_Jan31_JUnitTest {
	@Test
	public void singletonTest() {
		FileIO f1 = FileIO.getInstance();
		FileIO f2 = FileIO.getInstance();
		assertEquals(f1, f2);
	}
	
	@Test
	public void factoryBoundryTest() {
		try {
			Computation computation = new Computation();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person test1 = PersonFactory.buildPerson("Test Test", "AK", "99500"); //Low range -1 test
		String string1 = test1.getName() + " " + test1.getState() + " " + test1.getZipCode() + " " + test1.getType().toString();
		System.out.println(string1);
		assertEquals(string1, "Test Test AK 99500 INVALID");
		
		Person test2 = PersonFactory.buildPerson("Test Test", "AK", "99501"); //Exact low range test
		String string2 = test2.getName() + " " + test2.getState() + " " + test2.getZipCode() + " " + test2.getType().toString();
		System.out.println(string2);
		assertEquals(string2, "Test Test AK 99501 VALID");
		
		Person test3 = PersonFactory.buildPerson("Test Test", "AK", "99502"); //Low range +1 test
		String string3 = test3.getName() + " " + test3.getState() + " " + test3.getZipCode() + " " + test3.getType().toString();
		System.out.println(string3);
		assertEquals(string3, "Test Test AK 99502 VALID");
		
		Person test4 = PersonFactory.buildPerson("Test Test", "AK", "99750"); //Mid range test
		String string4 = test4.getName() + " " + test4.getState() + " " + test4.getZipCode() + " " + test4.getType().toString();
		System.out.println(string4);
		assertEquals(string4, "Test Test AK 99750 VALID");
		
		Person test5 = PersonFactory.buildPerson("Test Test", "AK", "99949"); //High range -1 test
		String string5 = test5.getName() + " " + test5.getState() + " " + test5.getZipCode() + " " + test5.getType().toString();
		System.out.println(string5);
		assertEquals(string5, "Test Test AK 99949 VALID");
		
		Person test6 = PersonFactory.buildPerson("Test Test", "AK", "99950"); //Exact high range test
		String string6 = test6.getName() + " " + test6.getState() + " " + test6.getZipCode() + " " + test6.getType().toString();
		System.out.println(string6);
		assertEquals(string6, "Test Test AK 99950 VALID");
		
		Person test7 = PersonFactory.buildPerson("Test Test", "AK", "99951"); //High range +1 test
		String string7 = test7.getName() + " " + test7.getState() + " " + test7.getZipCode() + " " + test7.getType().toString();
		System.out.println(string7);
		assertEquals(string7, "Test Test AK 99951 INVALID");
	}
	
	@Test
	public void prototypeTest() {
	}
}