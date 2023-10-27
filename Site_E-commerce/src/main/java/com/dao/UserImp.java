package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.imp.IUser;
import com.entity.User;
import com.entity.User;
import com.util.JPAutil;

public class UserImp implements IUser {
	
	private EntityManager em = JPAutil.getEntityManager("ProjectJPAPU") ; 

	@Override
	public User save(User user) {
		try {
			EntityTransaction tx = em.getTransaction()  ;
			tx.begin();
			em.persist(user);
			tx.commit();
			return user ; 
		}catch(Exception e) {
			System.out.println(e);
			return null ; 
		}
	}

	@Override
	public User getUserPerUsername(String username) {
		User user = null;
		try {
			user = em.createQuery("select u from User u where u.username = :username",User.class ).setParameter("username",username).getSingleResult(); 
			return user ; 
		}catch(Exception e) {
			System.out.println(e);
			return user ; 
		}
	}

	@Override
	public User getUser(long id) {
		try {
			return em.find(User.class, id) ; 
		}catch(Exception e) {
			System.out.println(e);
			return null ; 
		}
	}

	@Override
	public User updateUser(User a) {
		
		try{
			EntityTransaction tx = em.getTransaction()  ;
			tx.begin();
			em.merge(a);
			tx.commit();
			return a; 
		}catch(Exception e) {
			System.out.println(e);
			return null ; 
		}
	}

	@Override
	public void deleteUser(long id) {
		try {
			
			EntityTransaction tx = em.getTransaction()  ;
			tx.begin();
			User User = em.find(User.class, id) ; 
			em.remove(User);
			tx.commit();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
