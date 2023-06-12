package api.users.es.infrastructure.persistence.user;

import java.io.Serializable;
import java.time.LocalDateTime;

import api.users.es.infrastructure.persistence.address.AddressEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -3082774941152513894L;

	public static UserEntity of() {
		return new UserEntity();
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthDate")
	private LocalDateTime birthDate;

	@Column(name = "address_id")
	private AddressEntity address;
}
