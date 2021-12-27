/*
 * 	ASSIGNMENT #4
 * 	Team:
 *  Divleen Kaur Ahluwalia
 *  Victoria Castelli
 */


package comp348_a4;

public interface NamedObject {
	
	public default String getName() {
		return this.getClass().getSimpleName();
	}

}