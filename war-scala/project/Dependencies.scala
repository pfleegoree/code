import sbt._

object Dependencies {
  lazy val warMain: Seq[ModuleID] = Seq(

  )

  lazy val warTest: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % "3.2.19"
  ).map(_ % Test)

  lazy val war: Seq[ModuleID] = warMain ++ warTest
}