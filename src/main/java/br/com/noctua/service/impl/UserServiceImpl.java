package br.com.noctua.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.noctua.dao.ResponsibleDao;
import br.com.noctua.dao.UserDao;
import br.com.noctua.dto.ResponsibleDTO;
import br.com.noctua.dto.UserDTO;
import br.com.noctua.entity.ResponsibleEntity;
import br.com.noctua.entity.UserEntity;
import br.com.noctua.exceptions.IncorrectPasswordException;
import br.com.noctua.service.UserResponsibleService;
import br.com.noctua.service.UserService;
import br.com.noctua.utils.CryptoUtils;

@Service
public class UserServiceImpl implements UserService {

	private Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao dao;

	@Autowired
	private ResponsibleDao responsibleDao;
	
	@Autowired
	private UserResponsibleService userResponsible;
	
	@Override
	public UserDTO searchUser(String email, String password, String firebase) throws IncorrectPasswordException {
		try {
			UserEntity user = dao.findByEmail(email);
			UserDTO dto = new UserDTO(user);
			
			CryptoUtils utils = new CryptoUtils();

			if (utils.comparePasswords(password, dto.getPassword())) {
				dto.setResponsible(userResponsible.findResponsibles(user.getId()));
				
				return dto;
			} else {
				String msgError = "Senha incorreta";
				LOG.error(msgError);
				throw new IncorrectPasswordException(msgError);
			}
		} catch (IncorrectPasswordException e) {
			throw e;
		} catch (Exception e) {
			String msgError = "Algo de errado aconteceu durante a busca do usuário.";
			LOG.error(msgError, e);
			return null;
	}

	}

	@Override
	public UserDTO createUser(UserDTO user) {
		try {
			CryptoUtils utils = new CryptoUtils();
			user.setPassword(utils.saltPassword(user.getPassword()));
			UserEntity entity = new UserEntity(user);
			entity = dao.save(entity);
			
			ResponsibleEntity responsibleEntity;
			List<ResponsibleDTO> responsibleList = user.getResponsible();
			for(ResponsibleDTO r: responsibleList) {
				responsibleEntity = responsibleDao.save(new ResponsibleEntity(r));
				userResponsible.save(entity.getId(), responsibleEntity.getId());
			}
			
			return new UserDTO(entity);
		} catch (Exception e) {
			LOG.info("Algo deu errado ao criar cliente: " + e.getMessage());
			return null;
		}
	}

	@Override
	public UserDTO changeUser(UserDTO dto) {
		try {
			LOG.info("Alterando usuário");
			UserEntity user = new UserEntity(dto);
			UserEntity entity = dao.save(user);
			
			return new UserDTO(entity);
		} catch (Exception e) {
			LOG.info("Algo deu errado ao alterar usuário: " + e.getMessage());
			return null;
		}
	}
}
