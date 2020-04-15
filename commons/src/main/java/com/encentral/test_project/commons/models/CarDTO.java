package com.encentral.test_project.commons.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.encentral.test_project.entities.JpaDriver;
import com.encentral.test_project.entities.EngineType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {

    private String carId;

    @Size(min = 1, max = 25)
    @NotNull(message = "model can not be null!")
    private String model;

    private Date dateCreated;
    private Date dateModified;

    @Size(min = 1, max = 25)
    @NotNull(message = "Licence cannot be null!")
    private String licensePlate;
    
    @Size(min = 1, max = 25)
    @NotNull(message = "Seat Count cannot be null!")
    private String seatCount;
    
    @NotNull(message = "Convertible specification cannot be null!")
    private boolean convertible;
    
    @Size(min = 1, max = 25)
    @NotNull(message = "Rating can not be null!")
    private String rating;
    
    private String owner;
    
    @Size(min = 1, max = 25)
    @NotNull(message = "EngineType can not be null!")
    private String engineType;
    
    @Size(min = 1, max = 25)
    @NotNull(message = "Manufacturer can not be null!")
    private String manufacturer;

    @NotNull(message = "Car state can not be null!")
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

}
