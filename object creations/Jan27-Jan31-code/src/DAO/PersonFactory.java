package DAO;

import java.io.IOException;
import java.util.Map;

public class PersonFactory {
	private static Map<String, String> zipCodeMap = null;
	public static Person buildPerson(String name, String state, String zipCode) 
	{
		try {
			zipCodeMap = FileIO.getMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person person = null;
		String zipCodeRange = (String)zipCodeMap.get(state);
		String zipCodeMin = zipCodeRange.substring(0,5);
		String zipCodeMax = zipCodeRange.substring(6,11);
		int zipCodeMinInt = Integer.parseInt(zipCodeMin);
		int zipCodeMaxInt = Integer.parseInt(zipCodeMax);
		int zipCodeInt = Integer.parseInt(zipCode);
		if(zipCodeInt > zipCodeMinInt && zipCodeInt < zipCodeMaxInt)
		{
			person = new CorrectPerson(name, state, zipCode);
		}
		else 
		{
			person = new IncorrectPerson(name, state, zipCode);
		}
		return person;
	}
}
