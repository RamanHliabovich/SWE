package DAO;

public class IncorrectPerson extends Person {

	IncorrectPerson()
	{
		super(PersonType.INCORRECT);
		construct();
	}
	
	@Override
	protected void construct() {
		System.out.println("Building INCORRECT person");
	}
}
