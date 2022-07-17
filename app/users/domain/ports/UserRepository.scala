package users.domain.ports

import com.google.inject.ImplementedBy
import users.domain.model.{Id, Name, Password, User, Username}

@ImplementedBy(classOf[users.adapters.repository.UserDb])
trait UserRepository {

  def create(name: Name, username: Username, password: Password): User

  def read(id: Id): User

}
