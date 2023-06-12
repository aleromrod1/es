package api.users.es.infrastructure.rest.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.users.es.application.service.user.UserDTO;
import api.users.es.application.service.user.use_case.CreateUser;
import api.users.es.application.service.user.use_case.DeleteUser;
import api.users.es.application.service.user.use_case.GetUser;
import api.users.es.application.service.user.use_case.GetUsers;
import api.users.es.application.service.user.use_case.UpdateUser;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	GetUsers getUsers;
	
	@Autowired
	CreateUser createUser;
	
	@Autowired
	GetUser getUser;
	
	@Autowired
	UpdateUser updateUser;
	
	@Autowired
	DeleteUser deleteUser;
	
	@GetMapping(value = "getusers")
	public List<UserDTO> getUsers() {
		return getUsers.execute();
	}
	
	@PostMapping(value = "createUsers")
	public UserDTO createUsers(@RequestBody UserDTO user) throws Exception {
		return createUser.execute(user);
	}
	
	@GetMapping(value = "getusersById")
	public UserDTO getUsersById(@RequestParam Integer userId) throws Exception {
		return getUser.execute(userId);
	}
	
	@PutMapping(value = "updateUsersById")
	public UserDTO updateUsers(@RequestParam Integer userId, @RequestBody UserDTO user) throws Exception {
		return updateUser.execute(userId, user);
	}
	
	@DeleteMapping(value = "deleteUsersById")
	public void deleteUsers(@RequestParam Integer userId) throws Exception {
		deleteUser.execute(userId);
	}
}