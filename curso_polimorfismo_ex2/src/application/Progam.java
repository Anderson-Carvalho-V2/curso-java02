package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Progam {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> products = new ArrayList<>();
		Product product;
		
		System.out.print("Digite a quantidade de produtos: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Dados do produto #" + i + ":");
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char p = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(p == 'u') {
				System.out.print("Manufacture date: ");
				Date manufactureDate = sdf.parse(sc.next());
				product = new UsedProduct(name, price, manufactureDate);
				products.add(product);
			}else if(p == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				product = new ImportedProduct(name, price, customsFee);
				products.add(product);
			}else {
				product = new Product(name, price);
				products.add(product);
			}
		}
		
		System.out.println("\nPRICE TAGS");
		for(Product p : products) {
			System.out.println(p.priceTag());
		}

		sc.close();
	}
}
