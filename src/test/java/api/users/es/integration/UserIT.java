package api.users.es.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import api.users.es.EsApplication;
import api.users.es.application.service.address.AddressDTO;
import api.users.es.application.service.user.UserDTO;
import api.users.es.application.service.user.use_case.CreateUser;
import api.users.es.application.service.user.use_case.DeleteUser;
import api.users.es.application.service.user.use_case.GetUser;
import api.users.es.application.service.user.use_case.GetUsers;
import api.users.es.application.service.user.use_case.UpdateUser;
import api.users.es.domain.model.user.exception.InvalidUserIdException;
import api.users.es.domain.model.user.exception.UserEntityNotFoundException;

@SpringBootTest(classes = EsApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
@DisplayName("User test")
@TestMethodOrder(OrderAnnotation.class)
class UserIT {
	
	@Autowired
	private GetUsers getUsers;
	
	@Autowired
	private CreateUser createUser;
	
	@Autowired
	private GetUser getUser;
	
	@Autowired
	private UpdateUser updateUser;
	
	@Autowired
	private DeleteUser deleteUser;
	
	@Test
	@DisplayName("Create User")
	@Order(1)
	void TestCreateUser() throws Exception{
		// give
		var userDTO = UserDTO.of(1, "Nombre", "Email@gmail.com", LocalDateTime.now(), AddressDTO.of(1, "Calle", "Estado", "Sevilla", "España", "41015"));
		// when
		var userDTOSaved = createUser.execute(userDTO);
		// then
		assertNotNull(userDTOSaved.getId());
	}
	
	@Test
	@DisplayName("Get User")
	@Order(2)
	void TestGetUser() throws Exception {
		// give	// when
		UserDTO user = getUser.execute(1);
		// then
		assertNotNull(user.getId());
	}
	
	@Test
	@DisplayName("Get All Users")
	@Order(3)
	void TestGetUserList(){
		// give	// when
		List<UserDTO> users = getUsers.execute();
		// then
		assertNotEquals(new ArrayList<>(), users);
	}	
	
	@Test
	@DisplayName("Update User")
	@Order(4)
	void TestUpdateUser() throws Exception{
		// give
		var userDTO = UserDTO.of(1, "Nombre", "Email@gmail.com", LocalDateTime.now(), AddressDTO.of(1, "Calle", "Estado", "Málaga", "España", "41015"));
		// when
		var userDTOSaved = updateUser.execute(1,userDTO);
		// then
		assertEquals("Málaga", userDTOSaved.getAddress().getCity());
	}
	
	@Test
	@DisplayName("Delete User")
	@Order(5)
	void TestDeleteUser() throws Exception{
		// give	// when	// then
		deleteUser.execute(1);
		assertThrows(UserEntityNotFoundException.class, () -> getUser.execute(1));
	}
	
	@Test
	@DisplayName("Get a user that does not exist")
	@Order(6)
	void TestGetAUserThatDoesNotExist() throws Exception{
		// give	// when	// then
		assertThrows(UserEntityNotFoundException.class, () -> getUser.execute(1));
	}
	
	@Test
	@DisplayName("Get a user with id less than or equal to 0.")
	@Order(7)
	void TestGetAUserWithIdLessThanOrEqualTo0() throws Exception{
		// give	// when	// then
		assertThrows(InvalidUserIdException.class, () -> getUser.execute(0));
	}
	
	@Test
	@DisplayName("Update a user that does not exist")
	@Order(8)
	void TestUpdateAUserThatDoesNotExist() throws Exception{
		// give
		var userDTO = UserDTO.of(1, "Nombre", "Email@gmail.com", LocalDateTime.now(), AddressDTO.of(1, "Calle", "Estado", "Málaga", "España", "41015"));
		// when	// then
		assertThrows(UserEntityNotFoundException.class, () -> updateUser.execute(1, userDTO));
	}
	
	@Test
	@DisplayName("Update a user with id less than or equal to 0.")
	@Order(9)
	void TestUpdateAUserWithIdLessThanOrEqualTo0() throws Exception{
		// give	
		var userDTO = UserDTO.of(1, "Nombre", "Email@gmail.com", LocalDateTime.now(), AddressDTO.of(1, "Calle", "Estado", "Málaga", "España", "41015"));
		// when	// then
		assertThrows(InvalidUserIdException.class, () -> updateUser.execute(0, userDTO));
	}
	
	@Test
	@DisplayName("Delete a user that does not exist")
	@Order(10)
	void TestDeleteAUserThatDoesNotExist() throws Exception{
		// give	// when	// then
		assertThrows(UserEntityNotFoundException.class, () -> deleteUser.execute(1));
	}
	
	@Test
	@DisplayName("Delete a user with id less than or equal to 0.")
	@Order(11)
	void TestDeleteAUserWithIdLessThanOrEqualTo0() throws Exception{
		// give	// when	// then
		assertThrows(InvalidUserIdException.class, () -> deleteUser.execute(0));
	}
}