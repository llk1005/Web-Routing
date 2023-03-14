package edu.sru.thangiah.webrouting.services;

import edu.sru.thangiah.webrouting.domain.User;

/**
 * Interface class for the save and findByUsername methods
 * @author Logan Kirkwood	llk1005@sru.edu
 * @since 2/7/2022
 */

public interface UserService {
	
	void save(User user);

    User findByUsername(String username);
}
