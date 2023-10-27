package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.imp.ICategory;
import com.entity.Category;
import com.util.JPAutil;

public class CategoryImp implements ICategory{
	
	private EntityManager entityManager=JPAutil.getEntityManager("ProjectJPAPU");

	@Override
	public Category save(Category cat ) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 		entityManager.persist(cat);
	 	tx.commit();
	 	
		return cat;
	}

	@Override
	public Category getCategory(long id) {
     	return entityManager.find(Category.class, id);
	}

	@Override
	public Category updateCategory(Category cat) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(cat);
	 	tx.commit();
		return cat;
	}

	@Override
	public void deleteCategory(long id) {
		 Category categorie = entityManager.find(Category.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(categorie);
		 entityManager.getTransaction().commit();
		
	}

	@Override
	public List<Category> getAllCategories() {
		List<Category> cats = entityManager.createQuery("select c from Category c").getResultList();
		return cats;
	}

}
