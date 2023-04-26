package az.developia.computershopping.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
public class BasketComputer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Override
	public String toString() {
		return "BasketComputer{" +
				"id=" + id +
				", order=" + order +
				'}';
	}
}