package hibernate.basic;


import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateBasicEg1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserId(2);
		user.setUserName("venkatesh1");
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		

	}

}
