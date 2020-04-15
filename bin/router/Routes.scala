// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Emmanuel/Desktop/backend_test_project/backend_test_project/service-gateway/conf/routes
// @DATE:Fri Apr 10 11:23:08 GMT+01:00 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  DriverController_0: controllers.DriverController,
  // @LINE:11
  HomeController_1: controllers.HomeController,
  // @LINE:16
  ApiHelpController_3: controllers.ApiHelpController,
  // @LINE:27
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    DriverController_0: controllers.DriverController,
    // @LINE:11
    HomeController_1: controllers.HomeController,
    // @LINE:16
    ApiHelpController_3: controllers.ApiHelpController,
    // @LINE:27
    Assets_2: controllers.Assets
  ) = this(errorHandler, DriverController_0, HomeController_1, ApiHelpController_3, Assets_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, DriverController_0, HomeController_1, ApiHelpController_3, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """drivers/""" + "$" + """driverId<[^/]+>/""", """controllers.DriverController.getDriver(driverId:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """drivers/""" + "$" + """driverId<[^/]+>/""", """controllers.DriverController.deleteDriver(driverId:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """drivers/""", """controllers.DriverController.createDriver()"""),
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api-docs.json""", """controllers.ApiHelpController.getResources"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api-docs.json/auth""", """controllers.ApiHelpController.getResource(path:String = "/auth")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api-server/api-docs.json""", """controllers.ApiHelpController.getResources"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api-server/api-docs.json/auth""", """controllers.ApiHelpController.getResource(path:String = "/auth")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """docs""", """controllers.HomeController.swagger()"""),
    ("""OPTIONS""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """all<.+>""", """controllers.HomeController.preflight(all:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api-server/assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_DriverController_getDriver0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("drivers/"), DynamicPart("driverId", """[^/]+""",true), StaticPart("/")))
  )
  private[this] lazy val controllers_DriverController_getDriver0_invoker = createInvoker(
    DriverController_0.getDriver(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DriverController",
      "getDriver",
      Seq(classOf[String]),
      "GET",
      this.prefix + """drivers/""" + "$" + """driverId<[^/]+>/""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_DriverController_deleteDriver1_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("drivers/"), DynamicPart("driverId", """[^/]+""",true), StaticPart("/")))
  )
  private[this] lazy val controllers_DriverController_deleteDriver1_invoker = createInvoker(
    DriverController_0.deleteDriver(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DriverController",
      "deleteDriver",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """drivers/""" + "$" + """driverId<[^/]+>/""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_DriverController_createDriver2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("drivers/")))
  )
  private[this] lazy val controllers_DriverController_createDriver2_invoker = createInvoker(
    DriverController_0.createDriver(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.DriverController",
      "createDriver",
      Nil,
      "POST",
      this.prefix + """drivers/""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_index3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index3_invoker = createInvoker(
    HomeController_1.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_ApiHelpController_getResources4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-docs.json")))
  )
  private[this] lazy val controllers_ApiHelpController_getResources4_invoker = createInvoker(
    ApiHelpController_3.getResources,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiHelpController",
      "getResources",
      Nil,
      "GET",
      this.prefix + """api-docs.json""",
      """ Swagger""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ApiHelpController_getResource5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-docs.json/auth")))
  )
  private[this] lazy val controllers_ApiHelpController_getResource5_invoker = createInvoker(
    ApiHelpController_3.getResource(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiHelpController",
      "getResource",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api-docs.json/auth""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_ApiHelpController_getResources6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-server/api-docs.json")))
  )
  private[this] lazy val controllers_ApiHelpController_getResources6_invoker = createInvoker(
    ApiHelpController_3.getResources,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiHelpController",
      "getResources",
      Nil,
      "GET",
      this.prefix + """api-server/api-docs.json""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_ApiHelpController_getResource7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-server/api-docs.json/auth")))
  )
  private[this] lazy val controllers_ApiHelpController_getResource7_invoker = createInvoker(
    ApiHelpController_3.getResource(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiHelpController",
      "getResource",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api-server/api-docs.json/auth""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_HomeController_swagger8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("docs")))
  )
  private[this] lazy val controllers_HomeController_swagger8_invoker = createInvoker(
    HomeController_1.swagger(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "swagger",
      Nil,
      "GET",
      this.prefix + """docs""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_HomeController_preflight9_route = Route("OPTIONS",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("all", """.+""",false)))
  )
  private[this] lazy val controllers_HomeController_preflight9_invoker = createInvoker(
    HomeController_1.preflight(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "preflight",
      Seq(classOf[String]),
      "OPTIONS",
      this.prefix + """""" + "$" + """all<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Assets_at10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api-server/assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at10_invoker = createInvoker(
    Assets_2.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """api-server/assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_Assets_at11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at11_invoker = createInvoker(
    Assets_2.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_DriverController_getDriver0_route(params@_) =>
      call(params.fromPath[String]("driverId", None)) { (driverId) =>
        controllers_DriverController_getDriver0_invoker.call(DriverController_0.getDriver(driverId))
      }
  
    // @LINE:6
    case controllers_DriverController_deleteDriver1_route(params@_) =>
      call(params.fromPath[String]("driverId", None)) { (driverId) =>
        controllers_DriverController_deleteDriver1_invoker.call(DriverController_0.deleteDriver(driverId))
      }
  
    // @LINE:9
    case controllers_DriverController_createDriver2_route(params@_) =>
      call { 
        controllers_DriverController_createDriver2_invoker.call(DriverController_0.createDriver())
      }
  
    // @LINE:11
    case controllers_HomeController_index3_route(params@_) =>
      call { 
        controllers_HomeController_index3_invoker.call(HomeController_1.index())
      }
  
    // @LINE:16
    case controllers_ApiHelpController_getResources4_route(params@_) =>
      call { 
        controllers_ApiHelpController_getResources4_invoker.call(ApiHelpController_3.getResources)
      }
  
    // @LINE:17
    case controllers_ApiHelpController_getResource5_route(params@_) =>
      call(Param[String]("path", Right("/auth"))) { (path) =>
        controllers_ApiHelpController_getResource5_invoker.call(ApiHelpController_3.getResource(path))
      }
  
    // @LINE:18
    case controllers_ApiHelpController_getResources6_route(params@_) =>
      call { 
        controllers_ApiHelpController_getResources6_invoker.call(ApiHelpController_3.getResources)
      }
  
    // @LINE:19
    case controllers_ApiHelpController_getResource7_route(params@_) =>
      call(Param[String]("path", Right("/auth"))) { (path) =>
        controllers_ApiHelpController_getResource7_invoker.call(ApiHelpController_3.getResource(path))
      }
  
    // @LINE:20
    case controllers_HomeController_swagger8_route(params@_) =>
      call { 
        controllers_HomeController_swagger8_invoker.call(HomeController_1.swagger())
      }
  
    // @LINE:25
    case controllers_HomeController_preflight9_route(params@_) =>
      call(params.fromPath[String]("all", None)) { (all) =>
        controllers_HomeController_preflight9_invoker.call(HomeController_1.preflight(all))
      }
  
    // @LINE:27
    case controllers_Assets_at10_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at10_invoker.call(Assets_2.at(path, file))
      }
  
    // @LINE:28
    case controllers_Assets_at11_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at11_invoker.call(Assets_2.at(path, file))
      }
  }
}
