package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id ;  

		
		 @JoinColumn(name = "facture_id", referencedColumnName = "id")
		 @ManyToOne(optional = false)
		 private Facture facture;
		 
		 @ManyToOne
		 private User user  ;
		 
		 @ManyToOne
		 private Article article  ;
//		 
//	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
//		List<Article> articles ; 
	    
		 
	    public Commande() {
	    	super();
	    	
	    }
		 public Commande(User user, Article article) {
			 super() ; 
			 this.user = user ; 
			 this.article = article ; 
		 }


		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Facture getFacture() {
			return facture;
		}

		public void setFacture(Facture facture) {
			this.facture = facture;
		}

	

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		public Article getArticle() {
			return article;
		}
		public void setArticle(Article article) {
			this.article = article;
		}

	
		
		
		 
		 
}
