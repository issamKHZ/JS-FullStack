package com.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Commentaire implements Serializable {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    @Column(nullable = false)
	    private String contenu;
	     
	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date datetime;

	    
	    @ManyToOne
	    @JoinColumn(name = "id_user")
	    private User user;
	    
	    @ManyToOne
	    @JoinColumn(name = "id_article")
	    private Article article;
	    
	    
	    
	    public Commentaire() {
	    	super() ; 
	    }
	    

		public Commentaire(String contenu, User user, Article article, Date date) {
			super();
			this.contenu = contenu;
			this.datetime = date ; 
			this.user = user;
			this.article = article;
		}



		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getContenu() {
			return contenu;
		}

		public void setContenu(String contenu) {
			this.contenu = contenu;
		}

		
		
		public Date getDatetime() {
			return datetime;
		}


		public void setDatetime(Date datetime) {
			this.datetime = datetime;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User userId) {
			this.user = userId;
		}


		public Article getArticle() {
			return article;
		}

		public void setArticle(Article article) {
			this.article = article;
		}
	    
	    
	    
	    
	    
}
