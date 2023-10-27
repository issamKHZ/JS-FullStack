package com.dao.imp;

import java.util.List;

import com.entity.OrderDetail;

public interface IOrderDetail {
	public OrderDetail save(OrderDetail ordre);
	public OrderDetail getOrderDetail(long id);
	public OrderDetail updateOrderDetail(OrderDetail cat);
	public void deleteOrderDetail(long id);
	public List<OrderDetail> getAllOrderDetails();
}
