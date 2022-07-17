package users.adapters.repository

import users.domain.model._

import java.util.UUID

case class UserDbModel(
  id: String,
  name: String,
  username: String,
  password: String
) {

  def toUser: User =
    User(id = Id(id),
      name = Name(name),
      username = Username(username),
      password = Password(password)
    )

}

object UserDbModel {

  def apply(name: Name, username: Username, password: Password): UserDbModel =
    UserDbModel(
      id = UUID.randomUUID.toString,
      name = name.value,
      username = username.value,
      password = password.value
    )

}
