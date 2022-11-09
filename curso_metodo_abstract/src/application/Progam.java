package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Circle;
import entities.Color;
import entities.Rectangle;
import entities.Shape;

public class Progam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Shape> shapes = new ArrayList<>();
		
		System.out.print("Digite o número de formas: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Shape #" + i + " data:");
			System.out.print("Rectangle or Circle (r/c)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.next().toUpperCase());
			if(resp == 'r') {
				System.out.print("Width: ");
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double heigth = sc.nextDouble();
				shapes.add(new Rectangle(color , width, heigth));
			}else {
				System.out.print("Radius: ");
				double radius = sc.nextDouble();
				shapes.add(new Circle(color, radius));
			}		
		}
		
		System.out.println("\nSHAPE AREAS");
		for(Shape sp : shapes) {
			System.out.println(String.format("%.2f", sp.area()));
		}
		
	sc.close();
	}
}
