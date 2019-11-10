package br.com.noctua.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.noctua.dao.ResponsibleDao;
import br.com.noctua.dao.UserDao;
import br.com.noctua.dao.UserResponsibleDao;
import br.com.noctua.dto.ResponsibleDTO;
import br.com.noctua.dto.UserDTO;
import br.com.noctua.entity.ResponsibleEntity;
import br.com.noctua.entity.UserEntity;
import br.com.noctua.entity.UserResponsibleEntity;
import br.com.noctua.service.UserResponsibleService;

@Service
public class UserResponsibleServiceImpl implements UserResponsibleService {

	@Autowired
	private UserResponsibleDao dao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ResponsibleDao responsibleDao;

	@Override
	public List<ResponsibleDTO> findResponsibles(long userId) {
		List<UserResponsibleEntity> userResponsible;
		List<ResponsibleDTO> responsibleList = new ArrayList<ResponsibleDTO>();
		Optional<ResponsibleEntity> responsibleEntity;

		userResponsible = dao.findAllByUserId(userId);
		for (UserResponsibleEntity entity : userResponsible) {
			responsibleEntity = responsibleDao.findById(entity.getResponsibleId());
			if (responsibleEntity.isPresent()) {
				responsibleList.add(new ResponsibleDTO(responsibleEntity.get()));
			}
		}

		return responsibleList;
	}

	@Override
	public List<UserDTO> findUsers(long responsibleId) {
		List<UserResponsibleEntity> userResponsible;
		List<UserDTO> userList = new ArrayList<UserDTO>();
		Optional<UserEntity> userEntity;
		
		userResponsible = dao.findAllByResponsibleId(responsibleId);
		for(UserResponsibleEntity entity: userResponsible) {
			userEntity = userDao.findById(entity.getUserId());
			if(userEntity.isPresent()) {
				userList.add(new UserDTO(userEntity.get()));
			}
		}
		
		return userList;
	}

	@Override
	public UserResponsibleEntity save(long userId, long responsibleId) {
		UserResponsibleEntity entity = new UserResponsibleEntity();
		entity.setResponsibleId(responsibleId);
		entity.setUserId(userId);
		
		entity = dao.save(entity);
		return entity;
	}

}
