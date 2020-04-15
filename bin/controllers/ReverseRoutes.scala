// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Emmanuel/Desktop/backend_test_project/backend_test_project/service-gateway/conf/routes
// @DATE:Fri Apr 10 11:23:08 GMT+01:00 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers {

  // @LINE:16
  class ReverseApiHelpController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getResources(): Call = {
    
      () match {
      
        // @LINE:16
        case ()  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "api-docs.json")
      
      }
    
    }
  
    // @LINE:17
    def getResource(): Call = {
    
      () match {
      
        // @LINE:17
        case ()  =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/auth"))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "api-docs.json/auth")
      
      }
    
    }
  
  }

  // @LINE:11
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def preflight(all:String): Call = {
      
      Call("OPTIONS", _prefix + { _defaultPrefix } + implicitly[play.api.mvc.PathBindable[String]].unbind("all", all))
    }
  
    // @LINE:20
    def swagger(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "docs")
    }
  
    // @LINE:11
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:5
  class ReverseDriverController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def getDriver(driverId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "drivers/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("driverId", driverId)) + "/")
    }
  
    // @LINE:6
    def deleteDriver(driverId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "drivers/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("driverId", driverId)) + "/")
    }
  
    // @LINE:9
    def createDriver(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "drivers/")
    }
  
  }

  // @LINE:27
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def at(file:String): Call = {
    
      (file: @unchecked) match {
      
        // @LINE:27
        case (file)  =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "api-server/assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
      
      }
    
    }
  
  }


}
