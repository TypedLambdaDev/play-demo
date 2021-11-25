package repo

import javax.inject.Inject
import models.Pickup
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import repo.Schemas.Tables
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class PickupRepo @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
                          (implicit executionContext: ExecutionContext)
  extends Tables with HasDatabaseConfigProvider[JdbcProfile] {



  import profile.api._

  def getById(id: Int): Future[Option[Pickup]] = db.run(pickupQuery.filter(_.id === id).result.headOption)
  //insert
  def insert(pickup: Pickup): Future[Pickup] = {
    db.run(pickupQuery returning pickupQuery += pickup)
  }

}
