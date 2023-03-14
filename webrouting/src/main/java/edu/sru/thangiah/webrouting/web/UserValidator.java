package edu.sru.thangiah.webrouting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.sru.thangiah.webrouting.domain.User;
import edu.sru.thangiah.webrouting.services.UserService;

/**
 * Used to validate a user by checking their username and password.
 * @author Logan Kirkwood	llk1005@sru.edu
 * @since 2/7/2022
 */

public class UserValidator implements Validator {
	
	@Autowired
    private UserService userService;

	/**
	 * Checks if the user class is a valid class.
	 */
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    /**
     * Checks the username and the password to see if the length is valid. <br>
     * Username must be between 6 and 32 characters in length. <br>
     * Username has not been taken. <br>
     * Password must be between 8 and 32 characters in length.
     * @param o Object being validated
     * @param errors Used to store if there are errors
     */
    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty", "No username entered!");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username", "Username must be between 6 and 32 characters!");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username", "Username already taken!");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty", "No password entered!");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password", "Password must be between 8 and 32 characters!");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty", "No email entered!");
    }
    
    /**
     * Checks the username and the password to see if the length is valid. <br>
     * Username must be between 6 and 32 characters in length. <br>
     * Password must be between 8 and 32 characters in length.
     * @param o Object being validated
     * @param errors Used to store if there are errors
     */
    public void validateUpdate(Object o, Errors errors) {
    	User user = (User) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty", "No username entered!");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username", "Username must be between 6 and 32 characters!");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty", "No password entered!");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password", "Password must be between 8 and 32 characters!");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty", "No email entered!");
    }
}
