package DAO;

public class InvalidPerson extends Person {

	InvalidPerson(String name, String state, String zipCode)
	{
		super(PersonType.INVALID, name, state, zipCode);
		construct();
	}
	
	@Override
	protected void construct() {
		//System.out.println("Building " + name + " as INCORRECT person");
	}
}
