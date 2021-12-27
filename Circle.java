/*
 * 	ASSIGNMENT #4
 * 	Team:
 *	Victoria Castelli
 *	Divleen Kaur Ahluwalia
 */


package comp348_a4;

public class Circle extends PrintableObject implements Shape {

	private double radius;
	
	public Circle() {
		this.radius = 0;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getName() {
		return this.getClass().getSimpleName().toUpperCase();
	}
	
	@Override
	public String toString() {
		return this.getName() + "," + getRadius();

	}
	
	public static Circle parse(String str) {
		String[] newStr = str.split(",");
		double newRadius = Double.parseDouble(newStr[1]);
		return new Circle(newRadius);
		
	}
	
	public Double getPerimeter() {
		double perimeter = 2* this.radius * Math.PI;
		return perimeter;
	}
	
	public Double getArea() {
		double area= Math.PI * this.radius * this.radius;
		return area;
	}
	
}