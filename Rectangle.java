/*
 * 	ASSIGNMENT #4
 * 	Team:
 *	Divleen Kaur Ahluwalia
 * 	Victoria Castelli
 */


package comp348_a4;

public class Rectangle extends PrintableObject implements Shape {
	
	private double length;
	private double breadth;
	
	public Rectangle() {
		this.length=0;
		this.breadth=0;
	}
	
	public Rectangle(double length, double breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}

	public double getLength() {
		return length;
	}
	
	public double getBreadth() {
		return breadth;
	}
	
	public void setLength(double length) {
		this.length = length;
	}

	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}
	
	@Override
	public String toString() {
		return this.getName() + "," + getLength()+"," +getBreadth();

	}
	
	public static Rectangle parse(String str) {
		String[] newStr = str.split(",");
		double newLength = Double.parseDouble(newStr[1]);
		double newBreadth= Double.parseDouble(newStr[2]);
		
		return new Rectangle(newLength, newBreadth);
		
	}
	
	public Double getPerimeter() {
		double perimeter = 2*(this.length + this.breadth);
		return perimeter;
	}
	
	public Double getArea() {
		double area= this.length * this.breadth;
		return area;
	}
	
	


}