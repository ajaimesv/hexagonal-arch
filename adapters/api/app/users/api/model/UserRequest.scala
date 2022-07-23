package users.api.model

import play.api.libs.json.{Json, Reads}

case class UserRequest(
  name: String,
  username: String,
  password: String
)

object UserRequest {

  implicit val reads: Reads[UserRequest] = Json.reads[UserRequest]

}
