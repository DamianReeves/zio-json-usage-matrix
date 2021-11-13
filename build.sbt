ThisBuild / organization := "com.damianreeves"
ThisBuild / scalaVersion := Scala213
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val commonLibrarySettings = Seq(
  libraryDependencies ++= Seq(
    "dev.zio" %%% "zio"          % Version.zio,
    "dev.zio" %%% "zio-json"     % Version.zioJson,
    "dev.zio" %%% "zio-test"     % Version.zio % Test,
    "dev.zio" %%% "zio-test-sbt" % Version.zio % Test
  )
)

lazy val example = (projectMatrix in file("example"))
  .settings(
    name := "example"
  )
  .settings(commonLibrarySettings)
  .settings(testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"))
  .jvmPlatform(scalaVersions = ScalaVersions)
  .jsPlatform(scalaVersions = ScalaVersions)

//----------------------------------------------------------------------------
lazy val Scala213       = "2.13.7"
lazy val Scala3         = "3.1.0"
lazy val Scala2Versions = List(Scala213)
lazy val Scala3Versions = List(Scala3)
lazy val ScalaVersions  = Scala2Versions ++ Scala3Versions

lazy val Version = new {
  val zio     = "1.0.12"
  val zioJson = "0.2.0-M2"
}
