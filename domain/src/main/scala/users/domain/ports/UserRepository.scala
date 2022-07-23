package users.domain.ports

import users.domain.model.{Id, Name, Password, User, Username}

/*
 * Notice no 'ImplementedBy' annotation is used.
 * UserRepository implementations are configured via api / users.api.modules.ApplicationModule.
 * This is to avoid circular references in build.sbt, because repository depends on domain, but
 * we cannot let domain depend on repository as well.
 */
trait UserRepository {

  def create(name: Name, username: Username, password: Password): User

  def read(id: Id): User

  def update(id: Id, name: Name, username: Username, password: Password): User

  def delete(id: Id): Unit

}
