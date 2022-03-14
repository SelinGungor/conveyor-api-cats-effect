package com.wholepipes.conveyorapicatseffect

sealed trait ValidationError extends Product with Serializable
case class ItemAlreadyExistsError(item: Items) extends ValidationError
case object ItemNotFoundError extends ValidationError
