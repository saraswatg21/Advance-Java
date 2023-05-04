package nagarro.training.ecommerce.services.imp;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import nagarro.training.ecommerce.entities.GenderType;
import nagarro.training.ecommerce.entities.SizeType;
import nagarro.training.ecommerce.entities.Tshirt;
import nagarro.training.ecommerce.services.DbConnectionImp;
import nagarro.training.ecommerce.services.SearchItemService;

public class SearchItemServiceImp implements SearchItemService {

	DbConnectionImp dbConnectionImpl=new DbConnectionImp();
	
	public List<Tshirt> findTshirt(String color, String gender, String size) {
		List<Tshirt> list=new ArrayList<Tshirt>();
		Session session= DbConnectionImp.getSessionFactory(Tshirt.class);
		Query query = session.createQuery("from Tshirt where colour=:c and gender=:g and size=:s");
		query.setParameter("c", color);
		query.setParameter("s", SizeType.valueOf(size));
		query.setParameter("g", GenderType.valueOf(gender));
		list =  query.list();
		session.close();
//		if (list.isEmpty()) {
//			throw new NoItemFoundException("No Items Matched");
//		}
		return list;
	}

}
