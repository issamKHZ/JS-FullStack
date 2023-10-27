package com.dao.imp;

import java.util.List;

import com.entity.Commande;

public interface ICommande {
	public Commande save(Commande cat);
	public Commande getCommande(long id);
	public Commande updateCommande(Commande cat);
	public void deleteCommande(long id);
	public List<Commande> getAllCommandes();
	public List<Commande> getCommandesPerUser(long UserId);

}
