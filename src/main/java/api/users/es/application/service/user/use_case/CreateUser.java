package api.users.es.application.service.user.use_case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.users.es.application.service.user.UserDTO;
import api.users.es.application.service.user.UserMapper;
import api.users.es.domain.model.user.User;
import api.users.es.domain.model.user.UserRepository;

@Service
public class CreateUser {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	public UserDTO execute(UserDTO userDTO) throws Exception {
		User user = userRepository.create(userMapper.toModel(userDTO));
		return userMapper.toDTO(user);
	}
}