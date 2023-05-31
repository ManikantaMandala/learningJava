package org.telsukoMacbookContest.ProductDemoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProductDemoSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductDemoSpringApplication.class, args);

		ProductService service = context.getBean(ProductService.class);

//		service.addProduct(new Product("Type C", "Cable", "Black Drawer", 2024));
//		service.addProduct(new Product("Mac Studio", "Computer", "White Table", 2025));
//		service.addProduct(new Product("Focusrite Mixer", "Audio System", "White Table", 2025));
//		service.addProduct(new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021));
//		service.addProduct(new Product("Asus Rog", "Laptop", "Black Table", 2021));
//		service.addProduct(new Product("Macbook pro", "Laptop", "Brown Drawer", 2022));
//		service.addProduct(new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020));
//		service.addProduct(new Product("Apple Keyboard", "Keyboard", "White Table", 2022));
//		service.addProduct(new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024));
//		service.addProduct(new Product("Hdmi cable", "Cable", "Black Drawer", 2024));
//		service.addProduct(new Product("Java Black Book", "Cable", "Shelf", 2024));
//		service.addProduct(new Product("Logi Mouse", "Mouse", "Black Table", 2022));
//		service.addProduct(new Product("Apple Mouse", "Mouse", "White Table", 2022));
//		service.addProduct(new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022));
//		service.addProduct(new Product("BlackBeast", "Computer", "White Table", 2020));

		System.out.println("==============================================");
		System.out.println("Get All products");
		service.getAllProducts().forEach(System.out::println);

		System.out.println("==============================================");
		System.out.println("a Particular product");
		service.getProduct("Logi Mouse").forEach(System.out::println);

		System.out.println("==============================================");
		System.out.println("Search by a text");
		service.getProductWithText("Black").forEach(System.out::println);

		System.out.println("==============================================");
		System.out.println("Search by place");
		service.searchByPlace("BLack Table").forEach(System.out::println);

		System.out.println("==============================================");
		System.out.println("Search by products which are out of warranty");
		service.searchOutOfWarranty().forEach(System.out::println);

	}

}
