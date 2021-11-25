package controllers

import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import javax.inject.{Inject, Singleton}
import models.Pickup
import play.api.libs.json.{JsValue, Json}
import repo.PickupRepo
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class Pickups @Inject()(pickupRepo: PickupRepo, val controllerComponents: ControllerComponents) extends BaseController {
  def index(): Action[AnyContent] = Action { implicit request =>
    Ok("pick up requests")
  }

  def getPickupRequest(id: Int): Action[AnyContent] = Action.async { implicit request =>
    pickupRepo.getById(id: Int).map{pickup => Ok(Json.toJson(pickup))}
  }

  def create(): Action[AnyContent] = Action.async { implicit request =>
    val pickup: Pickup = request.body.asJson.get.as[Pickup]
    pickupRepo.insert(pickup).map{p => Created(Json.toJson(p))}
  }
}
