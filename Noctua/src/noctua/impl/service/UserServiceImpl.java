package noctua.impl.service;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;
import org.mindrot.jbcrypt.BCrypt;

import noctua.dao.UserDao;
import noctua.dao.VitalDao;
import noctua.dto.UserDTO;
import noctua.dto.Vital;
import noctua.entity.UserEntity;
import noctua.entity.VitalEntity;
import noctua.impl.dao.UserDaoImpl;
import noctua.impl.dao.VitalDaoImpl;
import noctua.service.PasswordService;
import noctua.service.UserService;

public class UserServiceImpl implements UserService {

	private org.jboss.logging.Logger LOG = LoggerFactory.logger(UserServiceImpl.class);

	private PasswordService passwordService = new PasswordServiceImpl();
	
	private UserDao dao = new UserDaoImpl();
	
	private VitalDao vital = new VitalDaoImpl();
	
	public UserServiceImpl() {
		Configuration configure = new Configuration();
		configure.configure();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Noctua");
		EntityManager em = factory.createEntityManager();
		dao.setEntityManager(em);
		vital.setEntityManager(em);
	}

	@Override
	public UserDTO searchUser(String email, String password, String firebase) {
		if (email.isEmpty() || email == null || email.equals("")) {
			LOG.info("Email est� vazio");
			return null;
		} else {
			try {
				String userPassword;

				UserEntity user = dao.searchUser(email).get(0);
				
				UserDTO dto = new UserDTO(user);

				userPassword = dto.getPassword();
				
				if (BCrypt.checkpw(password, userPassword)) { 
					VitalEntity vitalEntity = vital.searchLast(user.getId());
					Vital vitalDto = new Vital();
					if(vitalEntity != null) {
						vitalDto = new Vital(vitalEntity);
					} 
					dto.setVital(vitalDto);
					return dto;
				} else {
					dto = new UserDTO();
					dto.setName("incorreto");
					return dto;
				}
			} catch (Exception e) {
				LOG.info("Algo deu errado ao consultar usu�rio: " + e.getMessage());
				return null;
			}
		}
	}

	@Override
	public void createUser(UserDTO user) {
		if (user == null) {
			LOG.info("Usu�rio est� vazio");
		} else {
			try {
				String criptedPassword = new String();
				
				criptedPassword = passwordService.saltPassword(user.getPassword());

				user.setPassword(criptedPassword);
				UserEntity entity = new UserEntity(user);
				dao.createUser(entity);
			} catch (Exception e) {
				LOG.info("Algo deu errado ao criar cliente: " + e.getMessage());
			}
		}
	}

}
