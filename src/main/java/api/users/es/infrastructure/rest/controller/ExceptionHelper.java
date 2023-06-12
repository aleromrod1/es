package api.users.es.infrastructure.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import api.users.es.domain.model.user.exception.InvalidUserIdException;
import api.users.es.domain.model.user.exception.UserCreationException;
import api.users.es.domain.model.user.exception.UserDeleteException;
import api.users.es.domain.model.user.exception.UserEntityNotFoundException;
import api.users.es.domain.model.user.exception.UserIdentifierNotAllowedException;
import api.users.es.domain.model.user.exception.UserUpdateException;
import api.users.es.infrastructure.rest.controller.user.UserController;

@ControllerAdvice(assignableTypes = {UserController.class})
public class ExceptionHelper {

	private static final Logger log = LoggerFactory.getLogger(ExceptionHelper.class);
	
	@ExceptionHandler(value = { InvalidUserIdException.class })
	public ResponseEntity<Object> handleInvalidUserIdException(InvalidUserIdException ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { UserIdentifierNotAllowedException.class })
	public ResponseEntity<Object> handleUserIdentifierNotAllowedException(UserIdentifierNotAllowedException ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { UserEntityNotFoundException.class })
	public ResponseEntity<Object> handleUserEntityNotFoundException(UserEntityNotFoundException ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = { UserCreationException.class })
	public ResponseEntity<Object> handleUserCreationException(UserCreationException ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>("An internal error was detected in the creation", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { UserUpdateException.class })
	public ResponseEntity<Object> handleUserUpdateException(UserUpdateException ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>("An internal error has been detected in the modification.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { UserDeleteException.class })
	public ResponseEntity<Object> handleUserDeleteException(UserDeleteException ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>("An internal error was detected in the deletion.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { IllegalArgumentException.class })
	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleException(Exception ex) {
		log.error(ex.getMessage(), ex);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}