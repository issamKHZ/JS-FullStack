package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ; 
	
	@Basic(optional = false)
	@Column(length = 70)
	private String nom ; 
	
	@Basic(optional = false)
	@Column(length = 170)
	private String prenom ; 
	
	@Basic(optional = false)
	@Column(length = 170, unique=true)
	private String username ;
	
	@Basic(optional = false)
	@Column(length = 170)
	private String password ; 
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	List<Facture> factures ; 
     
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	List<Commentaire> commentaires ; 
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	List<Commande> commandes ; 
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  	List<OrdredProduct> orders ;
	
	
	public User() {
		super();
	}
	
	
	public User(String nom, String prenom, String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
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
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
	public boolean isValid(String username, String password) {
		return (this.password.equals(password) && this.username.equals(username)) ; 
		
	}


	public List<Commande> getCommandes() {
		return commandes;
	}


	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}


	public List<OrdredProduct> getOrders() {
		return orders;
	}


	public void setOrders(List<OrdredProduct> orders) {
		this.orders = orders;
	}
	
	
	
	
	
}
