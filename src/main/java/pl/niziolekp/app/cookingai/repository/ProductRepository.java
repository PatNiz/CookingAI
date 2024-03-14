package pl.niziolekp.app.cookingai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niziolekp.app.cookingai.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}