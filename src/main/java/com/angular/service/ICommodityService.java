package main.java.com.angular.service;

import java.util.List;

import org.springframework.stereotype.Component;

import main.java.com.angular.model.CommentEntity;
import main.java.com.angular.model.CommodityEntity;

@Component
public interface ICommodityService {
	public List<CommodityEntity> getCommbyId(int id);
	public List<CommodityEntity> getAllComm();
	public List<CommentEntity> getCommentbyId(int commid);
	public boolean addCommentbyId(int userId,int commodityID,String userName,String comment);
	
	

}
