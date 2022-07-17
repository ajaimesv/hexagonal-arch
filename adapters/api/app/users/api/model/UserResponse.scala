package users.api.model

import play.api.libs.json.{Json, OFormat}
import users.domain.model.User

/**
 * Notice we are not including the password in the response.
 */
case class UserResponse(
  id: String,
  name: String,
  username: String
)

object UserResponse {

  implicit val format: OFormat[UserResponse] = Json.format[UserResponse]

  def apply(user: User): UserResponse =
    UserResponse(
      id = user.id.value,
      name = user.name.value,
      username = user.username.value
    )

}
