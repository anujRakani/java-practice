package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class StreamAverage {
	public static void main(String[] args) {
		List<Product> productList = new ArrayList<>();

		productList.add(new Product("Red",15.00));
		productList.add(new Product("Yellow",20.00));
		productList.add(new Product("Green",22.00));
		productList.add(new Product("Red",15.00));
		productList.add(new Product("Black",40.00));
		productList.add(new Product("Red",30.00));
		productList.add(new Product("Yellow",10.00));

		String filterColor = "red";

		OptionalDouble od = productList.stream().filter(p -> p.color.equalsIgnoreCase(filterColor)).
				mapToDouble(p -> p.price).average();

		if (od.isPresent()) {
			System.out.println("The avg is " + od.getAsDouble());
		} else {
			System.out.println("The stream was empty");
		}
	}
}

class Product {
	public String color;
	public double price;

	Product() {
		this("White", 10.0);
	}

	Product(String color, double price) {
		this.color = color;
		this.price = price;
	}
}