import scala.language.postfixOps

ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "3.5.1"
val scalaTestVersion = "3.2.19"

lazy val root = (project in file("."))
  .settings(
    name := "narooma",
    idePackagePrefix := Some("org.nkcoder"),
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % scalaTestVersion,
      "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
      "org.scalatestplus" %% "scalacheck-1-18" % "3.2.19.0" % "test"
    )
  )
