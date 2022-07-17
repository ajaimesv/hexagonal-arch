package users.api.services

import users.api.model.{UserRequest, UserResponse}
import users.domain.model._
import users.domain.ports.UserService

import javax.inject.Inject

class UserApiService @Inject()(
  userService: UserService
) {

  def create(userRequest: UserRequest): UserResponse =
    UserResponse(
      userService.create(
        name = Name(userRequest.name),
        username = Username(userRequest.username),
        password = Password(userRequest.password)
      )
    )

  def read(id: String): UserResponse =
    UserResponse(userService.read(Id(id)))

}