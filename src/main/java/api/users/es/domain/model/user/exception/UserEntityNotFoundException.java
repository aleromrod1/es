package api.users.es.domain.model.user.exception;

public class UserEntityNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private UserEntityNotFoundException() {}
	
	public static UserEntityNotFoundException of() {
        return new UserEntityNotFoundException();
    }
	
	@Override
	public String getMessage() {
		return "User not found";
	}
}
