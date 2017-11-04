package main.java.com.angular.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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

}
