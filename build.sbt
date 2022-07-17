ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = project
  .in(file("."))
  .settings(
    name := "users"
  )
  .dependsOn(api)


lazy val api = project
  .in(file("adapters/api"))
  .enablePlugins(PlayScala)
  .settings(
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
    )
  )
  .dependsOn(domain, repository)


lazy val domain = project
  .in(file("domain"))
  .settings(
    libraryDependencies ++= Seq(
      "javax.inject" % "javax.inject" % "1"
    )
  )


lazy val repository = project
  .in(file("adapters/repository"))
  .dependsOn(domain)
