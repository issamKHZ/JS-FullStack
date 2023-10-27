package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.imp.IOrderDetail;
import com.entity.OrderDetail;
import com.util.JPAutil;

public class OrderDetailImp implements IOrderDetail{
	
	private EntityManager entityManager=JPAutil.getEntityManager("ProjectJPAPU");

	@Override
	public OrderDetail save(OrderDetail cat ) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.persist(cat);
	 	tx.commit();
	 	
		return cat;
	}

	@Override
	public OrderDetail getOrderDetail(long id) {
     	return entityManager.find(OrderDetail.class, id);
	}

	@Override
	public OrderDetail updateOrderDetail(OrderDetail cat) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(cat);
	 	tx.commit();
		return cat;
	}

	@Override
	public void deleteOrderDetail(long id) {
		 OrderDetail categorie = entityManager.find(OrderDetail.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(categorie);
		 entityManager.getTransaction().commit();
		
	}

	@Override
	public List<OrderDetail> getAllOrderDetails() {
		List<OrderDetail> cats = entityManager.createQuery("select c from OrderDetail c").getResultList();
		return cats;
	}

}
