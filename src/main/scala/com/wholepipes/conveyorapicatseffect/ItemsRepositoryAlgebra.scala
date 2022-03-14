package com.wholepipes.conveyorapicatseffect

import cats.data._

trait ItemsRepositoryAlgebra[F[_]] {
  def create(item: Items): F[Items]

  def update(item: Items): F[Option[Items]]

  def get(id: Long): F[Option[Items]]

  def delete(id: Long): F[Option[Items]]

  def findByName(name: NonEmptyList[String]): F[List[Items]]

  def list(): F[List[Items]]
}
