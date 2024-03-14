package pl.niziolekp.app.cookingai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.niziolekp.app.cookingai.dto.ProductDTO;
import pl.niziolekp.app.cookingai.model.Product;
import pl.niziolekp.app.cookingai.repository.ProductRepository;
import pl.niziolekp.app.cookingai.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {



    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDTO product) {
        productService.save(product);
    }

}