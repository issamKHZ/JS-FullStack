package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(length = 50)
    private String nom;    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<Article> articles; 
    
    @Column(length = 50, name = "articles")
    private int numberArticles;
    
    public Stock() {
        this.numberArticles = 0;
    }
    
    public Stock(String nom, int numberArticles) {
        this.nom = nom;
        this.numberArticles = numberArticles ;
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
    
    public List<Article> getArticles() {
        return articles;
    }
    
    public void setArticles(List<Article> articles) {
        this.articles = articles;
        this.numberArticles = articles != null ? articles.size() : 0;
    }
    
    public int getNumberArticles() {
        return numberArticles;
    }
    
    public void setNumberArticles(int numberArticles) {
        this.numberArticles = numberArticles;
    }
}

