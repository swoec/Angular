package main.java.com.angular.service;

import java.util.List;

import main.java.com.angular.model.OrderlistEntity;

public interface IOrderService {
	
	public List<OrderlistEntity> getOrderbyId(int id);
	public boolean addorders(int userId, String address, String phone, String totalPrice, String pay, String orderList);
	public boolean addorderlist(int userId, String commodityIds, String commodityCounts);
}
