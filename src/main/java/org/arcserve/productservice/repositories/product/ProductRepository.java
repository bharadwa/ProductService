package org.arcserve.productservice.repositories.product;

import org.arcserve.productservice.models.product.Product;
import org.arcserve.productservice.repositories.projections.ProductWithTitleAndPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findDistinctByPrice(Double price);

    @Override
    Optional<Product> findById(Long id);

    @Override
    List<Product> findAll();

    Product  save(Product entity);

    @Override
    void deleteById(Long id);

    @Override
    void delete(Product product);

    List<Product> findByCreatedAtAfter(String timestamp);

    List<Product> findTop5ByTitle(String title);


    @Query("select p.title as title, p.price as price from products p where p.id = :id")
    ProductWithTitleAndPrice getTitleAndPriceById(@Param("id") Long id);

    @Override
    Page<Product> findAll(Pageable pageable);
}
