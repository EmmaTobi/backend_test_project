/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.user_management.impl;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import com.encentral.test_project.entities.JpaCar;
import com.encentral.test_project.user_management.api.CarService;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.inject.Inject;
import play.db.jpa.JPAApi;

/**
 *
 * @author emmanuelAgboola
 */
public class DefaultCarService implements CarService {

    @Inject
    JPAApi jPAApi;
    
    //method to find all cars
    @Override
    public List<JpaCar> findAll() throws ResourceNotFound {
        Query carsQuery = jPAApi.em().createNamedQuery("JpaDriver.findByAllCars");
        List<JpaCar> carList = carsQuery.getResultList();
        if (carList.isEmpty()) {
            throw new ResourceNotFound("There are no cars available ");
        }
        return carList;
    }

    @Override
    public JpaCar find(String carId) throws ResourceNotFound {
        JpaCar car = jPAApi.em().find(JpaCar.class, carId);
        if (car == null) {
            throw new ResourceNotFound(String.format("Car with id %s not found", carId));
        }
        return car;
    }

    @Override
    public JpaCar create(JpaCar car) {
        car.setCarId(java.util.UUID.randomUUID().toString());
        car.setDateCreated(new Date());
        jPAApi.em().persist(car);
        return car;
    }

    @Override
    public void delete(String carId) throws ResourceNotFound {
        jPAApi.em().detach(find(carId));
    }
    
    //method to update a car information
    @Override
    public JpaCar update(JpaCar car)  throws ResourceNotFound {
        JpaCar ca = jPAApi.em().find(JpaCar.class, car.getCarId());
        JpaCar updated = ca.update(car);
        return updated;
    }
}
