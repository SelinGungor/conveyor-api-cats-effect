//package com.wholepipes.conveyorapicatseffect.config
//
//import doobie._
//import doobie.implicits._
//import cats._
//import cats.effect._
//import cats.implicits._
//import doobie.hikari.HikariTransactor
//
//import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
//
////case class DatabaseConnectionsConfig(poolSize: Int)
////case class DatabaseConfig(
////    url: String,
////    driver: String,
////    user: String,
////    password: String,
////    connections: DatabaseConnectionsConfig
////)
//
//object OldDatabaseConfig {
//
//  val transactor: Resource[IO, HikariTransactor[IO]] =
//    for {
//      ce <- ExecutionContexts.fixedThreadPool[IO](32) // our connect EC
//      xa <- HikariTransactor.newHikariTransactor[IO](
//        "com.mysql.cj.jdbc.Driver", // driver classname
//        "jdbc:mysql://localhost:3306/conveyordb", // connect URL
//        "root", // username
//        "password", // password
//        ce // await connection here
//      )
//    } yield xa
//
//  def getItem[A](): IO[String] =
//    transactor.use(
//      (sql"select * from scores where id = '2'"
//        .query[String]
//        .unique)
//        .transact[IO]
//    )
//
//}
