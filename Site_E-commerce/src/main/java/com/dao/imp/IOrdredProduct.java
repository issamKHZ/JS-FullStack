package com.dao.imp;

import java.util.List;

import com.entity.OrdredProduct;

public interface IOrdredProduct {
	
	public OrdredProduct save(OrdredProduct cat);
	public OrdredProduct getOrdredProduct(long id);
	public OrdredProduct updateOrdredProduct(OrdredProduct cat);
	public void deleteOrdredProduct(long id);
	public List<OrdredProduct> getAllOrdredProducts();
	public List<OrdredProduct> getOrdredProductsPerUser(long id);


}
