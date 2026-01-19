package com.ecommerce.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder // Thêm cái này để sau này new object cho dễ (Optional)
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String skuCode;
    private BigDecimal price;
    private Integer stockQuantity; // Trường quan trọng để Order Service check kho
}
