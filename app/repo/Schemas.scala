package repo

import models.Pickup
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

protected object Schemas {

  trait Tables {
    this: HasDatabaseConfigProvider[JdbcProfile] =>

    import profile.api._

    lazy val pickupQuery = TableQuery[Pickups]

    class Pickups(tag: Tag) extends Table[models.Pickup](tag, _tableName = "pickups") {
      override def * = (id, orderName).mapTo[Pickup]

      def id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)

      def orderName = column[String]("order_name")
    }

  }
}
