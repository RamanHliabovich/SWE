package test_Jan27_Jan31_JUnitTest;

import DAO.FileIO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import DAO.FileIO;

class Jan27_Jan31_JUnitTest {

	@Test
	void singletonTest() {
		FileIO f1 = FileIO.getInstance();
		FileIO f2 = FileIO.getInstance();
		assertEquals(f1, f2);
	}
}
