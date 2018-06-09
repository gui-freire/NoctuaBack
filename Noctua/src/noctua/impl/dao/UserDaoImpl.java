package noctua.impl.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.eclipse.persistence.sessions.factories.SessionFactory;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import noctua.dao.UserDao;
import noctua.entity.UserEntity;

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
	public List<UserEntity> searchUser(String email) {
		return this.em.createQuery("SELECT C FROM UserEntity C WHERE C.email = ?1").setParameter(1, email).getResultList();
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
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
	}

}
