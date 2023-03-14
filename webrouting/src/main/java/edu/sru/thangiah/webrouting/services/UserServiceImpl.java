package edu.sru.thangiah.webrouting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.sru.thangiah.webrouting.domain.User;
import edu.sru.thangiah.webrouting.repository.UserRepository;

/*
 * UserServiceImpl
 * 
 * Created 2/7/2022 by Logan Kirkwood
 * 
 * Description: Implements the UserService Interface
 * Used as a service for Spring Security
 */

/**
 * Implements the UserService Interface <br>
 * Used as a service for Spring Security
 * @author Logan Kirkwood	llk1005@sru.edu
 * @since 2/7/2022
 */

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
    /**
     * Saves the user in the userRepository and encodes the password <br>
     * The password is encrypted using the BCryptPasswordEncoder
     * @param user User being saved
     */
	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	    userRepository.save(user);
	}
	
	/**
	 * Finds the username in the user repsitory and returns that user
	 * @param username being found
	 * @return User
	 */
	@Override
	public User findByUsername(String username) {
	    return userRepository.findByUsername(username);
	}
}
