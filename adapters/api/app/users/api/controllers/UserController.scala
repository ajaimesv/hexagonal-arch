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
    userApiService.create(request.body.as[UserRequest])
  }

  def read(id: String): Action[AnyContent] = Action { request: Request[AnyContent] =>
    Ok(userApiService.read(id))
  }

  def update(id: String): Action[JsValue] = Action(parse.json) { request: Request[JsValue] =>
    Ok(userApiService.update(id, request.body.as[UserRequest]))
  }

  def delete(id: String): Action[AnyContent] = Action { request: Request[AnyContent] =>
    userApiService.delete(id)
    NoContent
  }

}
