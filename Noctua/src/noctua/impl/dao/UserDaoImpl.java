package noctua.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;

import noctua.dao.UserDao;
import noctua.dto.UserDTO;

public class UserDaoImpl implements UserDao {

	private EntityManager em;
	
	public UserDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserDTO> searchUser(String email, String password, String firebase) {
		return this.em.createQuery("SELECT C FROM CLIENTE C WHERE C.EMAIL = " + email).getResultList();
	}

	@Override
	public void createUser(UserDTO user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void updateUser(UserDTO user) {
		// TODO Auto-generated method stub

	}

}
