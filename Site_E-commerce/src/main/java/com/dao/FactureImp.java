package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.imp.IFacture;
import com.dao.imp.IUser;
import com.entity.Facture;
import com.entity.User;
import com.util.JPAutil;

public class FactureImp implements IFacture{
	
	private EntityManager entityManager=JPAutil.getEntityManager("ProjectJPAPU");

	@Override
	public Facture save(Facture cat ) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 		entityManager.persist(cat);
	 	tx.commit();
	 	
		return cat;
	}

	@Override
	public Facture getFacture(long id) {
     	return entityManager.find(Facture.class, id);
	}

	@Override
	public Facture updateFacture(Facture cat) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(cat);
	 	tx.commit();
		return cat;
	}

	@Override
	public void deleteFacture(long id) {
		 Facture cmd = entityManager.find(Facture.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(cmd);
		 entityManager.getTransaction().commit();
		
	}

	@Override
	public List<Facture> getAllFactures() {
		List<Facture> cats = entityManager.createQuery("select c from Facture c").getResultList();
		return cats;
	}
	
	public List<Facture> getFacturesPerUser(long UserId){
		
		IUser iuser = new UserImp() ; 
		List<Facture> Factures = null ; 
		User user = iuser.getUser(UserId)  ; 
		Factures = user.getFactures() ; 
		return Factures ; 
	}


}
