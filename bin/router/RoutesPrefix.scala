// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Emmanuel/Desktop/backend_test_project/backend_test_project/service-gateway/conf/routes
// @DATE:Fri Apr 10 11:23:08 GMT+01:00 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
