package com.wholepipes.conveyorapicatseffect

import cats.data.EitherT

trait ItemValidationAlgebra[F[_]] {

  def exists(itemId: Option[Long]): EitherT[F, ItemAlreadyExistsError, Unit]

  def doesNotExist(item: Items): EitherT[F, ItemNotFoundError.type, Unit]

}
