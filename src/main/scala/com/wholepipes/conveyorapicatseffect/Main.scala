package com.wholepipes.conveyorapicatseffect

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  def run(args: List[String]) =
    ConveyorapicatseffectServer.stream[IO].compile.drain.as(ExitCode.Success)
}
