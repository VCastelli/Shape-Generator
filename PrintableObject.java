/*
 * 	ASSIGNMENT #4
 * 	Team:
 *	Victoria Castelli
 *	Divleen Kaur Ahluwalia 
 */


package comp348_a4;

public abstract class PrintableObject implements NamedObject, Printable{
	
	public String toString() {
		return("The name of the object is "+ getName());
	}
	
	public void print() {
		System.out.println(toString());
	}

}