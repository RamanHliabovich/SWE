package DAO;

public class CorrectPerson extends Person {

	CorrectPerson()
	{
		super(PersonType.CORRECT);
		construct();
	}
	
	@Override
	protected void construct() {
		System.out.println("Building CORRECT person");
	}
}
