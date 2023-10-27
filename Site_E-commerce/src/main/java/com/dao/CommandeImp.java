package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.imp.IArtisan;
import com.dao.imp.ICommande;
import com.dao.imp.IUser;
import com.dao.imp.ICommande;
import com.entity.Article;
import com.entity.Artisan;
import com.entity.Commande;
import com.entity.User;
import com.util.JPAutil;

public class CommandeImp implements ICommande{
	
	private EntityManager entityManager=JPAutil.getEntityManager("ProjectJPAPU");

	@Override
	public Commande save(Commande cat ) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.persist(cat);
	 	tx.commit();
		return cat;
	}

	@Override
	public Commande getCommande(long id) {
     	return entityManager.find(Commande.class, id);
	}

	@Override
	public Commande updateCommande(Commande cat) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(cat);
	 	tx.commit();
		return cat;
	}

	@Override
	public void deleteCommande(long id) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin(); 
		 Commande cmd = entityManager.find(Commande.class, id);
		 entityManager.remove(cmd);
		 tx.commit();
		
	}

	@Override
	public List<Commande> getAllCommandes() {
		List<Commande> cats = entityManager.createQuery("select c from Commande c").getResultList();
		return cats;
	}
	
	public List<Commande> getCommandesPerUser(long UserId){
		IUser iuser = new UserImp() ; 
		User user = iuser.getUser(UserId) ; 
		  List<Commande> cmds = entityManager.createQuery("SELECT c FROM Commande c WHERE c.user = :user", Commande.class).setParameter("user", user ).getResultList();
		  return cmds ; 
	}
	




}
