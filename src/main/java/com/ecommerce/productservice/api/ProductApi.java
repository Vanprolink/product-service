package com.ecommerce.productservice.api;

import com.ecommerce.productservice.dto.ProductDto;
import com.ecommerce.productservice.dto.ProductResponse;
import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @PostMapping("/create-product")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return "Product created successfully";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        // Giả sử lấy từ DB, ở đây mình new cứng để test kết nối trước
        ProductResponse product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/reduce-quantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable Long id, @RequestParam Integer quantity) {
        productService.reduceStock(id, quantity);
        return ResponseEntity.ok().build();
    }
}
