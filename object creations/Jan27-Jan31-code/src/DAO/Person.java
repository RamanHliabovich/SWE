package DAO;

public abstract class Person implements Cloneable{
	
	public Person(PersonType type, String name, String state, String zipCode)
	{
		this.type = type;
		this.name = name;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	protected abstract void construct();
	
	private String name = null;
	
	private String state = null;
	
	private String zipCode = null;
	
	private PersonType type = null;
	
	public Object getClone() {
		Object clone = null;
		
		try {
			clone = super.clone();
		}catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}
	
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
	
	public void displayInfo() {
		System.out.println("\n" + name + " " + state + " " + zipCode + " " + type.toString());
	}
}
