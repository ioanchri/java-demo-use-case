package com.example.demo.services;

import com.example.demo.model.OrderProduct;
import com.example.demo.model.Orders;
import com.example.demo.model.Product;
import com.example.demo.model.dtos.OrderDTO;
import com.example.demo.model.dtos.ProductDTO;
import com.example.demo.repository.OrderProductRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderProductRepository OrderProductRepository;

    public Product createNewProduct(ProductDTO product) {
        log.info("Creating new Order");

        Optional<OrderProduct> orderProduct = OrderProductRepository.findById(product.getOrderProductId());

        if (orderProduct.isEmpty()) {
            return null;
        }

        Product productToSave = new Product(orderProduct.get(), product.getCode(), product.getName(),product.getPrice(),product.getQuantity());

        return productRepository.save(productToSave);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}