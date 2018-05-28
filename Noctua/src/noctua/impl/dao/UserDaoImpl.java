package noctua.impl.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import noctua.dao.UserDao;
import noctua.dto.UserDTO;
import noctua.entity.UserEntity;
import noctua.webservices.UserWebService;

public class UserDaoImpl implements UserDao {

	private EntityManager em;
	
	private Logger LOG = LoggerFactory.logger(UserDaoImpl.class);
	
	public UserDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	public UserDaoImpl() {

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
	public void createUser(UserEntity user) {
		try{
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		} catch(Exception sql) {
			LOG.error(sql.getLocalizedMessage());
		}

	}

	@Override
	public void updateUser(UserEntity user) {
		// TODO Auto-generated method stub

	}

}
