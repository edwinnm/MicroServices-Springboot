package com.example.product;

import com.example.product.entity.Category;
import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;
    @Test
    public void whenFindByCategory_thenReturnListProducts (){
        Product product01 = Product.builder()
                .name("computer")
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1000"))
                .status("Created")
                .createAt(new Date()).build();
        productRepository.save(product01);

        List<Product> founds = productRepository.findByCategory(product01.getCategory());
        Assertions.assertThat( founds.size()).isEqualTo(3);
    }
}
