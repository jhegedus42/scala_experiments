name := "experiment"

version := "1.0"

scalaVersion := "2.11.8"

val monocleVersion = "1.4.0"

libraryDependencies++= Seq(
  "com.lihaoyi"                %% "upickle"       % "0.4.4",
  "com.github.julien-truffaut" %% "monocle-core"  % monocleVersion,
  "com.github.julien-truffaut" %% "monocle-macro" % monocleVersion,
  "com.github.julien-truffaut" %% "monocle-law"   % monocleVersion % "test")

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.full)
