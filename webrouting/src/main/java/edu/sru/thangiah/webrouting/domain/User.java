package edu.sru.thangiah.webrouting.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

/**
 * Sets up the Shipments database
 * @author Logan Kirkwood	llk1005@sru.edu
 * @since 1/30/2022
 */

@Entity
public class User {

	@Id
	@GenericGenerator(name="generate" , strategy="increment")
	@GeneratedValue(generator="generate")
    private long id;
    
    @NonNull
    private String username;
    
    @NonNull
    private String password;
    
    @NonNull
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    
    @ManyToOne
    @JoinColumn(name = "carrier_id")
    private Carriers carrier;
    
    @OneToMany(mappedBy = "user")
	private List<Shipments> shipments = new ArrayList<>();
    
    /**
     * Gets the User ID
     * @return id
     */
	public long getId() {
		return id;
	}

	/**
	 * Sets the User ID
	 * @param id ID of the user
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the User Username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the User Username
	 * @param username Username of the user
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the User Password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the User Password
	 * @param password Password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the User Email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the User Email
	 * @param email Email address of the user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the User Role
	 * @return role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Set the User Role
	 * @param role Role of the user
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Gets the User Carrier
	 * @return carrier
	 */
	public Carriers getCarrier() {
		return carrier;
	}

	/**
	 * Sets the User Carrier
	 * @param carrier Carrier of the user
	 */
	public void setCarrier(Carriers carrier) {
		this.carrier = carrier;
	}

	/**
	 * Gets the User Shipments
	 * @return shipments
	 */
	public List<Shipments> getShipments() {
		return shipments;
	}

	/**
	 * Sets the User Shipments
	 * @param shipments Shipments of the user
	 */
	public void setShipments(List<Shipments> shipments) {
		this.shipments = shipments;
	}

	/**
	 * Prints out the username of the instance of the user
	 * @return username
	 */
	public String toString() {
		return this.getUsername();
	}
}
