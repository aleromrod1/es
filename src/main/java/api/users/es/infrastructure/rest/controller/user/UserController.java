package api.users.es.infrastructure.rest.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.users.es.infrastructure.persistence.user.UserEntity;
import api.users.es.infrastructure.persistence.user.UserJpaRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserJpaRepository userRepository;
	
	@GetMapping(value = "getusers")
	public List<UserEntity> getUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping(value = "createUsers")
	public UserEntity createUsers(@RequestBody UserEntity user) {
		return userRepository.save(user);
	}
}