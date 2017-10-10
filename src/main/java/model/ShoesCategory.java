package model;

import java.util.Set;
import javax.persistence.*;

@Entity
public class ShoesCategory {
	private int id;
	private String name;
	private Set<Shoes> shoes;
	
	public ShoesCategory() {
		
	}
	public ShoesCategory(String name) {
		super();
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy ="shoesCategory", cascade = CascadeType.ALL)
	public Set<Shoes> getShoes() {
		return shoes;
	}
	public void setShoes(Set<Shoes> shoes) {
		this.shoes = shoes;
	}
	@Override
	public String toString() {
		String result = String.format("Category[id=%d, name='%s']%n", id, name);
		if (shoes != null) {
			for(Shoes shoes : this.shoes) {
				result += String.format("Shoes[id=%d, name='%s']%n", shoes.getId(), shoes.getName());
			}
		}
		return result;
	}
	
	

}
