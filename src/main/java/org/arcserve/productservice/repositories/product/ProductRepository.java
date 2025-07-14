package org.arcserve.productservice.repositories.product;

import org.arcserve.productservice.models.product.Product;
import org.arcserve.productservice.models.product.projections.ProductGetTitleAndDescription;
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


    @Query("select p.title,p.description from products p where p.id = :id")
    ProductGetTitleAndDescription findTitleAndDescriptionById(@Param("id") Long id);

}
