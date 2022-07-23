package users.domain.ports

import users.domain.model.{Id, Name, Password, User, Username}

import javax.inject.Inject

/*
 * UserRepository implementations are configured via api / users.api.modules.ApplicationModule.
 */
class UserService @Inject()(
  userRepository: UserRepository
) {

  def create(name: Name, username: Username, password: Password): User =
    userRepository.create(name, username, password)

  def read(id: Id): User =
    userRepository.read(id)

  def update(id: Id, name: Name, username: Username, password: Password): User =
    userRepository.update(id, name, username, password)

  def delete(id: Id): Unit =
    userRepository.delete(id)

}
