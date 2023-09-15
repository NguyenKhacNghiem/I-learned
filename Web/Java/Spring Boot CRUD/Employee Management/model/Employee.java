package lab8.model;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@NoArgsConstructor @Setter @Getter
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	private String phone;
	
	public Employee(long id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
}