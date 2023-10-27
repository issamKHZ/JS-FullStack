package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="artisans")
public class Artisan implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ; 
	
	@Column(length = 120) 
	private String nom ;
	
	@Column(length = 120) 
	private String prenom ; 
	
	@Column(length = 120, unique = true, nullable = false) 
	private String username ; 
	
	@Column(length = 120) 
	private String password ; 
	
	@Column(length = 120) 
	private int age ; 
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artisan")
	private List<Article> articles ;
    
    public Artisan() { 
    	super(); 
     }

    

	public Artisan(String nom, String prenom, String username, String password, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.age = age;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String name) {
		this.nom = name;
	}
	
	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	} 
	
	public boolean isValid(String username, String password) {
		return (this.password.equals(password) && this.username.equals(username)) ; 
		
	}
    
    
	

}
