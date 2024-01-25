name := "TheatricalPlayersRefactoringKata"

version := "1.0"
scalaVersion := "2.11.12"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % "test"

// set the main class for the main 'sbt run' task
mainClass in (Compile, run) := Some("app.TheatricalPlayerApp")