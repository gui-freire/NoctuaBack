package noctua.impl.dao;

import javax.persistence.EntityManager;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import noctua.dao.ResponsibleDao;
import noctua.dto.ResponsibleDTO;
import noctua.entity.ResponsibleEntity;

public class ResponsibleDaoImpl implements ResponsibleDao {

	private EntityManager em;
	
	private Logger LOG = LoggerFactory.logger(UserDaoImpl.class);
	
	@Override
	public void createResponsible(ResponsibleEntity resp) {
		em.getTransaction().begin();
		em.persist(resp);
		em.getTransaction().commit();
	}

	@Override
	public ResponsibleDTO searchResponsible(String email) {
		return (ResponsibleDTO) this.em.createQuery("SELECT R FROM ResponsibleEntity R WHERE R.email = " + email).getResultList().get(0);
	}

	@Override
	public void updateResponsible(ResponsibleEntity resp) {
		em.getTransaction().begin();
		em.merge(resp);
		em.getTransaction().commit();
	}
	
	@Override
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}
