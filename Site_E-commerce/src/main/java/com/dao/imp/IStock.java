package com.dao.imp;

import java.util.List;

import com.entity.Stock;

public interface IStock {

	public Stock save(Stock stck);
	public Stock getStock(long id);
	public Stock updateStock(Stock stck);
	public void deleteStock(long id);
	public List<Stock> getAllStocks();
}
