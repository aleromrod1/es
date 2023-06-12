package api.users.es.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import api.users.es.EsApplication;
import api.users.es.domain.model.address.Address;
import api.users.es.domain.model.user.User;

@SpringBootTest(classes = EsApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
@DisplayName("User test")
@TestMethodOrder(OrderAnnotation.class)
class UserTest {
	
	//Here would go all the validations of all the fields of the domain layer if any.
	@Test
	@DisplayName("User")
	@Order(1)
	void TestUser(){
		// give
		var user = User.of(1, "Nombre", "Email@gmail.com", LocalDateTime.now(), Address.of(1, "Calle", "Estado", "Sevilla", "España", "41015"));
		// when	// then
		assertNotNull(user.getUserId());
		assertNotNull(user.getName());
		assertNotNull(user.getEmail());
		assertNotNull(user.getBirthDate());
		assertNotNull(user.getAddress());
		assertNotNull(user.getAddress().getStreet());
		assertNotNull(user.getAddress().getState());
		assertNotNull(user.getAddress().getCity());
		assertNotNull(user.getAddress().getCountry());
		assertNotNull(user.getAddress().getZip());
	}
}