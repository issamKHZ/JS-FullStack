package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dao.CommentaireImp;
import com.dao.imp.ICommentaire;

import javax.persistence.Basic;
import javax.persistence.CascadeType;


@Entity
@Table(name="Products")
public class Article implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id ; 
	
    @Basic(optional = false)
	@Column(name="price")
	private double price ;
	
    @Basic(optional = false)
	@Column(length = 120) 
	private String name ; 
	
	private double poids ;
	
	@Column(length = 250) 
	private String details ; 
	
	@Column(name = "qte")
    private int quantite;
	
	@Column(name = "pathName")
    private String image ;
	
	@ManyToOne
	private Category category ; 
	
	
	@ManyToOne
	private Artisan artisan ; 
	
	@ManyToOne 
	private Stock stock ; 
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
	List<Commande> commande ; 
	
    @OneToMany(mappedBy = "article")
	private List<Commentaire> commentaire ; 
	
	
	
	public Article() {
		super()  ;
	}
	
	public Article(String name,double price, double poids,int qte, String details,String image, Category cat,Artisan art, Stock stock){
		super()  ;
		this.name = name  ;
		this.price = price ; 
		this.poids = poids ; 
		this.details = details ; 
		this.image = image ; 
		this.quantite = qte ; 
		this.setCategory(cat) ; 
		this.setArtisan(art); 
		this.setStock(stock); 
	}
	
	
	public long getComments() {
		ICommentaire icmt = new CommentaireImp() ; 
		return icmt.getNumberOfCommentsOfArticle(this.id) ; 
		
	}
	



	public Artisan getArtisan() {
		return artisan;
	}

	public void setArtisan(Artisan artisan) {
		this.artisan = artisan;
	}

	public List<Commentaire> getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(List<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}

	public String getDetails() {
		return details;
	}
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	public long getId() {
		return id;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<Commande> getCommande() {
		return commande;
	}

	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}

	
	
	
	
	

}
