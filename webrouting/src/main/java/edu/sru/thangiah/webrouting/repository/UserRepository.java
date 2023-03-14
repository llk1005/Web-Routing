package edu.sru.thangiah.webrouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.sru.thangiah.webrouting.domain.User;

/**
 * Sets the Users Repository using the JpaRepository
 * @author Logan Kirkwood	llk1005@sru.edu
 * @since 1/30/2022
 */

public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * Sets the findByUsername method
	 * @param username Username being found
	 */
	User findByUsername(String username);
}
