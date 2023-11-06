import com.typesafe.sbt.web.Import.WebKeys

lazy val root = (project in file("."))
  .settings(
    scalaVersion := "3.3.1",
    libraryDependencies ++= Seq(
      "ba.sake" %% "hepek" % "0.15.0"
    ),
    scalacOptions ++= Seq(
      "-deprecation",
      "-Yretain-trees",
      "-Wunused:all"
    ),
    (Compile / hepek) := {
      WebKeys.assets.value // run 'assets' after compiling
      (Compile / hepek).value
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
