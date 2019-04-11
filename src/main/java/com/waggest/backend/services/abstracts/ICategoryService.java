package com.waggest.backend.services.abstracts;

import com.waggest.backend.models.Category;
import org.springframework.data.domain.Page;

public interface ICategoryService {

    Page<Category> findAll(int page);

    Category findById(Long id);

    Category create(Category category);

    Category update(Category category, Category updatedCategory);

    void delete(Category category);
}
