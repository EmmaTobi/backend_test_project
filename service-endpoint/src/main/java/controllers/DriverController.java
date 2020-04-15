/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import com.encentral.test_project.commons.exceptions.CarAlreadyInUseException;
import com.encentral.test_project.commons.models.DriverDTO;
import com.encentral.test_project.commons.models.CarDTO;
import com.encentral.test_project.commons.models.DriverMapper;
import com.encentral.test_project.commons.models.CarMapper;
import com.encentral.test_project.commons.util.MyObjectMapper;
import com.encentral.test_project.entities.JpaDriver;
import com.encentral.test_project.entities.JpaCar;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.encentral.test_project.user_management.api.DriverService;
import com.encentral.test_project.user_management.api.CarService;
import javax.inject.Inject;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import static play.mvc.Results.badRequest;
import java.util.List;
import java.util.*;

/**
 *
 * @author poseidon || emmanuelAgboola
 */

@Api(value = "Driver")
@Transactional
public class DriverController extends Controller {
	
    @Inject
    CarService carService;

    @Inject
    FormFactory formFactory;

    @Inject
    MyObjectMapper objectMapper;

    @Inject
    DriverService driverService;
    
    
    @ApiOperation(value = "Get All Drivers", notes = "This returns all the available drivers in repository", httpMethod = "GET")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done", response = CarDTO.class)
            }
    )
    public Result getAllDrivers() {
        try {
            return ok(Json.toJson(driverService.findAll()));
        } catch (ResourceNotFound ex){
            return notFound(ex.getMessage());
        }
    }

    @ApiOperation(value = "Update a Driver", notes = "", httpMethod = "PUT")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done")
            }
    )
    @ApiImplicitParams(
            {
                @ApiImplicitParam(
                        name = "Application",
                        dataType = "com.encentral.test_project.commons.models.DriverDTO",
                        required = true,
                        paramType = "body",
                        value = "Application"
                )
            }
    )  
    public Result updateDriver(String driverId) {
        Form<DriverDTO> bindFromRequest = formFactory.form(DriverDTO.class).bindFromRequest();
        if (bindFromRequest.hasErrors()) {
            return badRequest(bindFromRequest.errorsAsJson());

        }
        try {
        JpaDriver driverR = DriverMapper.driverDTotoJpaDriver(bindFromRequest.get());
        driverR.setDriverId(driverId); 
        JpaDriver update = driverService.update(driverR);
        return ok(Json.toJson(DriverMapper.jpaDriverToDriverDTO(update)));
        } catch (ResourceNotFound ex){
            return notFound(ex.getMessage());
        }
       
    }

    

    @ApiOperation(value = "Get Driver", notes = "", httpMethod = "GET")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done", response = DriverDTO.class)
            }
    )
    public Result getDriver(String driverId) {
        try {
            return ok(Json.toJson(DriverMapper.jpaDriverToDriverDTO(driverService.find(driverId))));
        } catch (ResourceNotFound ex){
            return notFound(ex.getMessage());
        }
    }

    @ApiOperation(value = "Create a Driver", notes = "", httpMethod = "POST")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done")
            }
    )
    @ApiImplicitParams(
            {
                @ApiImplicitParam(
                        name = "Application",
                        dataType = "com.encentral.test_project.commons.models.DriverDTO",
                        required = true,
                        paramType = "body",
                        value = "Application"
                )
            }
    )  
    public Result createDriver() {
        Form<DriverDTO> bindFromRequest = formFactory.form(DriverDTO.class).bindFromRequest();
        if (bindFromRequest.hasErrors()) {
            return badRequest(bindFromRequest.errorsAsJson());

        }
        JpaDriver create = driverService.create(DriverMapper.driverDTotoJpaDriver(bindFromRequest.get()));

        return ok(Json.toJson(DriverMapper.jpaDriverToDriverDTO(create)));
    }

    @ApiOperation(value = "Delete Driver", notes = "", httpMethod = "DELETE")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done")
            }
    )
    public Result deleteDriver(String driverId) {
        try {
            driverService.delete(driverId);
            return noContent();
        } catch (ResourceNotFound ex) {
            return notFound(ex.getMessage());
        }
    }

    
    @ApiOperation(value = "Select Car", notes = "To Select a Car you Are Currently Driving", httpMethod = "GET")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done", response = CarDTO.class)
            }
    ) //Helper Method for selecting car
    public Result selectSelfCar(String driverId, String carId) {
    	try {
    	JpaDriver driver = driverService.find(driverId);
    	String isDriverOnline = driver.getOnlineStatus();
    	JpaCar car = carService.find(carId);
    	if(isDriverOnline.equalsIgnoreCase("ONLINE") && !car.getCarAlreadyInUse() ) {
    		return this.getCar(driverId, carId);
    	}else {
    		return notFound("Sorry, Operation Failed");
    	}
    	}catch(ResourceNotFound ex) {
    		 return notFound(ex.getMessage());
    	}
    }
    
    private Result getCar(String driverId, String carId) {
        try {
        	JpaCar car = carService.find(carId);
        	if(!car.getCarAlreadyInUse()) {
        		car.setOwner(driverId);
        		car.setCarAlreadyInUse(true);//true sets a flag on a car object indicating it is NOT! available for drivers use
        		carService.update(car);
        		return ok(Json.toJson(CarMapper.jpaCarToCarDTO(car)));
        	}
        	else {
        		throw new CarAlreadyInUseException("The Selected Car is already in use by another driver, Try selcting another car");
        	}
        } catch (ResourceNotFound ex) {
            return notFound(ex.getMessage());
        }  catch (CarAlreadyInUseException ex) {
        	return notFound(ex.getMessage());
        }
   
    }
    
    @ApiOperation(value = "Deselect a car", notes = "", httpMethod = "DELETE")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done")
            }
    )
    //Helper Method for deselecting a car
    public Result deselectACar(String driverId, String carId) {
    	try {
    	JpaDriver driver = driverService.find(driverId);
    	JpaCar car = carService.find(carId);
    	String isDriverOnline = driver.getOnlineStatus();
    	
    	if(isDriverOnline.equalsIgnoreCase("ONLINE") && (driver.getSelectedCar().equals(carId)) ) {
    	       return deleteCar(carId);
    	}else {
    		return notFound("Sorry, Operation Failed");
    		}
    	}catch(ResourceNotFound ex) {
   		 	return notFound(ex.getMessage());
   	    }
    }
    
    private Result deleteCar(String carId) {
        try {
        	JpaCar car = carService.find(carId);
        	if(car.getCarAlreadyInUse()) {
        		car.setOwner("");
        		car.setCarAlreadyInUse(false);	//false sets a flag on a car object indicating it is available for drivers use
        		carService.update(car);
       	}
        	else {
        		throw new IllegalStateException("The Selected Car is already in use by another driver, Try selcting another car");
        	}
            return ok(Json.toJson(CarMapper.jpaCarToCarDTO(car)));
        } catch (Exception ex) {
            return notFound(ex.getMessage());
        }
    }
    

    @ApiOperation(value = "Search Driver Repository", 
      notes = "possible operations are { generic, username, online_status, rating, licence_plate, manufacturer, seat_count, engine_type }", httpMethod = "GET")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done")
            }
    )
    public Result search(String query, String operation) {
        try {
        	List<JpaDriver> results = driverService.findBySearchString(query, operation);
        	if(results == null )
        		throw new NullPointerException("Driver not Found");
        	LinkedHashSet<JpaDriver> r = new LinkedHashSet<>(results);
        	List<JpaDriver> rr = new Vector<>(results);
            return ok(Json.toJson(rr));
        } catch (ResourceNotFound ex){
            return notFound(ex.getMessage());
        }
        catch (NullPointerException ex){
            return notFound(ex.getMessage());
        }
    }
}
