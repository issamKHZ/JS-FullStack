package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.imp.IArtisan;
import com.entity.Artisan;
import com.entity.Artisan;
import com.util.JPAutil;

public class ArtisanImp implements IArtisan {
	private EntityManager entityManager=JPAutil.getEntityManager("ProjectJPAPU");


	@Override
	public Artisan save(Artisan a) {
		try {
			EntityTransaction tx = entityManager.getTransaction()  ;
			tx.begin();
			entityManager.persist(a);
			tx.commit();
			return a ; 
		}catch(Exception e) {
			System.out.println(e);
			return null ; 
		}
	}

	@Override
	public Artisan getArtisan(long id) {
     	return entityManager.find(Artisan.class, id);
	}
	
	public Artisan getArtisanPerUsername(String username) {
		Artisan Artisan = null;
		try {
			Artisan = entityManager.createQuery("select a from Artisan a where a.username = :username",Artisan.class ).setParameter("username",username).getSingleResult(); 
			return Artisan ; 
		}catch(Exception e) {
			System.out.println(e);
			return Artisan ; 
		}
	}
	
	public List<Artisan> getArtisansPerName(String name) {
	    List<Artisan> artisans = null;
	    try {
	        artisans = entityManager.createQuery("SELECT a FROM Artisan a WHERE a.nom LIKE :name OR a.prenom Like :name", Artisan.class)
	                .setParameter("name", "%" + name + "%")
	                .getResultList();
	        return artisans;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}


	@Override
	public List<Artisan> getAllArtisans() {
		List<Artisan> artisans = entityManager.createQuery("select a from artisan a").getResultList();
		return artisans;
	}

	@Override
	public void deleteArtisan(Long id) {
		// TODO Auto-generated method stub
		
	}



}
