package model;

import javax.persistence.*;

@Entity
public class Shoes {
	
	

	private int id;
	private String name;
	private ShoesCategory shoescategory;

	public Shoes() {
		
	}
	
	public Shoes(String name) {
		this.name = name;
	}

	public Shoes(String name, ShoesCategory shoescategory) {
		this.name = name;
		this.shoescategory = shoescategory;
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

	@ManyToOne
	@JoinColumn(name = "shoes_category_id")
	public ShoesCategory getShoescategory() {
		return shoescategory;
	}

	public void setShoescategory(ShoesCategory shoescategory) {
		this.shoescategory = shoescategory;
	}
	
	
	

}