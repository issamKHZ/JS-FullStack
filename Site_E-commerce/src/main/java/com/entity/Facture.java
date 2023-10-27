package com.entity;

import java.io.Serializable;

import javax.persistence.*;




@Entity
public class Facture implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ; 
	
	 @JoinColumn(name = "client_id", referencedColumnName = "id")
	 @ManyToOne(optional = false)
	 private User user;
	 
	 @Column(nullable = false)
	 private double total ;
	 
	 
	 
	 
	 public Facture() {
		 super() ; 
	 }
	 
	 

	public Facture(long id, User user, double total) {
		super();
		this.id = id;
		this.user = user;
		this.total = total;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User userId) {
		this.user = userId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	} 
	 
	 
	 

	
	

}
