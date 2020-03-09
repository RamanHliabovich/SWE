package DAO;

public abstract class Person {
	
	public Person(PersonType type, String name, String state, String zipCode)
	{
		this.type = type;
		this.name = name;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	protected abstract void construct(String name);
	
	private String name = null;
	
	private String state = null;
	
	private String zipCode = null;
	
	private PersonType type = null;
	
	public PersonType getType() {
		return type;
	}
	
	public void displayInfo() {
		System.out.println("\n" + name + " " + state + " " + zipCode + " " + type.toString());
	}
}
