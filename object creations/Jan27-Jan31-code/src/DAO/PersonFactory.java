package DAO;

public class PersonFactory {
	public static Person buildPerson(PersonType type) 
	{
		Person person = null;
		
		switch(type) {
		case CORRECT:
			person = new CorrectPerson();
			break;
		case INCORRECT:
			person = new IncorrectPerson();
			break;
		default:
			System.out.println("Invalid person type");
			break;
		}
		return person;
	}
}
