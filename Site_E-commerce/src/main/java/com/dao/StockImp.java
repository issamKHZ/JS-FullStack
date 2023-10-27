package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.imp.IStock;
import com.entity.Article;
import com.entity.Category;
import com.entity.Stock;
import com.util.JPAutil;

public class StockImp implements IStock {
	private EntityManager entityManager=JPAutil.getEntityManager("ProjectJPAPU");


	@Override
	public Stock save(Stock stck) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 		entityManager.persist(stck);
	 	tx.commit();
	 	
		return stck;
	}

	@Override
	public Stock getStock(long id) {
     	return entityManager.find(Stock.class, id);

	}
	
	public List<Stock> getAllStocks() {
		try {
			List<Stock> stocks = entityManager.createQuery("select s from Stock s").getResultList();
			return stocks;
			
		}catch(Exception e) {
			System.out.println(e);
			return null ; 
		}
	}

	@Override
	public Stock updateStock(Stock stck) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(stck);
	 	tx.commit();
		return stck;
	}

	@Override
	public void deleteStock(long id) {
		 Stock stock = entityManager.find(Stock.class, id);
		 entityManager.getTransaction().begin();
		 entityManager.remove(stock);
		 entityManager.getTransaction().commit();
		
	}

	

}
