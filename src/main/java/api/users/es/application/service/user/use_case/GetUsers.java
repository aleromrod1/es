package api.users.es.application.service.user.use_case;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.users.es.application.service.user.UserDTO;
import api.users.es.application.service.user.UserMapper;
import api.users.es.domain.model.user.User;
import api.users.es.domain.model.user.UserRepository;

@Service
public class GetUsers {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	public List<UserDTO> execute() {
		List<User> users =  userRepository.findAll();
		return userMapper.toDTOList(users);
	}
}