package users.adapters.repository

import users.domain.model._
import users.domain.ports.UserRepository

import scala.collection.mutable

class UserDb extends UserRepository {

  val database: mutable.Map[String, UserDbModel] = mutable.Map[String, UserDbModel]()

  /*
   * Id's are assigned here because it is the repository the one in charge of them.
   * For example, a database may have a column that automatically assigns id's.
   */
  override def create(name: Name, username: Username, password: Password): User = {
    val userDbModel = UserDbModel(name, username, password)
    database += userDbModel.id -> userDbModel
    userDbModel.toUser
  }

  override def read(id: Id): User =
    database(id.value).toUser

  /*
   * We pass fields instead of case classes because we may only allow to update some
   * fields. Additionally, some fields may exist only in the repository layer (like
   * createdAt and updatedAt) which cannot be updated in other layers.
   * By passing specific fields we can create other functions like updatePassword,
   * updateName, etc.
   */
  override def update(id: Id, name: Name, username: Username, password: Password): User = {
    val userDbModel = database(id.value)
    val updated = UserDbModel(userDbModel, name, username, password)
    database += id.value -> updated
    updated.toUser
  }

  override def delete(id: Id): Unit =
    database -= id.value

}
