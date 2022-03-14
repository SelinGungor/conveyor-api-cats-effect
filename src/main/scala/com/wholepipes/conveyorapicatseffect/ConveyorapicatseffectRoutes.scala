package com.wholepipes.conveyorapicatseffect

import cats.effect.Sync
import cats.implicits._
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
//import entities.Scores

object ConveyorapicatseffectRoutes {

//  val scoreModel = Scores.empty.unsafeRunSync()
//
//
  def scoreRoutes[F[_]: Sync](S: ScoreModel[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "scores" / id =>
      for {
        result <- S.getRecord(id)
        resp <- Ok(result)
      } yield resp
    }
  }

//  case GET -> Root / HUTS / hutId =>
//  hutRepo.getHut(hutId)
//    .flatMap(_.fold(NotFound())(Ok(_)))

  def jokeRoutes[F[_]: Sync](J: Jokes[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "joke" =>
      for {
        joke <- J.get
        resp <- Ok(joke)
      } yield resp
    }
  }

  def helloWorldRoutes[F[_]: Sync](H: HelloWorld[F]): HttpRoutes[F] = {
    val dsl = new Http4sDsl[F] {}
    import dsl._
    HttpRoutes.of[F] { case GET -> Root / "hello" / name =>
      for {
        greeting <- H.hello(HelloWorld.Name(name))
        resp <- Ok(greeting)
      } yield resp
    }
  }
}
