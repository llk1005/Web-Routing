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
 * Sets up the Locations database
 * @author Logan Kirkwood	llk1005@sru.edu
 * @since 1/30/2022
 */

@Entity
public class Locations {
	
	@Id
	@GenericGenerator(name="generate" , strategy="increment")
	@GeneratedValue(generator="generate")
    private long id;
	
	@NonNull
	private String name;
	
	@NonNull
	private String streetAddress1;
	
	private String streetAddress2;
	
	@NonNull
	private String city;
	
	@NonNull
	private String state;
	
	@NonNull
	private String zip;
	
	private String latitude;
	
	private String longitude;
	
	@ManyToOne
	@JoinColumn(name = "carrier_id")
	private Carriers carrier;
	
	@NonNull
	private String locationType;
	
	@OneToMany(mappedBy = "location")
	private List<Vehicles> vehicles = new ArrayList<>();

	/**
	 * Gets the Locations ID
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the Locations ID
	 * @param id ID of the location
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the Location Name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Location Name
	 * @param name Name of the location
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the Location Street Adress 1
	 * @return streetAddress1
	 */
	public String getStreetAddress1() {
		return streetAddress1;
	}

	/**
	 * Sets the Location Street Address 1
	 * @param streetAddress1 Street address 1 of the location
	 */
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	/**
	 * Gets the Location Street Address 2
	 * @return streetAddress2
	 */
	public String getStreetAddress2() {
		return streetAddress2;
	}

	/**
	 * Sets the Location Street Address 2
	 * @param streetAddress2 Street address 2 of the location
	 */
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	/**
	 * Gets the Location City
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the Location City
	 * @param city City of the location
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the Location State
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the Location State
	 * @param state State of the location
	 */ 
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the Location Zip
	 * @return zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Sets the Location Zip
	 * @param zip Zip code of the location
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Gets the Location Latitude
	 * @return latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * Sets the Location Latitude 
	 * @param latitude Latitude coordinates of the location
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the Location Longitude
	 * @return longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * Sets the Location Longitude
	 * @param longitude Longitude coordinates of the location
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	/**
	 * Gets the Location Carrier
	 * @return carrier
	 */
	public Carriers getCarrier() {
		return carrier;
	}

	/**
	 * Sets the Location Carrier
	 * @param carrier Carrier of the location
	 */
	public void setCarrier(Carriers carrier) {
		this.carrier = carrier;
	}

	/**
	 * Gets the Location Type
	 * @return locationType
	 */
	public String getLocationType() {
		return locationType;
	}
	
	/**
	 * Sets the Location Type
	 * @param locationType Location type of the location
	 */
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	
	/**
	 * Gets the Vehicles List
	 * @return vehicles
	 */
	public List<Vehicles> getVehicles() {
		return vehicles;
	}

	/**
	 * Sets the Vehicles List
	 * @param vehicles Vehicles of the location
	 */
	public void setVehicles(List<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * Prints out the name of the instance of the location
	 * @return location name
	 */
	public String toString() {
		return this.getName();
	}
}
