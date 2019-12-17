package com.beerhouse.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.beerhouse.repository.BeerRepository;

@Entity
public class Beer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private String name, ingredients,alcoholContent,category;
	private float price;
	
	public Beer() {}
	
	public Beer(Long id, String name, String ingredients, String alcoholContent, String category, float price) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.alcoholContent = alcoholContent;
		this.category = category;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getAlcoholContent() {
		return alcoholContent;
	}

	public void setAlcoholContent(String alcoholContent) {
		this.alcoholContent = alcoholContent;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", name=" + name + ", ingredients=" + ingredients + ", alcoholContent="
				+ alcoholContent + ", category=" + category + ", price=" + price + "]";
	}
	
	
	public Beer atualizar(Long id, BeerRepository beerReposity) {
		Beer beer = beerReposity.getOne(id);
		beer.setName(this.name);
		beer.setIngredients(this.ingredients);
		beer.setAlcoholContent(this.alcoholContent);
		beer.setCategory(this.category);
		beer.setPrice(this.price);		
		
		return beer;
		
	}
	
	
}
