/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.user_management.api;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import java.util.List;
import com.encentral.test_project.entities.JpaDriver;

/**
 *
 * @author James Akinniranye || emmanuelAgboola
 */
public interface DriverService {
    
    JpaDriver find(String driverId) throws ResourceNotFound;
    
    List<JpaDriver> findAll() throws ResourceNotFound;

    JpaDriver create(JpaDriver driverDO);

    void delete(String driverId) throws ResourceNotFound;
    
    JpaDriver update(JpaDriver driver)  throws ResourceNotFound;
    
    List<JpaDriver> findBySearchString(String query, String operation) throws ResourceNotFound;


}
