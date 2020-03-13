package DAO;

public abstract class Person implements Cloneable{
	// Instantiation of variables for a person's information
	private String name = null;
	
	private String state = null;
	
	private String zipCode = null;
	
	private PersonType type = null;
	
	// Setter for people and their information
	public Person(PersonType type, String name, String state, String zipCode) {
		this.type = type;
		this.name = name;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	//
	protected abstract void construct();
	
	// 
	public Object getClone() {
		Object clone = null;
		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
	
	// Getters for people and their information
	public PersonType getType() {
		return type;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public String getName() {
		return name;
	}
	
	// Display function for people and their information
	public void displayInfo() {
		System.out.println("\n" + name + " " + state + " " + zipCode + " " + type.toString());
	}
}