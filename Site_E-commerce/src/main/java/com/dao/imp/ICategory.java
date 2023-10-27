package com.dao.imp;

import java.util.List;

import com.entity.Category;

public interface ICategory {
	
	public Category save(Category cat);
	public Category getCategory(long id);
	public Category updateCategory(Category cat);
	public void deleteCategory(long id);
	public List<Category> getAllCategories();

}
