package api.users.es.domain.model.address;

public class Address {
	
	private Integer addressId;
	private String street;
	private String state;
	private String city;
	private String country;
	private String zip;
	
	private Address(Integer addressId, String street, String state, String city, String country, String zip) {
		this.addressId = addressId;
		this.street = street;
		this.state = state;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}

	public static Address of(Integer addressId, String street, String state, String city, String country, String zip) {
		return new Address(addressId, street, state, city, country, zip);
	}

	public Integer getAddressId() {
		return addressId;
	}
	
	public String getStreet() {
		return street;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getZip() {
		return zip;
	}
}