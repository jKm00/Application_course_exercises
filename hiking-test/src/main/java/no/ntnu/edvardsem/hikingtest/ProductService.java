package no.ntnu.edvardsem.hikingtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts() {
        List<Product> products = new LinkedList<>();
        this.repository.findAll().forEach(products::add);
        return products;
    }
}
