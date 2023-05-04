package govind.saraswat.hibernate_assign;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import data.Tshirt;



public class Configure {
	
	List<Tshirt> searchedItems = new ArrayList<Tshirt>();

	public List<Tshirt> searchItem(String color, String gender, String size) {

		Configuration configure = new Configuration().configure().addAnnotatedClass(Tshirt.class);
		StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configure.getProperties());
		SessionFactory sessionFactory = configure.buildSessionFactory(serviceRegistry.build());
		Session session = sessionFactory.openSession();
		try {
			
//			String hql = "from tshirt where colour = '" + color + "' AND size = '" + size + "' AND gender = '" + gender
//					+ "'";
     		String hql = " from Tshirt"; 
   			Query query = session.createQuery(hql);
			searchedItems =query.list();
			

		} 
		catch (IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		} 
//		catch (NoItemFoundException e) {
//			System.out.println(e.getMessage());
//		}
		return searchedItems;
	}

}