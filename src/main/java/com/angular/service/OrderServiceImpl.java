package main.java.com.angular.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.angular.dao.IOrderDao;

@Transactional
@Service("orderService")
public class OrderServiceImpl implements IOrderService {
	  @Resource
	  private IOrderDao orderDao;
}
