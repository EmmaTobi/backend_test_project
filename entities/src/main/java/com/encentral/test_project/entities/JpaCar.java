/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.entities;

import java.io.Serializable;
import javax.persistence.FetchType;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "car")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "JpaDriver.findByAllCars", query = "SELECT c from JpaCar c"),
    @NamedQuery(name = "JpaDriver.findBySearchCarId", query = "SELECT c from JpaCar c WHERE c.carId LIKE :car_id"),
    @NamedQuery(name = "JpaDriver.findBySearchOwner", query = "SELECT c from JpaCar c WHERE c.owner LIKE :owner"),
    @NamedQuery(name = "JpaDriver.findBySearchModel", query = "SELECT c from JpaCar c WHERE c.model LIKE :model"),
    @NamedQuery(name = "JpaDriver.findBySearchLicencePlate", query = "SELECT c from JpaCar c WHERE c.licensePlate LIKE :licence_plate"),
    @NamedQuery(name = "JpaDriver.findBySearchRating", query = "SELECT c from JpaCar c WHERE c.rating LIKE :rating"),
    @NamedQuery(name = "JpaDriver.findBySearchManufacturer", query = "SELECT c from JpaCar c WHERE c.manufacturer LIKE :manufacturer"),
    @NamedQuery(name = "JpaDriver.findBySearchEngineType", query = "SELECT c from JpaCar c WHERE c.engineType LIKE :engine_type")
    
})
public class JpaCar implements Serializable {

	@Transient
	private String [] EngineType = {"GAS", "ELECTRIC", "STEAM"};
	
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "car_id", nullable = false, length = 64)
    private String carId;
    
    @Size(min = 1, max = 64)
    @Column(name = "owner", nullable = true, length = 64)
    private String owner;

    @Column(nullable = false)
    @Size(min = 1, max = 25)
    @NotNull(message = "model can not be null!")
    private String model;

    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    @Column(nullable = true, name = "licence_plate" )
    @Size(min = 1, max = 25)
    private String licensePlate;
    
    @Column(nullable = false, name = "seat_count")
    @NotNull(message = "Seat Count cannot be null!")
    private String seatCount;
    
    @Column(nullable = false, name = "convertible")
    private boolean convertible;
    
    @Column(nullable = false, name = "rating")
    @Size(min = 1, max = 25)
    @NotNull(message = "Rating can not be null!")
    private String rating;
    
    @Column(nullable = false, name = "engine_type")
    @Size(min = 1, max = 25)
    @NotNull(message = "Engine can not be null!")
    private String engineType;
    
    @Column(nullable = false, name = "manufacturer")
    @Size(min = 1, max = 25)
    @NotNull(message = "Manufacturer can not be null!")
    private String manufacturer;

    @Column(nullable = false, name = "car_already_in_use", columnDefinition = "boolean default false")
    @NotNull(message = "Car Usage status can not be null!")
    private boolean carAlreadyInUse;
    
    public boolean getCarAlreadyInUse() {
    	return this.carAlreadyInUse;
    }
    
    public void setCarAlreadyInUse(boolean carAlreadyInUse) {
    	this.carAlreadyInUse = carAlreadyInUse;
    }
    
    public String getManufacturer() {
    	return this.manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
    	this.manufacturer = manufacturer;
    }
    
    public String getCarId() {
    	return this.carId;
    }
    
    public void setCarId(String carId) {
    	this.carId = carId;
    }
    
    public String getOwner() {
    	return owner;
    }
    
    public void setOwner(String owner) {
    	this.owner = owner;
    }
    
    public String getModel() {
    	return model;
    }
    
    public void setModel(String model) {
    	this.model = model;
    }
    
    public Date getDateCreated() {
    	return dateCreated;
    }
    
    public void setDateCreated(Date date) {
    	this.dateCreated = date;
    }
    
    public Date getDateModified() {
    	return dateModified;
    }
    
    public void setDateModified(Date date) {
    	this.dateModified = date;
    }
    
    public String getLicencePlate() {
    	return licensePlate;
    }
    
    public void setLicencePlate(String licenceplate) {
    	this.licensePlate = licenceplate;
    }
    
    public String getSeatCount() {
    	return seatCount;
    }
    
    public void setSeatCount(String seatCount) {
    	this.seatCount = seatCount;
    }
    
    public boolean getConvertible() {
    	return convertible;
    }
    
    public void setConvertible(boolean convertible) {
    	this.convertible = convertible;
    }
    
    public String getRating() {
    	return rating;
    }
    
    public void setRating(String rating) {
    	this.rating = rating;
    }
    
    public String getEngineType() {
    	return engineType;
    }
    
    public void setEngineType(String engineType) {
    	this.engineType = engineType;
    }
    
    public JpaCar update(JpaCar car) {
    	this.setCarAlreadyInUse(car.getCarAlreadyInUse());
    	this.setCarId(car.getCarId());
    	this.setConvertible(car.getConvertible());
    	this.setDateCreated(car.getDateCreated());
    	this.setDateModified(car.getDateModified());
    	this.setEngineType(car.getEngineType());
    	this.setLicencePlate(car.getLicencePlate());
    	this.setManufacturer(car.getManufacturer());
    	this.setModel(car.getModel());
    	this.setOwner(car.getOwner());
    	this.setRating(car.getRating());
    	this.setSeatCount(car.getSeatCount());
    	return this;
    }
    
}
