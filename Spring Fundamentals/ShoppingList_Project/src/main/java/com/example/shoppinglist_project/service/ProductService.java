package com.example.shoppinglist_project.service;

import com.example.shoppinglist_project.model.Category;
import com.example.shoppinglist_project.model.Product;
import com.example.shoppinglist_project.model.dto.ProductDTO;
import com.example.shoppinglist_project.model.enums.CategoryNameEnum;
import com.example.shoppinglist_project.model.view.ProductViewModel;
import com.example.shoppinglist_project.repository.CategoryRepository;
import com.example.shoppinglist_project.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProductService(CategoryRepository categoryRepository,
                          ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public boolean addProduct(ProductDTO productDTO) {

        CategoryNameEnum type = switch (productDTO.getCategory()) {
            case "FOOD" -> CategoryNameEnum.FOOD;
            case "DRINK" -> CategoryNameEnum.DRINK;
            case "HOUSEHOLD" -> CategoryNameEnum.HOUSEHOLD;
            case "OTHER" -> CategoryNameEnum.OTHER;
            default -> CategoryNameEnum.OTHER;
        };

        Category category = this.categoryRepository.findByName(type);

        Product product = new Product();

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setNeededBefore(productDTO.getNeededBefore());
        product.setCategory(category);

        this.productRepository.save(product);

        return true;
    }

    public BigDecimal getTotalSum() {
        return productRepository.findTotalProductsSum();
    }

    public List<ProductViewModel> findAllProductsByCategoryName(CategoryNameEnum categoryNameEnum) {
        return productRepository.
                findAllByCategory_Name(categoryNameEnum)
                .stream().map(product -> {
                    ProductViewModel productViewModel = new ProductViewModel();
                    productViewModel.setId(product.getId());
                    productViewModel.setName(product.getName());
                    productViewModel.setPrice(product.getPrice());

                    return productViewModel;
                }).collect(Collectors.toList());
    }

    public void buyById(Long id) {
        productRepository.deleteById(id);
    }

    public void buyAll() {
        productRepository.deleteAll();
    }
}
