package api.users.es.infrastructure.persistence.user;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private UUID id;

	@Column(name = "Name")
	private String name;
}
