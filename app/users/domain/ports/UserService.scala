package users.domain.ports

import users.domain.model.{Id, Name, Password, User, Username}

import javax.inject.Inject

class UserService @Inject()(
  userRepository: UserRepository
) {

  def create(name: Name, username: Username, password: Password): User =
    userRepository.create(name, username, password)

  def read(id: Id): User =
    userRepository.read(id)

}
