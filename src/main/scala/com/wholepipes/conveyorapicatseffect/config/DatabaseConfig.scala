package com.wholepipes.conveyorapicatseffect.config
//import cats.data.NonEmptyList
import cats.effect._
//import cats.implicits._
import doobie._
import doobie.implicits._
//import doobie.hikari.HikariTransactor

//case class DatabaseConfig(
//    url: String,
//    driver: String,
//    user: String,
//    password: String,
//    connections: Int
//)

object DatabaseConfig {
  val xa: Transactor[IO] = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver",
    "jdbc:postgresql:myimdb",
    "docker",
    "docker"
  )

  def getAllScores: IO[List[String]] = {
    val findAllScoresQuery: doobie.Query0[String] =
      sql"select name from scores".query[String]
    val findAllScores: doobie.ConnectionIO[List[String]] =
      findAllScoresQuery.to[List]
    findAllScores.transact(xa)
  }

}
