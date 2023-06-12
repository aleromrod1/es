package api.users.es.application.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.users.es.application.service.address.AddressMapper;
import api.users.es.domain.model.user.User;

@Component
public class UserMapper {

	@Autowired
	private AddressMapper addressMapper;
	
	public UserDTO toDTO(User model) {
		return UserDTO.of(model.getUserId(), model.getName(), model.getEmail(), model.getBirthDate(), addressMapper.toDTO(model.getAddress()));
	}

	public User toModel(UserDTO dto) {
		return User.of(dto.getId(), dto.getName(), dto.getEmail(), dto.getBirthDate(), addressMapper.toModel(dto.getAddress()));
	}

	public List<UserDTO> toDTOList(List<User> users) {
		var dtos = new ArrayList<UserDTO>();
		if(users != null) {
			for(User model: users) {
				dtos.add(toDTO(model));
			}
		}
        return dtos;
	}
}