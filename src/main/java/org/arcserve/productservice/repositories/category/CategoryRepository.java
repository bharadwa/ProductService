package org.arcserve.productservice.repositories.category;

import org.arcserve.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Long> {

}
