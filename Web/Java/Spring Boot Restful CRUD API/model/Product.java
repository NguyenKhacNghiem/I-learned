package lab9lab10.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Setter @Getter @NoArgsConstructor
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int price;
	private String brand;
	private String color;
	
	public Product(String name, int price, String brand, String color) {
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.color = color;
	}
}
