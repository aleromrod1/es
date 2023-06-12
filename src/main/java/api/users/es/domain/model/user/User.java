package api.users.es.domain.model.user;

import java.time.LocalDateTime;

import api.users.es.domain.model.address.Address;

public class User {
	
	private Integer userId;
	private String name;
	private String email;
	private LocalDateTime birthDate;
	private Address address;
	
	private User(Integer userId, String name, String email, LocalDateTime birthDate, Address address) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.address = address;
	}

	public static User of(Integer userId, String name, String email, LocalDateTime birthDate, Address address) {
		return new User(userId, name, email, birthDate, address);
	}
	
	public User applyChanges(User model) {
		return User.of(model.getUserId(), model.getName(), model.getEmail(), model.getBirthDate(), model.getAddress());
	}
	
	public Integer getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public Address getAddress() {
		return address;
	}
}