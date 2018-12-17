organization := "com.aggregator"
name := "cqrs-aggregator"
version := "1.0"
scalaVersion := "2.12.4"
packageName in Docker := "cqrs-aggregator"
dockerExposedPorts := Seq(8081)

libraryDependencies ++= Seq(
  "com.typesafe.akka"%% "akka-actor" % "2.5.18",
  "com.typesafe.akka"%% "akka-persistence"  % "2.5.18",
  "com.safety-data" %% "akka-persistence-redis" % "0.4.1"
)

unmanagedResourceDirectories in Compile += {
  baseDirectory.value / "src/main/resources"
}
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)
enablePlugins(AshScriptPlugin)

mainClass in Compile := Some("com.aggregator.Main")
dockerBaseImage := "openjdk:jre-alpine"