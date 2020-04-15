/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.user_management.api;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import com.encentral.test_project.entities.JpaCar;
import java.util.List;

/**
 *
 * @author emmanuelAgboola
 */
public interface CarService {
    
    JpaCar find(String carId) throws ResourceNotFound;

    JpaCar create(JpaCar driverDO) ;

    void delete(String carId) throws ResourceNotFound;
    
    JpaCar update(JpaCar car)  throws ResourceNotFound;
    
    List<JpaCar> findAll() throws ResourceNotFound;

}
