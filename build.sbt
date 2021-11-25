name := """dummy-dunzo"""
organization := "com.typedlambda"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.6"


libraryDependencies ++= Seq(
  guice,
  "com.typesafe.play" %% "play-slick" % "5.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
//  "org.postgresql" % "postgresql" % "42.2.12",
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "org.hsqldb" % "hsqldb" % "2.5.0"

)
// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.typedlambda.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.typedlambda.binders._"
