package users.adapters.repository

import users.domain.model.{Id, Name, Password, User, Username}
import users.domain.ports.UserRepository

import scala.collection.mutable

class UserDb extends UserRepository {

  val data: mutable.Map[String, UserDbModel] = mutable.Map[String, UserDbModel]()

  override def create(name: Name, username: Username, password: Password): User = {
    val userDbModel = UserDbModel(name, username, password)
    data += (userDbModel.id -> userDbModel)
    userDbModel.toUser
  }

  override def read(id: Id): User =
    data(id.value).toUser

}
