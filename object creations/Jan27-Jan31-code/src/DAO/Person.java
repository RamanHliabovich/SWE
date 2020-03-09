package DAO;

public abstract class Person {
	
	public Person(PersonType type)
	{
		this.type = type;
	}
	
	protected abstract void construct();
	
	private PersonType type = null;
	
	public PersonType getType() {
		return type;
	}
}
