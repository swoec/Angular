package main.java.com.angular.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.angular.dao.IOrderDao;
import main.java.com.angular.model.OrderlistEntity;

@Transactional
@Service("orderService")
public class OrderServiceImpl implements IOrderService {
	  @Resource
	  private IOrderDao orderDao;

	@Override
	public List<OrderlistEntity> getOrderbyId(int id) {
		// TODO Auto-generated method stub
		return orderDao.getOrderbyId(id);
	}

	@Override
	public boolean addorders(int userId, String address, String phone, String totalPrice, String pay,
			String orderList) {
		// TODO Auto-generated method stub
		return orderDao.addorders(userId, address, phone, totalPrice, pay, orderList);
	}

	@Override
	public boolean addorderlist(int userId, String commodityIds, String commodityCounts) {
		// TODO Auto-generated method stub
		String[] commodityIdsArray = commodityIds.split(","); 
		String[] commodityCountsArray = commodityCounts.split(",");
		boolean res=true;
		for(int i=0;i<commodityIdsArray.length;i++){
		 if(!orderDao.addorderlist(userId, commodityIdsArray[i], commodityCountsArray[i]))
		    res=false;
		 break;
		}
		return res;
	}
}
