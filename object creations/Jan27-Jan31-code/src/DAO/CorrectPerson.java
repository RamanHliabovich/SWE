package DAO;

public class CorrectPerson extends Person {

	CorrectPerson(String name, String state, String zipCode)
	{
		super(PersonType.CORRECT, name, state, zipCode);
		construct(name);
	}
	
	@Override
	protected void construct(String name) {
		System.out.println("Building " + name + " as CORRECT person");
	}
}
