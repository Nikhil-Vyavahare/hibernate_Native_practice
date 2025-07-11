package sessionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionF {
	private static SessionFactory sessionFactory  = null;
	
	static {
		try {
			if (sessionFactory == null) {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	
}
