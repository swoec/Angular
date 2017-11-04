package main.java.com.angular.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.angular.dao.ICommodityDao;

@Transactional
@Service("commService")
public class CommodityServiceImpl implements ICommodityService {
	@Resource
	private ICommodityDao commdao;
}
