package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;


@Entity
public class OrdredProduct implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "order_date")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
 
    private int orderNumb;
    @Column(nullable = false)
    private String status;
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "totalP")
    private double total;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
    private User user;
  
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private OrderDetail orderDetail;
   
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Article article;
    
	public OrdredProduct() {
		super();
	}
	
	
	public OrdredProduct(Date orderDate, int orderNumb, String status, int quantity, double total, User user,
			OrderDetail orderDetail, Article article) {
		super();
		this.orderDate = orderDate;
		this.orderNumb = orderNumb;
		this.status = status;
		this.quantity = quantity;
		this.total = total ;
		this.user = user;
		this.orderDetail = orderDetail;
		this.article = article;
	}




	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderNumb() {
		return orderNumb;
	}
	
	

	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public void setOrderNumb(int orderNumb) {
		this.orderNumb = orderNumb;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
}
