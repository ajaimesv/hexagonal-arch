package users.api.model

import play.api.libs.json.{JsValue, Json}
import users.domain.model.User


object JsonEncoder {

  trait JsonEncoder[A] {
    def toJson(a: A): JsValue
  }

  object Implicits {

    /**
     * Notice we are not including the password in the response.
     */
    implicit object UserJsonEncoder extends JsonEncoder[User] {
      override def toJson(u: User): JsValue = Json.obj(
        "id" -> u.id.value,
        "name" -> u.name.value,
        "username" -> u.username.value
        )
    }

  }

  implicit class JsonEncoderOps[A](a: A) {
    def toJson(implicit enc: JsonEncoder[A]): JsValue =
      enc.toJson(a)
  }

}
