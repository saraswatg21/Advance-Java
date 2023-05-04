package nagarro.training.ecommerce.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class DbConnectionImp{

	public static Session getSessionFactory(Class<?> cls) {
		Configuration configure = new Configuration().configure().addAnnotatedClass(cls);
		StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configure.getProperties());
		SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry.build());
		Session session = sessionFactory.openSession();
		return session;
	}

}
