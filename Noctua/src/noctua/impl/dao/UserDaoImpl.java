package noctua.impl.dao;

import javax.persistence.EntityManager;

import noctua.dao.UserDao;
import noctua.dto.UserDTO;
import noctua.entity.User;

public class UserDaoImpl implements UserDao {

	private EntityManager em;
	
	private User user;
	
	public UserDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public UserDTO searchUser(String email, String password, String firebase) {
		return this.em.createQuery("SELECT C FROM CLIENTE C WHERE C.EMAIL = " + email).getResultList();
	}

	@Override
	public void createUser(UserDTO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(UserDTO user) {
		// TODO Auto-generated method stub

	}

}
