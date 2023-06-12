package api.users.es.domain.model.user.exception;

public class UserCreationException extends Exception {

	private static final long serialVersionUID = 1L;

	private UserCreationException() {}
	
	public static UserCreationException of() {
        return new UserCreationException();
    }
	
	@Override
	public String getMessage() {
		return "There was an error creating the user";
	}
}
