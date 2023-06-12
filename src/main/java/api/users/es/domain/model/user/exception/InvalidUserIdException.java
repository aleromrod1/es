package api.users.es.domain.model.user.exception;

public class InvalidUserIdException extends Exception {

	private static final long serialVersionUID = 1L;

	private InvalidUserIdException() {}
	
	public static InvalidUserIdException of() {
        return new InvalidUserIdException();
    }
	
	@Override
	public String getMessage() {
		return "Invalid user id";
	}
}
