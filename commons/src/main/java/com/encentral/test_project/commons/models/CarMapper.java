/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.commons.models;

import com.encentral.test_project.entities.JpaCar;

/**
 *
 * @author emmanuelAgboola
 */
public class CarMapper {

    public static CarDTO jpaCarToCarDTO(JpaCar jpaCar) {
        CarDTO dTO = new CarDTO();
        dTO.setDateCreated(jpaCar.getDateCreated());
        dTO.setOwner(jpaCar.getOwner());
        dTO.setDateModified(jpaCar.getDateModified());
        dTO.setCarId(jpaCar.getCarId());
        dTO.setModel(jpaCar.getModel());
        dTO.setLicencePlate(jpaCar.getLicencePlate());
        dTO.setSeatCount(jpaCar.getSeatCount());
        dTO.setConvertible(jpaCar.getConvertible());
        dTO.setRating(jpaCar.getRating());
        dTO.setManufacturer(jpaCar.getManufacturer());
        dTO.setCarAlreadyInUse(jpaCar.getCarAlreadyInUse());
        dTO.setEngineType(jpaCar.getEngineType());
        return dTO;
    }

    public static JpaCar carDTotoJpaCar(CarDTO dTO) {
        JpaCar jpaCar = new JpaCar();
        jpaCar.setDateCreated(dTO.getDateCreated());
        jpaCar.setOwner(dTO.getOwner());
        jpaCar.setDateModified(dTO.getDateModified());
        jpaCar.setCarId(dTO.getCarId());
        jpaCar.setModel(dTO.getModel());
        jpaCar.setLicencePlate(dTO.getLicencePlate());
        jpaCar.setSeatCount(dTO.getSeatCount());
        jpaCar.setConvertible(dTO.getConvertible());
        jpaCar.setRating(dTO.getRating());
        jpaCar.setManufacturer(dTO.getManufacturer());
        jpaCar.setCarAlreadyInUse(dTO.getCarAlreadyInUse());
        jpaCar.setEngineType(dTO.getEngineType());
        return jpaCar;
    }
}
