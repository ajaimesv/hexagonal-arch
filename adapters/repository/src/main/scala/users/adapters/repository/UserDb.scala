package users.adapters.repository

import users.domain.model._
import users.domain.ports.UserRepository

import scala.collection.mutable

class UserDb extends UserRepository {

  val database: mutable.Map[String, UserDbModel] = mutable.Map[String, UserDbModel]()

  override def create(name: Name, username: Username, password: Password): User = {
    val userDbModel = UserDbModel(name, username, password)
    database += (userDbModel.id -> userDbModel)
    userDbModel.toUser
  }

  override def read(id: Id): User =
    database(id.value).toUser

}
