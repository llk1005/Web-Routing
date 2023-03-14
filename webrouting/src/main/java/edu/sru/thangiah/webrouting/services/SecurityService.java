package edu.sru.thangiah.webrouting.services;

/**
 * Sets up the isAuthenticated and autoLogin methods
 * @author Logan Kirkwood	llk1005@sru.edu
 * @since 2/7/2022
 */

public interface SecurityService {
	
	boolean isAuthenticated();
	
    void autoLogin(String username, String password);
}
