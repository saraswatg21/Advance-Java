package nagarro.training.ecommerce.entities;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "tshirt")
public class Tshirt {
	@Override
	public String toString() {
		return "Tshirt [id=" + id + ", name=" + name + ", colour=" + colour + ", gender=" + gender + ", size=" + size
				+ ", price=" + price + ", rating=" + rating + ", available=" + available + "]";
	}

	public Tshirt() {
		this.id = "Nothing";
	}

	@Id
	private String id;

	private String name;

	private String colour;

	@Enumerated(EnumType.STRING)
	private GenderType gender;

	@Enumerated(EnumType.STRING)
	private SizeType size;

	private double price;

	private double rating;

	@Enumerated(EnumType.STRING)
	private AvailableType available;

	public Tshirt(String id, String name, String color, GenderType gender, SizeType size, double price, double rating,
			AvailableType available) {
		this.id = id;
		this.name = name;
		this.colour = color;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.available = available;
	}

	public AvailableType getAvailable() {
		return available;
	}

	public double getPrice() {
		return price;
	}

	public double getRating() {
		return rating;
	}

	public String getId() {
		return id;
	}

	public GenderType getGender() {
		return gender;
	}

	public SizeType getSize() {
		return size;
	}

	public String getColour() {
		return colour;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colour, gender, size);
	}

	public boolean equals(String color, String gender, String size) {
		return (this.getColour().equals(color) && this.getSize() == SizeType.valueOf(size)
				&& this.getGender() == GenderType.valueOf(gender));
	}
}
