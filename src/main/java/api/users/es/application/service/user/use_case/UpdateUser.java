package api.users.es.application.service.user.use_case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.users.es.application.service.user.UserDTO;
import api.users.es.application.service.user.UserMapper;
import api.users.es.domain.model.user.User;
import api.users.es.domain.model.user.UserRepository;

@Service
public class UpdateUser {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	public UserDTO execute(Integer userId, UserDTO dto) throws Exception {
		User userFound = userRepository.findById(userId);
		User user = userMapper.toModel(dto);
		User changedUser = userFound.applyChanges(user);
		User updatedUser = userRepository.update(changedUser);
		return userMapper.toDTO(updatedUser);
	}
}