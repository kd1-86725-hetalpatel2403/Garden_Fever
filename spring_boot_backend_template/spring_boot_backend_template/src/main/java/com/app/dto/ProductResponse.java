package com.app.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductResponse {
	private List<ProductDto> content;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private boolean lastPage;
    
    public ProductResponse(List<ProductDto> content, int pageNumber, int pageSize, int totalPages, boolean lastPage) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.lastPage = lastPage;
    }
    
    public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
}
