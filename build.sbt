import com.typesafe.sbt.web.Import.WebKeys

scalaVersion in ThisBuild := "2.13.1"
scalafmtOnCompile in ThisBuild := true

lazy val root = (project in file("."))
  .settings(
    libraryDependencies ++= Seq(
      "ba.sake" %% "hepek" % "0.7.0+7-434764e4-SNAPSHOT"
    ),
    resolvers += Resolver.sonatypeRepo("snapshots"),
    (hepek in Compile) := {
      WebKeys.assets.value // run 'assets' after compiling...
      (hepek in Compile).value
    },
    WebKeys.webModulesLib := "site/lib",
    openIndexPage := openIndexPageTask.value
  )
  .enablePlugins(HepekPlugin, SbtWeb)

val openIndexPage = taskKey[Unit]("Opens index.html")

val openIndexPageTask = Def.taskDyn {
  Def.task {
    java.awt.Desktop
      .getDesktop()
      .browse(new File(hepekTarget.value + "/site/index.html").toURI)
  }
}
