lazy val site = (project in file("site"))
  .settings(
    scalaVersion := "3.3.1",
    libraryDependencies ++= Seq(
      "ba.sake" %% "hepek" % "0.18.0"
    )
  )
  .enablePlugins(HepekPlugin)
