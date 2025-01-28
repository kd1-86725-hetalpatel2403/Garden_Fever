package com.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;
	private int quantity;
	private double totalprice;
	
	//Relationship with other table
	
	@ManyToOne
	private Cart cart;
	
	@OneToOne
	private Product product;
	
}
