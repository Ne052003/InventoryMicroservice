package com.neoapps.driven_adapters.mappers;

import com.neoapps.driven_adapters.entities.CategoryEntity;
import com.neoapps.model.category.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toCategory(CategoryEntity categoryEntity) {

        if (categoryEntity == null) {
            return null;
        }
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        category.setDescription(categoryEntity.getDescription());
        category.setCreationTime(categoryEntity.getCreationTime());

        return category;
    }

    public CategoryEntity toCategoryEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(category.getId());

        return categoryEntity;
    }
}
