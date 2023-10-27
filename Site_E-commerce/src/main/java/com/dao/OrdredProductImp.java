package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.imp.IOrdredProduct;
import com.dao.imp.IUser;
import com.entity.Commande;
import com.entity.OrdredProduct;
import com.entity.User;
import com.util.JPAutil;

public class OrdredProductImp implements IOrdredProduct{
	
	private EntityManager entityManager=JPAutil.getEntityManager("ProjectJPAPU");

	@Override
	public OrdredProduct save(OrdredProduct cat ) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 		entityManager.persist(cat);
	 	tx.commit();
	 	
		return cat;
	}

	@Override
	public OrdredProduct getOrdredProduct(long id) {
     	return entityManager.find(OrdredProduct.class, id);
	}

	@Override
	public OrdredProduct updateOrdredProduct(OrdredProduct cat) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(cat);
	 	tx.commit();
		return cat;
	}

	@Override
	public void deleteOrdredProduct(long id) {
		 OrdredProduct cmd = entityManager.find(OrdredProduct.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(cmd);
		 entityManager.getTransaction().commit();
		
	}

	@Override
	public List<OrdredProduct> getAllOrdredProducts() {
		List<OrdredProduct> cats = entityManager.createQuery("select op from OrdredProduct op").getResultList();
		return cats;
	}
	
	public List<OrdredProduct> getOrdredProductsPerUser(long UserId){
		
		IUser iuser = new UserImp() ; 
		User user = iuser.getUser(UserId) ; 
		List<OrdredProduct> orders = entityManager.createQuery("SELECT op FROM OrdredProduct op WHERE op.user = :user", OrdredProduct.class).setParameter("user", user ).getResultList();
		return orders ; 
	}


}
