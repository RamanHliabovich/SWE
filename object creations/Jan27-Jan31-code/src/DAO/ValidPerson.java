package DAO;

public class ValidPerson extends Person {

	ValidPerson(String name, String state, String zipCode)
	{
		super(PersonType.VALID, name, state, zipCode);
		construct();
	}
	
	@Override
	protected void construct() {
		//System.out.println("Building " + name + " as CORRECT person");
	}
}
