package DAO;

public class IncorrectPerson extends Person {

	IncorrectPerson(String name, String state, String zipCode)
	{
		super(PersonType.INCORRECT, name, state, zipCode);
		construct(name);
	}
	
	@Override
	protected void construct(String name) {
		//System.out.println("Building " + name + " as INCORRECT person");
	}
}
