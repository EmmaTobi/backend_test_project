// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Emmanuel/Desktop/backend_test_project/backend_test_project/service-gateway/conf/routes
// @DATE:Fri Apr 10 11:23:08 GMT+01:00 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers.javascript {

  // @LINE:16
  class ReverseApiHelpController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getResources: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiHelpController.getResources",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api-docs.json"})
          }
        
        }
      """
    )
  
    // @LINE:17
    def getResource: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiHelpController.getResource",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api-docs.json/auth"})
          }
        
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def preflight: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.preflight",
      """
        function(all0) {
          return _wA({method:"OPTIONS", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("all", all0)})
        }
      """
    )
  
    // @LINE:20
    def swagger: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.swagger",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "docs"})
        }
      """
    )
  
    // @LINE:11
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseDriverController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def getDriver: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DriverController.getDriver",
      """
        function(driverId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "drivers/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("driverId", driverId0)) + "/"})
        }
      """
    )
  
    // @LINE:6
    def deleteDriver: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DriverController.deleteDriver",
      """
        function(driverId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "drivers/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("driverId", driverId0)) + "/"})
        }
      """
    )
  
    // @LINE:9
    def createDriver: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.DriverController.createDriver",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "drivers/"})
        }
      """
    )
  
  }

  // @LINE:27
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api-server/assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
          }
        
        }
      """
    )
  
  }


}
