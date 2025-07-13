package org.arcserve.productservice.repositories.category;

import org.arcserve.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository  extends JpaRepository<Category,Long> {

    Optional<Category> findByValue(String value);

    Category save(Category entity);

}
