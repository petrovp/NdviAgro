package ndvi.agro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ndvi.agro.persistance.datamodel.User;
import ndvi.agro.persistance.repostories.UserRepository;
import ndvi.agro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByUsername(String username) {
		
		User user = userRepository.findByUsername(username);
		
		return user;
	}

	
}
