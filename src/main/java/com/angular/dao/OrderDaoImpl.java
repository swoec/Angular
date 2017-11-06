package main.java.com.angular.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import main.java.com.angular.model.OrderlistEntity;

@Component
@SuppressWarnings("unchecked")
@Repository("orderDao")
public class OrderDaoImpl implements IOrderDao {
	@Autowired
    protected SessionFactory sessionFactory;
    
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public List<OrderlistEntity> getOrderbyId(int id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
        String hql = "from OrderlistEntity where userId =?";
        Query query = session.createQuery(hql);
        query.setInteger(0, id);
        
        return query.list();
	}

	@Override
	public boolean addorders(int userId, String address, String phone, String totalPrice, String pay,
			String orderList) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "insert into orders(UID,ADDR,PHONE,TPRICE,IPAY,ORDLIST) values(?,?,?,?,?,?)";
		Query query = session.createSQLQuery(hql);
        query.setInteger(0, userId);
        query.setString(1, address);
        query.setString(2, phone);
        query.setString(3, totalPrice);
        query.setString(4, pay);
        query.setString(5, orderList);
        if(1==query.executeUpdate())
		      return true;
        else return false;
	}

	@Override
	public boolean addorderlist(int userId, String commodityId, String commodityCount) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		String hql = "from OrderlistEntity where userId =? and commodityId =?";
		Query query = session.createQuery(hql);
		if(0==query.list().size()){
			String ihql ="insert into orderlist(UID,CID,CCOUNT) values(?,?,?)";
			query.setInteger(0, userId);
			query.setInteger(0, Integer.parseInt(commodityId));
			query.setInteger(0, Integer.parseInt(commodityCount));
			Query insert = session.createSQLQuery(ihql);
			if(1==insert.executeUpdate())
			     return true;
			else return false;
		}else {
			OrderlistEntity order =(OrderlistEntity)query.list();
			commodityCount+=order.getCommodityCount();
		
			String uhql = "update orderlist set CCOUNT=? where UID="+userId+"and CID="+commodityId;
			query.setInteger(0, Integer.parseInt(commodityCount));
			Query update = session.createSQLQuery(uhql);
			if(1==update.executeUpdate())
				 return true;
			else return false;
		}
		
	}

}
