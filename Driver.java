/*
 * 	ASSIGNMENT #4
 * 	Team:
 *	Divleen Kaur Ahluwalia
 * 	Victoria Castelli
 */

package comp348_a4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

public class Driver {

	public static void main(String[] args) {
		
		ArrayList<Shape> figures = new ArrayList<>();
		
		Scanner sc= null;
		String s;
		try {
			sc=new Scanner(new FileInputStream("File.txt"));
			while(sc.hasNext()) {
				s=sc.next();
				if(s.split(",")[0].toLowerCase().equals("circle")) {
					figures.add(Circle.parse(s));
				}
				else if (s.split(",")[0].toLowerCase().equals("rectangle")) {
					figures.add(Rectangle.parse(s));
				}
				else {
					System.out.println("Invalid Shape. Terminating Program.");
					System.exit(0);
				}
			}
			
/*
 * 	An anonymous comparator class is created to override and use the compare method on the shapes.
 * 	The compare method compares the objects on the basis of area name and area as shown below.
 */
			Comparator<Shape> comparator = new Comparator<Shape>() {
				@Override
				public int compare(Shape shape1, Shape shape2) {
					if(shape1.getName().compareTo(shape2.getName()) == 0) {
						return shape1.getArea().compareTo(shape2.getArea());
					}
					return shape1.getName().compareTo(shape2.getName());
				}
				
			};
			
			Collections.sort(figures, comparator);
			List<Printable> printableObjects= new ArrayList<>();
			for(Shape shape: figures) {
				printableObjects.add((PrintableObject) shape);
			}
			
			Printable.print(printableObjects);
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found exception.");
		}
	
		String fileName = "/Users/victoriacastelli/Desktop/File.txt";
	
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
	
			stream.forEach(line -> {
				if (line.startsWith("Rectangle")) {
					figures.add(Rectangle.parse(line));
				}
				if (line.startsWith("Circle")) {
					figures.add(Circle.parse(line));
				}
				if (line.startsWith("Rhombus")) {
					figures.add(Rhombus.parse(line));
				}
				
			});
			
			//sorts and displays the shapes by shape name and area;
			System.out.println("Sorted by shape name and area:");
			figures.stream().sorted(Comparator.comparingDouble(Shape::getArea)).sorted(Comparator.comparing(Shape::getName)).collect(Collectors.toList()).forEach(System.out::println);;
			
			System.out.println("\n");
			//sorts and displays the shapes by perimeter only;
			System.out.println("Sorted by shape perimeter:");
			figures.stream().sorted(Comparator.comparingDouble(Shape::getPerimeter)).collect(Collectors.toList()).forEach(System.out::println);;
			
			System.out.println("\n");
			//displays a summary information of averages per shapes;
			System.out.println("Summary information of averages per shapes:\n");
			
			System.out.println("Averages for Circle: ");
			
			double avgPerim = figures.stream().filter(circle -> circle instanceof Circle).mapToDouble(c -> c.getPerimeter()).average().getAsDouble();
			System.out.println("Average perimeter: " + avgPerim);
			
			double avgArea = figures.stream().filter(circle -> circle instanceof Circle).mapToDouble(c -> c.getArea()).average().getAsDouble();
			System.out.println("Average Area: " + avgArea);
			
			
			
			System.out.println("\nAverages for Rectangle: ");
			
			double avgP = figures.stream().filter(rect -> rect instanceof Rectangle).mapToDouble(r -> r.getPerimeter()).average().getAsDouble();
			System.out.println("Average perimeter: " + avgP);
			
			double avgA = figures.stream().filter(rect -> rect instanceof Rectangle).mapToDouble(r -> r.getArea()).average().getAsDouble();
			System.out.println("Average Area: " + avgA);
			
			
			
			System.out.println("\nAverages for Rhombus: ");
			
			double avgPRh = figures.stream().filter(rhom -> rhom instanceof Rhombus).mapToDouble(rh -> rh.getPerimeter()).average().getAsDouble();
			System.out.println("Average perimeter: " + avgPRh);
			
			double avgARh = figures.stream().filter(rhom -> rhom instanceof Rhombus).mapToDouble(rh -> rh.getArea()).average().getAsDouble();
			System.out.println("Average Area: " + avgARh);
			
			
			//displays the average perimeter, average area, and the total number of shapes at the end.
			System.out.println("\n");
			System.out.println("\nAverages for all shapes: ");
			
			double avgPerimeter = figures.stream().mapToDouble(s -> s.getPerimeter()).average().getAsDouble();
			System.out.println("Average Perimeter: " + avgPerimeter);
			
			double avgAreas = figures.stream().mapToDouble(s -> s.getArea()).average().getAsDouble();
			System.out.println("Average Perimeter: " + avgAreas);
			
			System.out.println("\nTotal Number of shapes: " + (figures.stream().count()));
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	
	
	
	}
}