package noctua.impl.service;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;

import noctua.dao.UserDao;
import noctua.dto.UserDTO;
import noctua.entity.UserEntity;
import noctua.impl.dao.UserDaoImpl;
import noctua.service.PasswordService;
import noctua.service.UserService;

public class UserServiceImpl implements UserService {

	private org.jboss.logging.Logger LOG = LoggerFactory.logger(UserServiceImpl.class);

	private PasswordService passwordService = new PasswordServiceImpl();
	
	private UserDao dao = new UserDaoImpl();
	
	public UserServiceImpl() {
		Configuration configure = new Configuration();
		configure.configure();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Noctua");
		EntityManager em = factory.createEntityManager();
		dao.setEntityManager(em);
	}

	@Override
	public UserDTO searchUser(String email, String password, String firebase) {
		if (email.isEmpty() || email == null || email.equals("")) {
			LOG.info("Email est� vazio");
			return null;
		} else {
			try {
				UserDTO dto = new UserDTO();

				String userPassword;

				String cryptedPassword;

				String salt;

				dto = dao.searchUser(email, password, firebase).get(0);

				salt = dto.getSalt();

				userPassword = dto.getPassword();

				cryptedPassword = passwordService.checkPassword(password, salt);

				if (userPassword.equals(cryptedPassword)) { 
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
				String salt = new String();
				String[] password = {};
				
				criptedPassword = passwordService.saltPassword(user.getPassword());
				password = criptedPassword.split("|"); 
				salt = password[1];
				criptedPassword = password[0];

				user.setPassword(criptedPassword);
				user.setSalt(salt);
				UserEntity entity = new UserEntity(user);
				dao.createUser(entity);
			} catch (Exception e) {
				LOG.info("Algo deu errado ao criar cliente: " + e.getMessage());
			}
		}
	}

}
