package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.imp.IArticle;
import com.dao.imp.IArtisan;
import com.dao.imp.ICategory;
import com.entity.Article;
import com.entity.Artisan;
import com.entity.Category;
import com.entity.User;
import com.util.JPAutil;

public class ArticleImp implements IArticle {
	
	private EntityManager em = JPAutil.getEntityManager("ProjectJPAPU") ; 

	@Override
	public Article save(Article article) {
		try {
			EntityTransaction tx = em.getTransaction()  ;
			tx.begin();
			em.persist(article);
			tx.commit();
			return article ; 
		}catch(Exception e) {
			System.out.println(e);
			return null ; 
		}
	}

	@Override
	public List<Article> articlePerName(String name) {
		List<Article> articles = null ; 
		try {
			articles = em.createQuery("select a from Article a where a.name LIKE :name" ).setParameter("name", "%" + name + "%").getResultList(); 
			return articles ; 
		}catch(Exception e) {
			System.out.println(e);
			return articles ; 
		}
	}
	
	public List<Article> articlePerArtisanName(String name) {
		IArtisan a = new ArtisanImp() ; 
		List<Article> articles = null ; 
		List<Artisan> artisans = a.getArtisansPerName(name) ; 
		for (Artisan artis : artisans) {
			articles = artis.getArticles() ; 
		}
		return articles ;
	}
	
	public List<Article> getArticlePerCat(long idCat) {
		ICategory icat = new CategoryImp() ; 
		Category cat = icat.getCategory(idCat) ; 
		List<Article> arts = em.createQuery("SELECT a FROM Article a WHERE a.category = :category", Article.class).setParameter("category", cat ).getResultList();
		  return arts ; 
		  
	}
	
	public List<Article> getArticlePerArt(long idArt) {
		IArtisan mArtisan = new ArtisanImp() ; 
		Artisan artisan = mArtisan.getArtisan(idArt) ; 
		  List<Article> arts = em.createQuery("SELECT a FROM Article a WHERE a.artisan = :artisan", Article.class).setParameter("artisan", artisan ).getResultList();
		  return arts ; 
	}


	
//	public List<Article> articlePerArtisanName(String name) {
//		List<Article> articles = null ; 
//		try {
//			articles = em.createQuery("select a from Article a where a. = :email",User.class  ).setParameter("name",name).getResultList(); 
//			return articles ; 
//		}catch(Exception e) {
//			System.out.println(e);
//			return articles ; 
//		}
//	}


	@Override
	public Article getArticle(long id) {
		try {
			return em.find(Article.class, id) ; 
		}catch(Exception e) {
			System.out.println(e);
			return null ; 
		}
	}

	@Override
	public Article updateArticle(Article a) {
		
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
	public void deleteArticle(Long id) {
		try {
			
			EntityTransaction tx = em.getTransaction()  ;
			tx.begin();
			Article article = em.find(Article.class, id) ; 
			em.remove(article);
			tx.commit();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public List<Article> articlePerCategory(long id){
		List<Article> articles = null ; 
		
		return articles ; 
	}
	
	public List<Article> getAllArticles() {
		List<Article> arts = em.createQuery("select a from Article a").getResultList();
		return arts ; 
	}

}
