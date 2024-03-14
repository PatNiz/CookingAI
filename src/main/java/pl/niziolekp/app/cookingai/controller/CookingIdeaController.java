package pl.niziolekp.app.cookingai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.niziolekp.app.cookingai.dto.ProductDTO;
import pl.niziolekp.app.cookingai.service.CookingIdeaService;
import pl.niziolekp.app.cookingai.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ideas")
public class CookingIdeaController {
    private final CookingIdeaService cookingIdeaService;
    private final ProductService productService;

    public CookingIdeaController(CookingIdeaService cookingIdeaService, ProductService productService) {
        this.cookingIdeaService = cookingIdeaService;
        this.productService = productService;
    }

    @GetMapping("/breakfast")
    public String getBreakfastIdeas() {
        return cookingIdeaService.getBreakfastIdeas(productService.getAllProducts().stream().map(ProductDTO::name).collect(Collectors.toList()));
    }
}
