/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.user_management.impl;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import com.encentral.test_project.entities.JpaDriver;
import com.encentral.test_project.entities.JpaCar;
import com.encentral.test_project.user_management.api.DriverService;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.Date;
import javax.inject.Inject;
import javax.persistence.Query;
import play.db.jpa.JPAApi;

/**
 *
 * @author James Akinniranye
 */
public class DefaultDriverService implements DriverService {

    @Inject
    JPAApi jPAApi;
    
    //Method returns all the drivers in the repository
    @Override
    public List<JpaDriver> findAll() throws ResourceNotFound {
        Query driversQuery = jPAApi.em().createNamedQuery("JpaDriver.findAll");
        List<JpaDriver> driversList = driversQuery.getResultList();
        if (driversList.isEmpty()) {
            throw new ResourceNotFound("There are no drivers available ");
        }
        return driversList;
    }
    
    //method to update a driver information
    @Override
    public JpaDriver update(JpaDriver driver)  throws ResourceNotFound {
    	JpaDriver driverD = driver;  
        jPAApi.em().persist(driverD);
        return driverD;
    }

    @Override
    public JpaDriver find(String driverId) throws ResourceNotFound {
        JpaDriver driver = jPAApi.em().find(JpaDriver.class, driverId);
        updateIndexes();
        if (driver == null) {
            throw new ResourceNotFound(String.format("Driver with id %s not found", driverId));
        }
        return driver;
    }

    @Override
    public JpaDriver create(JpaDriver driverDO) {
        driverDO.setDriverId(java.util.UUID.randomUUID().toString());
        driverDO.setDateCreated(new Date());
        jPAApi.em().persist(driverDO);
        return driverDO;
    }

    @Override
    public void delete(String driverId) throws ResourceNotFound {
        jPAApi.em().detach(find(driverId));
    }
    //method to search the repository
     @Override
     public List<JpaDriver> findBySearchString(String query, String operation) throws ResourceNotFound {
    	 List<JpaDriver> drivers = null;
    	 try {
    	  drivers = (List<JpaDriver>)resolveSearch(query, operation);
        }catch(NullPointerException e) { return null;}
    	 for(JpaDriver driver : drivers) {
    		 System.out.println("TOBI:    "+driver);
    	 }
    	 return drivers;
    }
     
     
    private static List<JpaDriver> listOfDrivers;
    
    //this method implements the core search procedure
    private synchronized List<JpaDriver> resolveSearch(String query, String operation) {
    	listOfDrivers = new Vector<>();
    	boolean generic = true;
    	if(operation.equalsIgnoreCase("generic")) {
    		generic = false;
    	    operation = "username";}
        Query q;
    	switch(operation) {
    		case "username":
    			 q = jPAApi.em().createNamedQuery("JpaDriver.findBySearchUsername");
    	    	 q.setParameter("username", "%"+query+"%");
    	    	 List<JpaDriver> driversResult =  q.getResultList();
  	    	     if( driversResult.size() > 0 ) {
  	    	    	driversResult.forEach((d)->{listOfDrivers.add(d);});
  	  	    	    
  	    	     }
  	    	     if(generic)
	    	    	 return listOfDrivers;
	    	     
    		case "online_status":
   			 	   q = jPAApi.em().createNamedQuery("JpaDriver.findBySearchOnlineStatus");
   	    	       q.setParameter("online_status","%"+query+"%");  
      	    	  driversResult =  q.getResultList();
  	    	     if( driversResult.size() > 0 ) {
  	    	    	driversResult.forEach((d)->{listOfDrivers.add(d);});
  	    	     }
  	    	     if(generic)
	    	    	 return listOfDrivers;
    		case "rating":
			 	   q = jPAApi.em().createNamedQuery("JpaDriver.findBySearchRating");
	    	       q.setParameter("rating","%"+query+"%"); 
	    	       utilityMethod(q);
	  	    	     if(generic)
		    	    	 return listOfDrivers;
    		case "manufacturer":
			 	   q = jPAApi.em().createNamedQuery("JpaDriver.findBySearchManufacturer");
	    	      q.setParameter("manufacturer", "%"+query+"%");  
	    	      utilityMethod(q);
	  	    	     if(generic)
		    	    	 return listOfDrivers;
    		case "engine_type":
			 	   q = jPAApi.em().createNamedQuery("JpaDriver.findBySearchEngineType");
	    	      q.setParameter("engine_type", "%"+query+"%");  
	    	      utilityMethod(q);
	  	    	     if(generic)
		    	    	 return listOfDrivers;
    		case "licence_plate":
			 	   q = jPAApi.em().createNamedQuery("JpaDriver.findBySearchLicencePlate");
	    	      q.setParameter("licence_plate", "%"+query+"%");  
	    	      utilityMethod(q);
	  	    	     if(generic)
		    	    	 return listOfDrivers;
    		case "model":
			 	   q = jPAApi.em().createNamedQuery("JpaDriver.findBySearchModel");
	    	      q.setParameter("model", "%"+query+"%"); 
	    	      utilityMethod(q);
	    	      return listOfDrivers;
    		case "all":
			 	  q = jPAApi.em().createNamedQuery("JpaDriver.findAll");
    	    	  driversResult =  q.getResultList();
   	    	     if( driversResult.size() > 0 ) {
   	    	    	driversResult.forEach((d)->{listOfDrivers.add(d); });
   	    	    	return listOfDrivers;
   	    	     }
   	    	default:
   	    		System.out.println("TOBI      >>>>   Invalid Parameter");
   	    		return listOfDrivers;
    	}
     }
   
   private void utilityMethod(Query q) {
   	List<JpaDriver> driversResult;
   	List<JpaCar> driversResultByCar;
       driversResultByCar =  q.getResultList();
    	 if( driversResultByCar.size() > 0 ) {
    	     driversResult  = driversResultByCar.stream().map((m)-> m.getOwner()).map(
    	    		 (d) -> {
    	    			 JpaDriver driver = null;
    	    		 try { driver = this.find(d);
    	    		 }catch(ResourceNotFound e) {}
    	    		 	return driver;
    	    		
    	    		 }).collect(Collectors.toList());
  	    	listOfDrivers.addAll(driversResult);
  	     }
   }
}