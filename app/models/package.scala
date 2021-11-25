import play.api.libs.json.{Json, OFormat}

package object models {

  case class Pickup(id: Int, orderName: String) extends Product with Serializable
  object Pickup {
    implicit val pickupJsonFormat: OFormat[Pickup] = Json.format[Pickup]//controller
    val tupled = (this.apply _).tupled//db
  }

}
