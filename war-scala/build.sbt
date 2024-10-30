import sbt.Keys._
import sbt._

lazy val commonSettings = Seq(
  scalaVersion := "2.13.14"
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .aggregate(war)

lazy val war = (project in file("war"))
  .settings(commonSettings)
  .settings(
    name := "war",
    libraryDependencies ++= Dependencies.war
  )