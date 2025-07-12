package ru.rad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rad.dto.ResponseProductDto;
import ru.rad.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/user/{userId}")
    public List<ResponseProductDto> getProductsByUser(@PathVariable Long userId) {
        List<ResponseProductDto> responseProductDto = productService.getProductsByUserId(userId);
        return responseProductDto;
    }

    @GetMapping("/product/{productId}")
    public ResponseProductDto getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }
}