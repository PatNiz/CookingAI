package pl.niziolekp.app.cookingai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.niziolekp.app.cookingai.dto.ProductDTO;
import pl.niziolekp.app.cookingai.model.Product;
import pl.niziolekp.app.cookingai.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> new ProductDTO(product.getName()))
                .collect(Collectors.toList());
    }

    public void save(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.name());
        productRepository.save(product);
    }
}
