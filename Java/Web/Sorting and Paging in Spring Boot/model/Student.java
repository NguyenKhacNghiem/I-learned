package lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor @Setter @Getter @ToString
public class Student {
	@Id
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private double ielts;
	
	public Student(int id, String name, int age, String email, double ielts) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.ielts = ielts;
	}
}
