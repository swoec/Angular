package main.java.com.angular.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@SuppressWarnings("unchecked")
@Repository("commDao")
public class CommodityDaoImpl implements ICommodityDao {
	@Autowired
    protected SessionFactory sessionFactory;
    
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    

}
