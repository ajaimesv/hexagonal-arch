package users.adapters.api

import play.api.libs.json.{Json, OFormat}

case class UserRequest(
  name: String,
  username: String,
  password: String
)

object UserRequest {

  implicit val format: OFormat[UserRequest] = Json.format[UserRequest]

}
