package com.web2.av3.repositories;

import com.web2.av3.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
