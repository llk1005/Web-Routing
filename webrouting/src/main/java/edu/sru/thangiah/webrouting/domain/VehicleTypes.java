package edu.sru.thangiah.webrouting.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

/**
 * Sets up the Vehicles Types database
 * @author Logan Kirkwood	llk1005@sru.edu
 * @since 1/30/2022
 */

@Entity
public class VehicleTypes {
	
	@Id
	@GenericGenerator(name="generate" , strategy="increment")
	@GeneratedValue(generator="generate")
    private long id;
	
	@NonNull
	private String type;
	
	private String subType;
	
	private String description;
	
	@NonNull
	private String make;
	
	@NonNull
	private String model;
	
	@NonNull
	private int minimumWeight;
	
	@NonNull
	private int maximumWeight;
	
	private String capacity;
	
	@NonNull
	private int maximumRange;
	
	private String restrictions;
	
	@NonNull
	private int height;
	
	@NonNull
	private int emptyWeight;
	
	@NonNull
	private int length;
	
	private int minimumCubicWeight;
	
	private int maximumCubicWeight;
	
	@OneToMany(mappedBy = "vehicleType")
	private List<Vehicles> vehicles = new ArrayList<>();

	/**
	 * Gets the Vehicle Type ID
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the Vehicle Type ID
	 * @param id ID of the vehicle type
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the Vehicle Type
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the Vehicle Type
	 * @param type Type of vehicle type
	 */ 
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the Vehicle Sub Type
	 * @return subType
	 */
	public String getSubType() {
		return subType;
	}

	/**
	 * Sets the Vehicle Sub Type
	 * @param subType Sub type of vehicle type
	 */
	public void setSubType(String subType) {
		this.subType = subType;
	}

	/**
	 * Gets the Vehicle Type Description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the Vehicle Type Description
	 * @param description Description of vehicle type
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the Vehicle Type Make
	 * @return make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * Sets the Vehicle Type Make
	 * @param make Make of vehicle type
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * Gets the Vehicle Type Model
	 * @return model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the Vehicle Type Model
	 * @param model Model of vehicle type
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets the Vehicle Type Minimum Weight
	 * @return minimumWeight
	 */
	public int getMinimumWeight() {
		return minimumWeight;
	}

	/**
	 * Sets the Vehicle Type Minimum Weight
	 * @param minimumWeight Minimum weight of vehicle type
	 */
	public void setMinimumWeight(int minimumWeight) {
		this.minimumWeight = minimumWeight;
	}

	/**
	 * Gets the Vehicle Type Maximum Weight
	 * @return maximumWeight
	 */
	public int getMaximumWeight() {
		return maximumWeight;
	}

	/**
	 * Sets the Vehicle Type Maximum Weight
	 * @param maximumWeight Maximum weight of vehicle type
	 */
	public void setMaximumWeight(int maximumWeight) {
		this.maximumWeight = maximumWeight;
	}

	/**
	 * Gets the Vehicle Type Capacity 
	 * @return capacity
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * Sets the Vehicle Type Capcity
	 * @param capacity Capacity of vehicle type
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	/**
	 * Gets the Vehicle Type Maximum Range
	 * @return maximumRange
	 */
	public int getMaximumRange() {
		return maximumRange;
	}

	/**
	 * Sets the Vehicle Type Maximum Range
	 * @param maximumRange Maximum range of vehicle type
	 */
	public void setMaximumRange(int maximumRange) {
		this.maximumRange = maximumRange;
	}

	/**
	 * Gets the Vehicle Type Restrictions
	 * @return restrictions
	 */
	public String getRestrictions() {
		return restrictions;
	}

	/**
	 * Sets the Vehicle Type Restrictions
	 * @param restrictions Restrictions of vehicle type
	 */
	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}

	/**
	 * Gets the Vehicle Type Height
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the Vehicle Type Height
	 * @param height Height of vehicle type
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the Vehicle Type Empty Weight
	 * @return emptyWeight
	 */
	public int getEmptyWeight() {
		return emptyWeight;
	}

	/**
	 * Sets the Vehicle Type Empty Weight
	 * @param emptyWeight Empty weight of vehicle type
	 */
	public void setEmptyWeight(int emptyWeight) {
		this.emptyWeight = emptyWeight;
	}

	/**
	 * Get the Vehicle Type Length
	 * @return length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Set the Vehicle Type Length
	 * @param length Length of vehicle type
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Gets the Vehicle Type Minimum Cubic Weight
	 * @return minimumCubicWeight
	 */
	public int getMinimumCubicWeight() {
		return minimumCubicWeight;
	}

	/**
	 * Sets the Vehicle Type Minimum Cubic Weight
	 * @param minimumCubicWeight Minimum cubic weight of vehicle type
	 */
	public void setMinimumCubicWeight(int minimumCubicWeight) {
		this.minimumCubicWeight = minimumCubicWeight;
	}

	/**
	 * Gets the Vehicle Type Maximum Cubic Weight
	 * @return maximumCubicWeight
	 */
	public int getMaximumCubicWeight() {
		return maximumCubicWeight;
	}

	/**
	 * Sets the Vehicle Type Maximum Cubic Weight
	 * @param maximumCubicWeight Maximum weight of vehicle type
	 */
	public void setMaximumCubicWeight(int maximumCubicWeight) {
		this.maximumCubicWeight = maximumCubicWeight;
	}
	
	/**
	 * Gets the Vehicle Type Vehicles
	 * @return vehicles
	 */
	public List<Vehicles> getVehicles() {
		return vehicles;
	}

	/**
	 * Sets the Vehicle Type Vehicles
	 * @param vehicles Vehicles of the vehicle type
	 */
	public void setVehicles(List<Vehicles> vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * Prints out the make, model, and type of the instance of the vehicle type
	 * @return make, model, and type
	 */
	public String toString() {
		return this.getMake() + " " + this.getModel() + " - " + this.getType();
	}
	
}
