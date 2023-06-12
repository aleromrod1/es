package api.users.es.application.service.user.use_case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.users.es.domain.model.user.UserRepository;

@Service
public class DeleteUser {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void execute(Integer userId) throws Exception {
		userRepository.delete(userId);
	}
}