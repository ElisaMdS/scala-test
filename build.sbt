ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val app = (project in file("app"))
  .settings(
    assembly / mainClass := Some("com.example.Main"),
  )