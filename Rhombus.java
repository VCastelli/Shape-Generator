/*
 * 	ASSIGNMENT #4
 * 	Team:
 * 	Victoria Castelli 
 *	Divleen Kaur Ahluwalia 
 * 	
 */

package comp348_a4;

public class Rhombus extends PrintableObject implements Shape{
	private double p;
	private double q;
	public Rhombus(double p, double q) {
		this.p=p;
		this.q=q;
	}
	
	public Double getPerimeter() {
		return 2* Math.sqrt((this.p* this.p) + (this.q*this.q));
	}
	
	
	public Double getArea() {
		return (this.p *this.q)/2;
	}
	
	public Double inRadius() {
		return (this.p * this.q) / (2* Math.sqrt((this.p*this.p) + (this.q*this.q)));
	}
	
	public static Rhombus parse(String str) {
		String[] newStr = str.split(",");
		double p = Double.parseDouble(newStr[1]);
		double q = Double.parseDouble(newStr[2]);
		
		return new Rhombus(p, q);
		
	}
	
	@Override
	public String toString() {
		return this.getName() + "," + this.p +"," + this.q;

	}

}