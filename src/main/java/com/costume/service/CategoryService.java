package com.costume.service;


import com.costume.model.Category;
import com.costume.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Servicio clase categoria
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> category1 = categoryRepository.getCategory(category.getId());
            if (category1.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

    public Category updateCategory(Category category){
        if (category.getId() != null){
            Optional<Category>  category1 = categoryRepository.getCategory(category.getId());
            if (!category1.isEmpty()){
                if (category.getName() != null){
                    category1.get().setName(category.getName());
                }
                if (category.getDescription() !=null){
                    category1.get().setDescription(category.getDescription());
                }
                return categoryRepository.save(category);
            }
        }

        return category;

    }

    public boolean deleteCategory(int id){
        Optional<Category>  category = categoryRepository.getCategory(id);
        if (category.isEmpty()){
            return  false;
        }else {
            categoryRepository.delete(category.get());
            return  true;
        }
    }
}
