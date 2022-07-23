package users.api.services

import play.api.libs.json.JsValue
import users.api.model.JsonEncoder.Implicits.UserJsonEncoder
import users.api.model.JsonEncoder.JsonEncoderOps
import users.api.model.UserRequest
import users.domain.model._
import users.domain.ports.UserService

import javax.inject.Inject

/*
 * Notice that these functions return JsValue instances instead of case classes like a "UserResponse".
 * Returning JsValue's makes adding business logic a difficult task, which is desired
 * in this layer since no domain rules should be applied here. We understand, there may be cases where this
 * is necessary, but if not, we will try to stick to JsValue's.
 */
class UserApiService @Inject()(
  userService: UserService
) {

  def create(userRequest: UserRequest): JsValue =
    userService.create(
      name = Name(userRequest.name),
      username = Username(userRequest.username),
      password = Password(userRequest.password)
    ).toJson

  def read(id: String): JsValue =
    userService.read(Id(id)).toJson

  def update(id: String, userRequest: UserRequest): JsValue =
    userService.update(
      id = Id(id),
      name = Name(userRequest.name),
      username = Username(userRequest.username),
      password = Password(userRequest.password)
    ).toJson

  def delete(id: String): Unit =
    userService.delete(Id(id))

}
