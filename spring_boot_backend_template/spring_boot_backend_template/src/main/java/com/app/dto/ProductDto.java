package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {
	private int product_id;
    private String product_name;
    private double product_price;
    private String product_imageName;
    private int product_quantity;
    private boolean stock = true;
    private boolean live;
    private String product_description;
    
    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }
    
    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
    
    private CategoryDto category;
    
    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
