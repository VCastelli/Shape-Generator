/*
 * 	ASSIGNMENT #4
 * 	Team:
 *	Victoria Castelli
 *	Divleen Kaur Ahluwalia
 */


package comp348_a4;

import java.util.List;

public interface Printable {

	public void print();
	public static void print(List<Printable> printables) {
		for (Printable printableObject: printables) {
			printableObject.print();
		}
	}
}