package api.users.es.application.service.address;

import api.users.es.application.service.DTO;
import lombok.Data;

@Data
public class AddressDTO extends DTO {

	private AddressDTO(Integer id, String street, String state, String city, String country, String zip) {
		this.id = id;
		this.street = street;
		this.state = state;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}
	
	public static AddressDTO of(Integer id, String street, String state, String city, String country, String zip) {
		return new AddressDTO(id, street, state, city, country, zip);
	}

	private String street;
	
	private String state;

	private String city;

	private String country;

	private String zip;
}