val Http4sVersion = "0.23.10"
val CirceVersion = "0.14.1"
val MunitVersion = "0.7.29"
val LogbackVersion = "1.2.10"
val MunitCatsEffectVersion = "1.0.7"
val DoobieVersion = "1.0.0-RC1"
val FlywayVersion = "8.5.2"
val CatsVersion = "2.6.1"
val NewTypeVersion = "0.4.4"

lazy val root = (project in file("."))
  .settings(
    organization := "com.wholepipes",
    name := "conveyor-api-cats-effect",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % CatsVersion,
      "org.http4s" %% "http4s-ember-server" % Http4sVersion,
      "org.http4s" %% "http4s-ember-client" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "io.circe" %% "circe-generic" % CirceVersion,
      "org.scalameta" %% "munit" % MunitVersion % Test,
      "org.typelevel" %% "munit-cats-effect-3" % MunitCatsEffectVersion % Test,
      "org.typelevel" %% "cats-effect" % "3.3.7",
      "ch.qos.logback" % "logback-classic" % LogbackVersion % Runtime,
      "org.scalameta" %% "svm-subs" % "20.2.0",
      "org.tpolecat" %% "doobie-core" % DoobieVersion,
      "org.tpolecat" %% "doobie-h2" % DoobieVersion,
      "org.tpolecat" %% "doobie-scalatest" % DoobieVersion,
      "mysql" % "mysql-connector-java" % "5.1.34",
      "org.flywaydb" % "flyway-core" % FlywayVersion,
      "org.tpolecat" %% "doobie-postgres" % DoobieVersion,
      "org.tpolecat" %% "doobie-hikari" % DoobieVersion,
      "io.estatico" %% "newtype" % NewTypeVersion
    ),
    addCompilerPlugin(
      "org.typelevel" %% "kind-projector" % "0.13.2" cross CrossVersion.full
    ),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    testFrameworks += new TestFramework("munit.Framework")
  )
