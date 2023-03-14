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



/**
 * Sets up the Shipments database
 * @author Ian Black		imb1007@sru.edu
 * @author Logan Kirkwood	llk1005@sru.edu
 * @author Fady Aziz		faa1002@sru.edu
 * @since 2/8/2022
 */

@Entity
public class Shipments {

	@Id
	@GenericGenerator(name="generate" , strategy="increment")
	@GeneratedValue(generator="generate")
	private Long id;
	
	private String client;
	
	@ManyToOne
	@JoinColumn(name = "carrier_id")
	private Carriers carrier;
	
	
	private String scac;
	
	
	private String clientMode;
	
	
	private String shipDate;
	
	
	private String freightbillNumber;
	
	
	private String paidAmount;
	
	
	private String fullFreightTerms;
	
	
	private String commodityClass;
	
	
	private String commodityPieces;
	
	
	private String commodityPaidWeight;
	
	
	private String shipperCity;
	
	
	private String shipperState;
	
	
	private String shipperZip;
	
	
	private String shipperLatitude;
	
	
	private String shipperLongitude;
	
	
	private String consigneeCity;
	
	
	private String consigneeState;
	
	
	private String consigneeZip;
	
	
	private String consigneeLatitude;
	
	
	private String consigneeLongitude;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicles vehicle;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "shipment")
	private List<Bids> bids = new ArrayList<>();
	
	/**
	 * Gets the Shipment ID
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the Shipment ID
	 * @param id ID of the shipment
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the client
	 * @return client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * Sets the client
	 * @param client Client of the shipment
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * Gets the carrier
	 * @return carrier
	 */
	public Carriers getCarrier() {
		return carrier;
	}

	/**
	 * Sets the carrier
	 * @param carrier Carrier of the shipment
	 */
	public void setCarrier(Carriers carrier) {
		this.carrier = carrier;
	}

	/**
	 * Gets the SCAC
	 * @return scac
	 */
	public String getScac() {
		return scac;
	}

	/**
	 * Sets the SCAC
	 * @param scac SCAC of the shipment
	 */
	public void setScac(String scac) {
		this.scac = scac;
	}

	/**
	 * Gets the client mode
	 * @return clientMode
	 */
	public String getClientMode() {
		return clientMode;
	}

	/**
	 * Sets the client mode
	 * @param clientMode Client mode of the shipment
	 */
	public void setClientMode(String clientMode) {
		this.clientMode = clientMode;
	}

	/**
	 * Gets the ship date
	 * @return shipDate
	 */
	public String getShipDate() {
		return shipDate;
	}

	/**
	 * Sets the ship date
	 * @param date Date of the shipment
	 */
	public void setShipDate(String date) {
		this.shipDate = date;
	}

	/**
	 * Gets the freightbill number
	 * @return freightbillNumber 
	 */
	public String getFreightbillNumber() {
		return freightbillNumber;
	}

	/**
	 * Sets the freightbill number
	 * @param freightbillNumber Freightbill number of the shipment
	 */
	public void setFreightbillNumber(String freightbillNumber) {
		this.freightbillNumber = freightbillNumber;
	}

	/**
	 * Gets the paid amount
	 * @return paidAmount
	 */
	public String getPaidAmount() {
		return paidAmount;
	}

	/**
	 * Sets the paid amount
	 * @param paidAmount Paid amount of the shipment
	 */
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * Gets the full freight terms
	 * @return fullFreightTerms
	 */
	public String getFullFreightTerms() {
		return fullFreightTerms;
	}

	/**
	 * Sets the full freight terms
	 * @param fullFreightTerms Full freight terms of the shipment
	 */
	public void setFullFreightTerms(String fullFreightTerms) {
		this.fullFreightTerms = fullFreightTerms;
	}

	/**
	 * Gets the commodity class
	 * @return commodityClass
	 */
	public String getCommodityClass() {
		return commodityClass;
	}

	/**
	 * Sets the commodity class
	 * @param commodityClass Commodity class of the shipment
	 */
	public void setCommodityClass(String commodityClass) {
		this.commodityClass = commodityClass;
	}

	/**
	 * Gets the commodity pieces
	 * @return commodityPieces
	 */
	public String getCommodityPieces() {
		return commodityPieces;
	}

	/**
	 * Sets the commodity pieces
	 * @param commodityPieces Commodity pieces of the shipment
	 */
	public void setCommodityPieces(String commodityPieces) {
		this.commodityPieces = commodityPieces;
	}

	/**
	 * Gets the commodity paid weight
	 * @return commodityPaidWeight
	 */
	public String getCommodityPaidWeight() {
		return commodityPaidWeight;
	}

	/**
	 * Sets the commodity paid weight
	 * @param commodityPaidWeight Commodity paid weight of the shipment
	 */
	public void setCommodityPaidWeight(String commodityPaidWeight) {
		this.commodityPaidWeight = commodityPaidWeight;
	}

	/**
	 * Gets the shipper city
	 * @return shipperCity
	 */
	public String getShipperCity() {
		return shipperCity;
	}

	/**
	 * Sets the shipper city
	 * @param shipperCity Shipper city of the shipment
	 */
	public void setShipperCity(String shipperCity) {
		this.shipperCity = shipperCity;
	}

	/**
	 * Gets the shipper state
	 * @return shipperState
	 */
	public String getShipperState() {
		return shipperState;
	}

	/**
	 * Sets the shipper state
	 * @param shipperState Shipper state of the shipment
	 */
	public void setShipperState(String shipperState) {
		this.shipperState = shipperState;
	}

	/**
	 * Gets the shipper zip
	 * @return shipperZip
	 */
	public String getShipperZip() {
		return shipperZip;
	}

	/**
	 * Sets the shipper zip
	 * @param shipperZip Shipper zip of the shipment
	 */
	public void setShipperZip(String shipperZip) {
		this.shipperZip = shipperZip;
	}

	/**
	 * Gets the shipper latitude
	 * @return shipperLatitude
	 */
	public String getShipperLatitude() {
		return shipperLatitude;
	}

	/**
	 * Sets the shipperLatitude
	 * @param d Shipper latitude of the shipment
	 */
	public void setShipperLatitude(String d) {
		this.shipperLatitude = d;
	}

	/**
	 * Gets the shipper longitude
	 * @return shipperLongitude
	 */
	public String getShipperLongitude() {
		return shipperLongitude;
	}

	/**
	 * Sets the shipper longitude
	 * @param shipperLongitude Shipper longitude of the shipment
	 */
	public void setShipperLongitude(String shipperLongitude) {
		this.shipperLongitude = shipperLongitude;
	}

	/**
	 * Gets the consignee city
	 * @return consigneeCity 
	 */
	public String getConsigneeCity() {
		return consigneeCity;
	}

	/**
	 * Sets the consignee city
	 * @param consigneeCity Consignee city of the shipment
	 */
	public void setConsigneeCity(String consigneeCity) {
		this.consigneeCity = consigneeCity;
	}

	/**
	 * Gets the consignee state
	 * @return consigneeState
	 */
	public String getConsigneeState() {
		return consigneeState;
	}

	/**
	 * Sets the consignee state
	 * @param consigneeState Consignee state of the shipment
	 */
	public void setConsigneeState(String consigneeState) {
		this.consigneeState = consigneeState;
	}

	/**
	 * Gets the consignee zip
	 * @return consigneeZip
	 */
	public String getConsigneeZip() {
		return consigneeZip;
	}

	/**
	 * Sets the consignee zip
	 * @param consigneeZip Consignee zip of the shipment
	 */
	public void setConsigneeZip(String consigneeZip) {
		this.consigneeZip = consigneeZip;
	}

	/**
	 * Gets the consignee latitude
	 * @return consigneeLatitude
	 */
	public String getConsigneeLatitude() {
		return consigneeLatitude;
	}

	/**
	 * Sets the consignee latitude
	 * @param consigneeLatitude Consignee latitude of the shipment
	 */
	public void setConsigneeLatitude(String consigneeLatitude) {
		this.consigneeLatitude = consigneeLatitude;
	}

	/**
	 * Gets the consignee longitude
	 * @return consigneeLongitude 
	 */ 
	public String getConsigneeLongitude() {
		return consigneeLongitude;
	}

	/**
	 * Sets the consignee longitude
	 * @param consigneeLongitude Consignee longitude of the shipment
	 */
	public void setConsigneeLongitude(String consigneeLongitude) {
		this.consigneeLongitude = consigneeLongitude;
	}

	/**
	 * Gets the vehicle
	 * @return vehicle
	 */
	public Vehicles getVehicle() {
		return vehicle;
	}

	/**
	 * Sets the vehicle
	 * @param vehicle Vehicle of the shipment
	 */
	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * Gets the user
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user
	 * @param user User of the shipment
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the bids
	 * @return bids
	 */
	public List<Bids> getBids() {
		return bids;
	}

	/**
	 * Sets the bids
	 * @param bids Bids of the shipment
	 */
	public void setBids(List<Bids> bids) {
		this.bids = bids;
	}
	
	public String toString() {
		return shipperCity + ", " + shipperState + " to " + consigneeCity + ", " + consigneeState + " created by " + user.getUsername();
	}
}
