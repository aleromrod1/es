package api.users.es.application.service.user.use_case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.users.es.application.service.user.UserDTO;
import api.users.es.application.service.user.UserMapper;
import api.users.es.domain.model.user.User;
import api.users.es.domain.model.user.UserRepository;

@Service
public class GetUser {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	public UserDTO execute(Integer userId) throws Exception {
		User user = userRepository.findById(userId);
		return userMapper.toDTO(user);
	}
}