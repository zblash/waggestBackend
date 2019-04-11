package com.waggest.backend.services.concretes;

import com.waggest.backend.models.Category;
import com.waggest.backend.repositories.CategoryRepository;
import com.waggest.backend.services.abstracts.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(int page) {
        return categoryRepository.findAll(PageRequest.of(page,10));
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category, Category updatedCategory) {
        category.setName(updatedCategory.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
