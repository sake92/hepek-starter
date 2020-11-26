import com.typesafe.sbt.web.Import.WebKeys


lazy val root = (project in file("."))
  .settings(
    scalaVersion := "2.13.3",
    scalafmtOnCompile := true,
    libraryDependencies ++= Seq(
      "ba.sake" %% "hepek" % "0.8.5"
    ),
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
