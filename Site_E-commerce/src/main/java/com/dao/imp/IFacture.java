package com.dao.imp;

import java.util.List;

import com.entity.Facture;

public interface IFacture {
	public Facture save(Facture cat);
	public Facture getFacture(long id);
	public Facture updateFacture(Facture cat);
	public void deleteFacture(long id);
	public List<Facture> getAllFactures();

}
