package com.dao.imp;


import java.util.List;

import com.entity.User;

public interface IUser {
	
	public User save(User user) ; 
	public User getUser(long id) ; 
	public User getUserPerUsername(String name) ;
	public User updateUser(User a) ; 
	public void deleteUser(long id) ; 
	
	

}
