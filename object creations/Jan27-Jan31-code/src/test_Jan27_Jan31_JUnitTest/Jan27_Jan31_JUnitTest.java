package test_Jan27_Jan31_JUnitTest;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import DAO.FileIO;
import DAO.Person;
import DAO.PersonCache;
import DAO.PersonFactory;
import business_logic.Computation;
import display.FileDisplay;

class Jan27_Jan31_JUnitTest {
	@Test
	public void singletonTest() {
		FileIO f1 = FileIO.getInstance();
		FileIO f2 = FileIO.getInstance();
		assertEquals(f1, f2);
	}
	
	@Test
	public void factoryLM1BoundryTest() {
		try {
			Computation computation = new Computation();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person test1 = PersonFactory.buildPerson("Test Test", "AK", "99500"); // Low range - 1 test
		String string1 = test1.getName() + " " + test1.getState() + " " + test1.getZipCode() + " " + test1.getType().toString();
		System.out.println(string1);
		assertEquals(string1, "Test Test AK 99500 INVALID");
	}

	@Test
	public void factoryLEBoundryTest() {
		try {
			Computation computation = new Computation();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person test1 = PersonFactory.buildPerson("Test Test", "AK", "99501"); // Low range exact test
		String string1 = test1.getName() + " " + test1.getState() + " " + test1.getZipCode() + " " + test1.getType().toString();
		System.out.println(string1);
		assertEquals(string1, "Test Test AK 99501 VALID");
	}
	
	@Test
	public void factoryLP1BoundryTest() {
		try {
			Computation computation = new Computation();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person test1 = PersonFactory.buildPerson("Test Test", "AK", "99502"); // Low range + 1 test
		String string1 = test1.getName() + " " + test1.getState() + " " + test1.getZipCode() + " " + test1.getType().toString();
		System.out.println(string1);
		assertEquals(string1, "Test Test AK 99502 VALID");
	}
	
	@Test
	public void factoryINBoundryTest() {
		try {
			Computation computation = new Computation();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person test1 = PersonFactory.buildPerson("Test Test", "AK", "99750"); // Inbetween range test
		String string1 = test1.getName() + " " + test1.getState() + " " + test1.getZipCode() + " " + test1.getType().toString();
		System.out.println(string1);
		assertEquals(string1, "Test Test AK 99750 VALID");
	}
	
	@Test
	public void factoryHM1BoundryTest() {
		try {
			Computation computation = new Computation();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person test1 = PersonFactory.buildPerson("Test Test", "AK", "99949"); // High range - 1 test
		String string1 = test1.getName() + " " + test1.getState() + " " + test1.getZipCode() + " " + test1.getType().toString();
		System.out.println(string1);
		assertEquals(string1, "Test Test AK 99949 VALID");
	}
	
	@Test
	public void factoryHEBoundryTest() {
		try {
			Computation computation = new Computation();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person test1 = PersonFactory.buildPerson("Test Test", "AK", "99950"); // High range exact test
		String string1 = test1.getName() + " " + test1.getState() + " " + test1.getZipCode() + " " + test1.getType().toString();
		System.out.println(string1);
		assertEquals(string1, "Test Test AK 99950 VALID");
	}
	
	@Test
	public void factoryHP1BoundryTest() {
		try {
			Computation computation = new Computation();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person test1 = PersonFactory.buildPerson("Test Test", "AK", "99951"); // High range + 1 test
		String string1 = test1.getName() + " " + test1.getState() + " " + test1.getZipCode() + " " + test1.getType().toString();
		System.out.println(string1);
		assertEquals(string1, "Test Test AK 99951 INVALID");
	}
	
	@Test
	public void prototypeBlueTypeTest() {
		try {
			Computation computation = new Computation();
			PersonCache cache = new PersonCache();
			List<Person> personList = computation.ReadFileAndBuildPeople();
			cache.LoadCache(personList);
			Person test1 = PersonCache.getClonedPerson("Rachel Sanders");
			String string1 = test1.getName() + " " + test1.getState() + " " + test1.getZipCode() + " " + test1.getType().toString();
			System.out.println(string1);
			assertEquals(string1, "Rachel Sanders CA 95122 BLUE");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void prototypeRedTypeTest() {
		try {
			Computation computation = new Computation();
			PersonCache cache = new PersonCache();
			List<Person> personList = computation.ReadFileAndBuildPeople();
			cache.LoadCache(personList);
			Person test1 = PersonCache.getClonedPerson("Marilyn Bell");
			String string1 = test1.getName() + " " + test1.getState() + " " + test1.getZipCode() + " " + test1.getType().toString();
			System.out.println(string1);
			assertEquals(string1, "Marilyn Bell ID 83703 RED");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}