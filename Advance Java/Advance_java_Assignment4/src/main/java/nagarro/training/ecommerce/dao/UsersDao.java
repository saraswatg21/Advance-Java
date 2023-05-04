package nagarro.training.ecommerce.dao;

import org.hibernate.Session;

import nagarro.training.ecommerce.entities.Users;
import nagarro.training.ecommerce.services.DbConnectionImp;

public class UsersDao {

	DbConnectionImp dbConnectionImp = new DbConnectionImp();

	public Users get() {
		Session session = DbConnectionImp.getSessionFactory(Users.class);
		Users users = (Users) session.get(Users.class, 1);
		return users;
	}
}
