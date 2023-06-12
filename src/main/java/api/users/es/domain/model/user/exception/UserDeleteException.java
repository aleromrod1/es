package api.users.es.domain.model.user.exception;

public class UserDeleteException extends Exception {

	private static final long serialVersionUID = 1L;

	private UserDeleteException() {}
	
	public static UserDeleteException of() {
        return new UserDeleteException();
    }
	
	@Override
	public String getMessage() {
		return "There was an error deleting the user";
	}
}
