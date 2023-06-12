package api.users.es.domain.model.user.exception;

public class UserIdentifierNotAllowedException extends Exception {

	private static final long serialVersionUID = 1L;

	private UserIdentifierNotAllowedException() {}
	
	public static UserIdentifierNotAllowedException of() {
        return new UserIdentifierNotAllowedException();
    }
	
	@Override
	public String getMessage() {
		return "Invalid input";
	}
}
