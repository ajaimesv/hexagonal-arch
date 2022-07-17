package users.api.modules

import com.google.inject.AbstractModule
import users.adapters.repository.UserDb
import users.domain.ports.UserRepository

/*
 * To learn more about dependency injection:
 * https://www.playframework.com/documentation/2.8.x/ScalaDependencyInjection
 */
class ApplicationModule extends AbstractModule {

  override def configure: Unit = {
    bind(classOf[UserRepository]).to(classOf[UserDb])
  }

}
