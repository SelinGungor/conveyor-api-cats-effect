package com.wholepipes.conveyorapicatseffect

import cats.Functor
import cats.data._
import cats.Monad
import cats.syntax.all._

class ItemService[F[_]](
    repository: ItemsRepositoryAlgebra[F],
    validation: ItemValidationAlgebra[F]
) {
  def create(
      item: Items
  )(implicit M: Monad[F]): EitherT[F, ValidationError, Items] =
    for {
      _ <- validation.doesNotExist(item)
      saved <- EitherT.liftF(repository.create(item))
    } yield saved

  def get(id: Long)(implicit
      F: Functor[F]
  ): EitherT[F, ItemNotFoundError.type, Items] =
    EitherT.fromOptionF(repository.get(id), ItemNotFoundError)

  def delete(id: Long)(implicit F: Functor[F]): F[Unit] =
    repository.delete(id).as(())

  def list(): F[List[Items]] =
    repository.list()

  def findByName(name: NonEmptyList[String]): F[List[Items]] =
    repository.findByName(name)
}

object ItemService {
  def apply[F[_]](
      repository: ItemsRepositoryAlgebra[F],
      validation: ItemValidationAlgebra[F]
  ): ItemService[F] =
    new ItemService[F](repository, validation)
}
