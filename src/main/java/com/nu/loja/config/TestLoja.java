package com.nu.loja.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nu.loja.entities.Category;
import com.nu.loja.entities.Order;
import com.nu.loja.entities.OrderItem;
import com.nu.loja.entities.Product;
import com.nu.loja.entities.User;
import com.nu.loja.entities.enums.OrderStatus;
import com.nu.loja.repositories.CategoryRepository;
import com.nu.loja.repositories.OrderItemRepository;
import com.nu.loja.repositories.OrderRepository;
import com.nu.loja.repositories.ProductRepository;
import com.nu.loja.repositories.UserRepository;
@Configuration
@Profile("test")
public class TestLoja implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired 
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	
		
		
		
		Category ct = new Category(null, "Electronics");
		Category ct2 = new Category(null, "Computer");
		Category ct3 = new Category(null, "Books");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		
		categoryRepository.saveAll(Arrays.asList(ct,ct2,ct3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(ct3);
		
		p2.getCategories().add(ct);
		p2.getCategories().add(ct2);

		p3.getCategories().add(ct2);
		p4.getCategories().add(ct2);
		
		p5.getCategories().add(ct3);
		p5.getCategories().add(ct2);
		
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Bob","Brown", "bob@bob.com", "999999999","233");
		User u2 = new User(null, "Mark", "Brown", "mark@bob.com", "999991999","233");
		
		Order o1 = new Order(null, Instant.parse("2010-12-22T19:43:22Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2011-12-22T19:43:22Z"), OrderStatus.SHIPPED,u2);
		Order o3 = new Order(null, Instant.parse("2010-11-22T19:43:22Z"),OrderStatus.SHIPPED, u1);
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		
		OrderItem oi1= new OrderItem(o1,p1,2,p1.getPrice());
		OrderItem oi2= new OrderItem(o1,p3,1,p3.getPrice());
		OrderItem oi3= new OrderItem(o2,p3,2,p3.getPrice());
		OrderItem oi4= new OrderItem(o3,p5,2,p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		o1.getItems().add(oi1);
		o1.getItems().add(oi2);
		o2.getItems().add(oi3);
		o3.getItems().add(oi4);
	
	
	}
	
}
