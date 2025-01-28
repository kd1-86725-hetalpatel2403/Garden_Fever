package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProductDto;
import com.app.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/create/{catId}")
	@ResponseBody
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product, @PathVariable int catId) {
		ProductDto createProduct = productService.createProduct(product, catId);
		return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
	}
	
	@RequestMapping("/viewAll")
	public ResponseEntity<List<ProductDto>> viewAllProduct() {
		List<ProductDto> viewAll = productService.viewAll();
		return new ResponseEntity<List<ProductDto>>(viewAll, HttpStatus.ACCEPTED);
	}

	// view productById
	@GetMapping("view/{productId}")
	public ResponseEntity<ProductDto> viewProductById(@PathVariable int productId) {
		ProductDto viewProductById = productService.viewProductById(productId);
		return new ResponseEntity<ProductDto>(viewProductById, HttpStatus.OK);
	}

	// delete productById
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}

	// updateProductById
	@PutMapping("/update/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable int productId,
			@RequestBody ProductDto updatedProduct) {
		ProductDto updated = productService.updateProduct(productId, updatedProduct);
		return new ResponseEntity<ProductDto>(updated, HttpStatus.ACCEPTED);
	}

	// find product by category

//	@GetMapping("/category/{catId}")
//	public ResponseEntity<List<ProductDTO>> getProductByCategory(@PathVariable int catId, int ResponseEntity) {
//		List<ProductDTO> findProductByCategory = this.productService.findProductByCategory(catId);
//		return new ResponseEntity<List<ProductDTO>>(findProductByCategory, HttpStatus.ACCEPTED);
//	}

	@GetMapping("/products/category/{catId}")
	public ResponseEntity<List<ProductDto>> getProductByCategory(@PathVariable Integer catId) {
		if (catId == null) {
			// Handle the case when catId is not provided
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		List<ProductDto> findProductByCategory = this.productService.findProductByCategory(catId);
		return new ResponseEntity<>(findProductByCategory, HttpStatus.OK);
	}

}
