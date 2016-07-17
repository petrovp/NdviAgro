package ndvi.agro.service;

import ndvi.agro.persistance.datamodel.User;

public interface UserService {

	User findByUsername(String userName);
	
}
