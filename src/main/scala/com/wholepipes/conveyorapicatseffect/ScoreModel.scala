package com.wholepipes.conveyorapicatseffect

import cats.effect.IO
import com.wholepipes.conveyorapicatseffect.entities.Scores
import java.util.UUID
import cats.effect.Sync
import cats.implicits._
import scala.collection.mutable.ListBuffer

class ScoreModel[F[_]](private val scores: ListBuffer[Scores])(implicit e: Sync[F]) {
  val makeId: IO[String] = IO { UUID.randomUUID().toString }

  def getRecord(id: Long): IO[Option[Scores]] = IO { scores.find(_.id == id) }

  def addRecord(record: Scores): IO[String] =
    for {
      uuid <- makeId
      _ <- IO { scores += addScore(record, uuid) }
    } yield uuid

  def addScore(score: Scores, id: String): Scores =
    Scores(id, score.name, score.scores)

  def updateRecord(updatedRecord: Scores): F[Unit] = {
    for {
      _ <- e.delay { scores -= updatedRecord }
      _ <- e.delay { scores += updatedRecord }
    } yield()
  }

  def deleteRecord(recordId: String): IO[Unit] =
    IO{ scores.find(_.id == recordId).foreach(s => scores -= s) }

}
