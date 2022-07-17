package users.api.controllers

import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import users.api.model.UserRequest
import users.api.services.UserApiService

import javax.inject.Inject

class UserController @Inject()(
  userApiService: UserApiService,
  val controllerComponents: ControllerComponents
) extends BaseController {

  def create: Action[JsValue] = Action(parse.json) { request: Request[JsValue] =>
    Ok(Json.toJson(userApiService.create(request.body.as[UserRequest])))
  }

  def read(id: String): Action[AnyContent] = Action { request: Request[AnyContent] =>
    Ok(Json.toJson(userApiService.read(id)))
  }

}
