package api.users.es.domain.model.user.exception;

public class UserUpdateException extends Exception {

	private static final long serialVersionUID = 1L;

	private UserUpdateException() {}
	
	public static UserUpdateException of() {
        return new UserUpdateException();
    }
	
	@Override
	public String getMessage() {
		return "There was an error modifying the user";
	}
}
