package api.users.es.infrastructure.persistence.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.users.es.domain.model.user.User;
import api.users.es.infrastructure.persistence.address.AddressEntityMapper;

@Component
public class UserEntityMapper {

	@Autowired
	private AddressEntityMapper addressEntityMapper;
	
	public User toModel(UserEntity entity) {
		return User.of(entity.getId(), entity.getName(), entity.getEmail(), entity.getBirthDate(), addressEntityMapper.toModel(entity.getAddress()));
	}
	
	public UserEntity toEntity(User model) {
		UserEntity entity = UserEntity.of();
		entity.setId(model.getUserId());
		entity.setName(model.getName());
		entity.setEmail(model.getEmail());
		entity.setBirthDate(model.getBirthDate());
		entity.setAddress(addressEntityMapper.toEntity(model.getAddress()));
		return entity;
	}
}