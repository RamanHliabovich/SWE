package test_Jan27_Jan31_JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import DAO.Person;
import DAO.PersonFactory;
import business_logic.Computation;

class Jan27_Jan31_JUnitTest {

	@Test
	public void factoryTestBoundryTest() {
		try {
			Computation computation = new Computation();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person test = PersonFactory.buildPerson("Test Test", "AK", "99501");
		String string = test.getName() + " " + test.getState() + " " + test.getZipCode() + " " + test.getType().toString();
		System.out.println(string);
		assertEquals(string, "Test Test AK 99501 VALID");
		
		Person test2 = PersonFactory.buildPerson("Test Test", "AK", "99950");
		String string2 = test2.getName() + " " + test2.getState() + " " + test2.getZipCode() + " " + test2.getType().toString();
		System.out.println(string2);
		assertEquals(string2, "Test Test AK 99950 INVALID");
		
		Person test3 = PersonFactory.buildPerson("Test Test", "AK", "99750");
		String string3 = test3.getName() + " " + test3.getState() + " " + test3.getZipCode() + " " + test3.getType().toString();
		System.out.println(string3);
		assertEquals(string3, "Test Test AK 99750 VALID");
		
		Person test4 = PersonFactory.buildPerson("Test Test", "AK", "99500");
		String string4 = test4.getName() + " " + test4.getState() + " " + test4.getZipCode() + " " + test4.getType().toString();
		System.out.println(string4);
		assertEquals(string4, "Test Test AK 99500 INVALID");
		
		Person test5 = PersonFactory.buildPerson("Test Test", "AK", "99951");
		String string5 = test5.getName() + " " + test5.getState() + " " + test5.getZipCode() + " " + test5.getType().toString();
		System.out.println(string5);
		assertEquals(string5, "Test Test AK 99951 IVALID");
		
		Person test6 = PersonFactory.buildPerson("Test Test", "AK", "99502");
		String string6 = test6.getName() + " " + test6.getState() + " " + test6.getZipCode() + " " + test6.getType().toString();
		System.out.println(string6);
		assertEquals(string6, "Test Test AK 99502 VALID");
		
		Person test7 = PersonFactory.buildPerson("Test Test", "AK", "99949");
		String string7 = test7.getName() + " " + test7.getState() + " " + test7.getZipCode() + " " + test7.getType().toString();
		System.out.println(string7);
		assertEquals(string7, "Test Test AK 99949 VALID");
		
	}

}
