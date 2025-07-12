package ru.rad.service;

import org.springframework.stereotype.Service;
import ru.rad.dto.ResponseProductDto;
import ru.rad.dto.ResponseUserDto;
import ru.rad.entity.Products;
import ru.rad.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ResponseProductDto> getProductsByUserId(Long userId) {
        List<ResponseProductDto> responseList = new ArrayList<>();
        List<Products> productList = productRepository.findProductsByUserId(userId);
        productList.forEach(p -> responseList.add(new ResponseProductDto(
                p.getAccount(),
                p.getBalance(),
                p.getProductType(),
                new ResponseUserDto(p.getUser().getUserName()))));

        return responseList;
    }

    public ResponseProductDto getProductById(Long productId) {
        Products product = productRepository.getReferenceById(productId);
        return new ResponseProductDto(
                product.getAccount(),
                product.getBalance(),
                product.getProductType(),
                new ResponseUserDto(product.getUser().getUserName())
        );

    }
}
