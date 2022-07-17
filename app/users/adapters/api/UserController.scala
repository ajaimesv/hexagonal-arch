package users.adapters.api

import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents, Request}

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
