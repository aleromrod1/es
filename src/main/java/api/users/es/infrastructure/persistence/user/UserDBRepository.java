package api.users.es.infrastructure.persistence.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api.users.es.domain.model.user.User;
import api.users.es.domain.model.user.UserRepository;
import api.users.es.domain.model.user.exception.InvalidUserIdException;
import api.users.es.domain.model.user.exception.UserCreationException;
import api.users.es.domain.model.user.exception.UserDeleteException;
import api.users.es.domain.model.user.exception.UserEntityNotFoundException;
import api.users.es.domain.model.user.exception.UserIdentifierNotAllowedException;
import api.users.es.domain.model.user.exception.UserUpdateException;

@Repository
public class UserDBRepository implements UserRepository {
	
	@Autowired
	private UserEntityMapper userEntityMapper;

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Transactional
	@Override
	public User create(User model) throws UserIdentifierNotAllowedException, UserEntityNotFoundException, InvalidUserIdException, UserCreationException {
		try {
			findById(model.getUserId());
			throw UserIdentifierNotAllowedException.of();
		} catch (UserEntityNotFoundException e) {
			var entity = userEntityMapper.toEntity(model);
			try {
				var saveEntity = userJpaRepository.save(entity);			
				return userEntityMapper.toModel(saveEntity);
			} catch (Exception ex) {
				throw UserCreationException.of();
			}
			
		}
	}
	
	@Transactional
	@Override
	public User update(User model) throws UserUpdateException, UserEntityNotFoundException, InvalidUserIdException {
		findById(model.getUserId());
		var entity = userEntityMapper.toEntity(model);
		try {
			userJpaRepository.save(entity);
			return findById(model.getUserId());
		} catch (Exception e) {
			throw UserUpdateException.of();
		}
	}

	@Transactional
	@Override
	public void delete(Integer userId) throws UserDeleteException, UserEntityNotFoundException, InvalidUserIdException{
		try {
			findById(userId);
			userJpaRepository.deleteById(userId);
		}catch (InvalidUserIdException e) {
			throw e;
		}catch (UserEntityNotFoundException e) {
			throw e;
		}catch (Exception e) {
			throw UserDeleteException.of();
		}
	}

	@Override
	public User findById(Integer userId) throws UserEntityNotFoundException, InvalidUserIdException {
		if(userId == null) throw UserEntityNotFoundException.of();
		if(userId<=0) throw InvalidUserIdException.of();
		Optional<UserEntity> user = userJpaRepository.findById(userId);
		if(!user.isPresent()) throw UserEntityNotFoundException.of();
		return userEntityMapper.toModel(user.get());
	}

	@Override
	public List<User> findAll(){
		var users = new ArrayList<User>();
		var entities = userJpaRepository.findAll();
		for(UserEntity entity: entities) {
			users.add(userEntityMapper.toModel(entity));
		}
		return users;
	}
}