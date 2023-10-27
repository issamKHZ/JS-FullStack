package com.dao.imp;

import java.util.List;

import com.entity.Artisan ;
import com.entity.User;

public interface IArtisan {
	public Artisan  save(Artisan Artisan ) ; 
	public Artisan  getArtisan(long id) ; 
	public List<Artisan>  getAllArtisans() ; 
	public Artisan getArtisanPerUsername(String username) ;
	public void deleteArtisan (Long id) ;
	public List<Artisan> getArtisansPerName(String name); 
}
