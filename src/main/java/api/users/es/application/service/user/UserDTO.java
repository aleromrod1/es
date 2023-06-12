package api.users.es.application.service.user;

import java.time.LocalDateTime;

import api.users.es.application.service.DTO;
import api.users.es.application.service.address.AddressDTO;
import lombok.Data;

@Data
public class UserDTO extends DTO {

	private UserDTO(Integer id, String name, String email, LocalDateTime birthDate, AddressDTO address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.address = address;
	}
	
	public static UserDTO of(Integer id, String name, String email, LocalDateTime birthDate, AddressDTO address) {
		return new UserDTO(id, name, email, birthDate, address);
	}

	private String name;
	
	private String email;

	private LocalDateTime birthDate;

	private AddressDTO address;
}