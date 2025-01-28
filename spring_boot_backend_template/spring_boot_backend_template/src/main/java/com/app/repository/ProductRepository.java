package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Category;
import com.app.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	 @Query("SELECT p FROM Product p")
	    List<Product> getAllProducts();
		
		List<Product> findByCategory(Category category);
}
