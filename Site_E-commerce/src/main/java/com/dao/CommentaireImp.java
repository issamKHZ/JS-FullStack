package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.imp.IArticle;
import com.dao.imp.ICommentaire;
import com.dao.imp.IUser;
import com.entity.Article;
import com.entity.Commande;
import com.entity.Commentaire;
import com.entity.User;
import com.util.JPAutil;

public class CommentaireImp implements ICommentaire{
	
	private EntityManager entityManager=JPAutil.getEntityManager("ProjectJPAPU");

	@Override
	public Commentaire save(Commentaire cat ) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 		entityManager.persist(cat);
	 	tx.commit();
	 	
		return cat;
	}

	@Override
	public Commentaire getCommentaire(long id) {
     	return entityManager.find(Commentaire.class, id);
	}

	@Override
	public Commentaire updateCommentaire(Commentaire cat) {
		EntityTransaction tx = entityManager.getTransaction();
	 	tx.begin();
	 	entityManager.merge(cat);
	 	tx.commit();
		return cat;
	}

	@Override
	public void deleteCommentaire(long id) {
		 Commentaire cmd = entityManager.find(Commentaire.class, id);

		 entityManager.getTransaction().begin();
		 entityManager.remove(cmd);
		 entityManager.getTransaction().commit();
		
	}

	@Override
	public List<Commentaire> getAllCommentaires() {
		List<Commentaire> cats = entityManager.createQuery("select c from Commentaire c").getResultList();
		return cats;
	}
	
	public List<Commentaire> getCommentairesPerUser(long UserId){
		
		IUser iuser = new UserImp() ; 
		User user = iuser.getUser(UserId)  ; 
		List<Commentaire> Commentaires = entityManager.createQuery("SELECT c FROM Commentaire c WHERE c.user = :user", Commentaire.class).setParameter("user", user ).getResultList(); ; 
		return Commentaires ; 
	}
	
	public List<Commentaire> getCommentairesPerArticle(long articleId){
		
		IArticle iarticle = new ArticleImp() ; 
		Article article = iarticle.getArticle(articleId) ; 
		List<Commentaire> commentaires = entityManager.createQuery("SELECT c FROM Commentaire c WHERE c.article = :article", Commentaire.class).setParameter("article", article ).getResultList(); 
		return commentaires ; 
	}
	
	 public long getNumberOfCommentsOfArticle(long id) { 
		IArticle iarticle = new ArticleImp() ; 
		Article article = iarticle.getArticle(id) ; 
		 long nbCmt =  entityManager.createQuery("SELECT COUNT(c) FROM Commentaire c WHERE c.article = :article", Long.class).setParameter("article", article ).getSingleResult();
		 return nbCmt ; 
	 
	 }
	
	

}
